package ie.tcd.slscs.bundles;

/*
 * Copyright 2016 Jim O'Regan <jaoregan@tcd.ie>
 *
 * Permission is hereby granted, free of charge, to any person obtaining a
 * copy of this software and associated documentation files (the "Software"),
 * to deal in the Software without restriction, including without limitation
 * the rights to use, copy, modify, merge, publish, distribute, sublicense,
 * and/or sell copies of the Software, and to permit persons to whom the
 * Software is furnished to do so, subject to the following conditions:
 *
 * The above copyright notice and this permission notice shall be included in
 * all copies or substantial portions of the Software.
 *
 * THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
 * IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
 * FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT.  IN NO EVENT SHALL
 * THE AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
 * LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING
 * FROM, OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER
 * DEALINGS IN THE SOFTWARE.
 */
import ie.tcd.slscs.ngramtool.NGram;

import java.util.HashMap;
import java.util.List;
import java.util.ArrayList;
import java.util.Map;

public class Utils {
    public static String join(List<String> l, String joiner) {
        StringBuilder sb = new StringBuilder();
        boolean start = true;
        for (String s : l) {
            if (start) {
                start = false;
            } else {
                sb.append(joiner);
            }
            sb.append(s);
        }
        return sb.toString();
    }
    public static String join(String[] a, String joiner) {
        StringBuilder sb = new StringBuilder();
        boolean start = true;
        for (String s : a) {
            if (start) {
                start = false;
            } else {
                sb.append(joiner);
            }
            sb.append(s);
        }
        return sb.toString();
    }
    public static String trim(String s) {
        char[] chars = s.toCharArray();
        int start = 0;
        int end = s.length() - 1;

        for(int i = 0; i < s.length(); i++) {
            if(chars[i] == ' ') {
                start++;
            } else {
                break;
            }
        }
        for(int i = end; i >= 0; i--) {
            if(chars[i] == ' ') {
                end--;
            } else {
                break;
            }
        }
        return s.substring(start, end+1);
    }
    public static List<String> getSubSentences(List<String> sentences, String split) {
        List<Character> chars = new ArrayList<Character>();
        List<String> ret = new ArrayList<String>();
        String cur = "";
        for(char c : split.toCharArray()) {
            chars.add(c);
        }
        for (String sent : sentences) {
            for (char c : sent.toCharArray()) {
                if(chars.contains(c)) {
                    if(cur != "") {
                        ret.add(trim(cur));
                        cur = "";
                    }
                } else {
                    if(cur == "" && c == ' ') {
                        continue;
                    } else {
                        cur += c;
                    }
                }
            }
            if(cur != "") {
                ret.add(trim(cur));
                cur = "";
            }
        }
        if(cur != "") {
            ret.add(trim(cur));
        }
        return ret;
    }
    public static List<String> getSubSentences(List<String> l) {
        return getSubSentences(l, ",;()‘’“”\"–—");
    }

    public static List<String> getSafeSubSentences(List<String> sentences, String split, String conditional) {
        List<Character> chars = new ArrayList<Character>();
        List<Character> cond = new ArrayList<Character>();
        List<String> ret = new ArrayList<String>();
        String cur = "";
        for(char c : conditional.toCharArray()) {
            cond.add(c);
        }
        for(char c : split.toCharArray()) {
            chars.add(c);
        }
        for (String sent : sentences) {
            boolean last_alphanum = false;
            boolean last_s = false;
            char[] chara = sent.toCharArray();
            for (int i = 0; i < chara.length; i++) {
                if(i < chara.length-1) {
                    if(chars.contains(chara[i]) {
                        ret.add(cur);
                        last_s = last_alphanum = false;
                        cur = "";
                    } else if(Character.isLetterOrDigit(chara[i-1]) && cond.contains(chara[i]) && Character.isLetterOrDigit(chara[i+1])) {
                        cur += chara[i];
                        last_s = last_alphanum = false;
                    } else if(chara[i] == 's') {
                        last_s = last_alphanum = true;
                    } else if(last_s && (chara[i] == '’' || chara[i] == '\'')) {
                        last_s = last_alphanum = false;
                        cur += '\'';
                    }
                }
                char c = chara[i];
                if(cond.contains(c)) {
                    if(last_s) {
                        if {
                            cur += '\'';
                        } else {
                            cur += c;
                        }
                    }
                }
                // Check if is alpha/digit
                if(c == 's') {
                    last_s = true;
                    last_alphanum = true;
                } else if (Character.isLetterOrDigit(c)) {
                    last_alphanum = true;
                }
                if(chars.contains(c)) {
                    if(cur != "") {
                        ret.add(trim(cur));
                        cur = "";
                    }
                } else {
                    if(cur == "" && c == ' ') {
                        continue;
                    } else {
                        cur += c;
                    }
                }
            }
            if(cur != "") {
                ret.add(trim(cur));
                cur = "";
            }
        }
        if(cur != "") {
            ret.add(trim(cur));
        }
        return ret;
    }
    public static void addOrIncrement(Map<String, Integer> m, String s) {
        if(m.get(s) == null) {
            m.put(s, 1);
        } else {
            m.put(s, m.get(s) + 1);
        }
    }

    public static boolean isAnyWhitespace(char c) {
        if(c == '\u00A0' || c == '\u2007' || c == '\u202F') {
            return true;
        } else {
            return Character.isWhitespace(c);
        }
    }
    public static String stripSpace(String s) {
        StringBuilder sb = new StringBuilder();
        boolean sawspace = false;
        for(char c : s.toCharArray()) {
            if(sawspace && isAnyWhitespace(c)) {
                continue;
            } else {
                sb.append(c);
                if(Character.isWhitespace(c)) {
                    sawspace = true;
                } else {
                    sawspace = false;
                }
            }
        }
        return sb.toString();
    }

    public static String fix2000sPDF(String s) {
        return s.replaceAll("eÎ", "ę")
                .replaceAll("oÂ", "ó")
                .replaceAll("¯", "fl")
                .replaceAll("oÈ", "ö")
                .replaceAll("®", "fi")
                .replaceAll("±", "–");
    }
    public static String fix2010sPDF(String s) {
        return s.replaceAll("e˛", "ę")
                .replaceAll("a˛", "ą")
                .replaceAll(" !/", "‒")
                .replaceAll("\\*", "‒")
                .replaceAll("sˇ", "š")
                .replaceAll("o¨", "ö")
                .replaceAll("u¨", "ü")
                .replaceAll("a¨", "ä")
                .replaceAll("\\.\\.\\.", "…")
                .replaceAll("\\. \\. \\. \\.", "…")
                .replaceAll("\\. \\. \\.", "…");
    }
}
