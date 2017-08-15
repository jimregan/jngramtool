package ie.tcd.slscs.itut.bundles;

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
import ie.tcd.slscs.itut.ngramtool.NGram;

import java.util.HashMap;
import java.util.List;
import java.util.ArrayList;
import java.util.Map;
import java.util.Set;
import java.util.Arrays;

public class Utils {
	/**
	 * join a string list into a single string
	 * @param l list to be joined
	 * @param joiner separator string
	 * @return joined string
	 */
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
	/**
	 * join a string set into a single string
	 * @param l set to be joined
	 * @param joiner separator string
	 * @return joined string
	 */
    public static String join(Set<String> l, String joiner) {
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
	/**
	 * join a string array into a single string
	 * @param a array to be joined
	 * @param joiner separator string
	 * @return joined string
	 */
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
    /**
     * trim spaces from start and end of a string
     * @param s input string
     * @return string with leading and trailing spaces removed
     */
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
        if(end <= 0) {
            return "";
        } else {
            return s.substring(start, end+1);
        }
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
            if("".equals(sent)) {
                continue;
            }
            boolean last_alphanum = false;
            boolean last_s = false;
            char[] chara = sent.toCharArray();
            for (int i = 0; i < chara.length; i++) {
                if(Character.isLetterOrDigit(chara[i])) {
                    last_alphanum = true;
                    cur += chara[i];
                    if(chara[i] == 's') {
                        last_s = true;
                    }
                } else if(chara[i] == ' ') {
                        cur += ' ';
                        last_s = last_alphanum = false;
                } else if(chars.contains(chara[i])) {
                    if(i == 0) {
                        last_s = last_alphanum = false;
                        continue;
                    } else if(chara[i] == '[' && i < chara.length-3 && Character.isLetterOrDigit(chara[i+1]) && chara[i+2] == ']') {
                        cur += chara[i+1];
                        i += 2;
                        last_alphanum = true;
                        if(chara[i+1] == 's') {
                            last_s = true;
                        }
                    } else if(Character.getType(chara[i]) == Character.DASH_PUNCTUATION && Character.isDigit(chara[i-1]) && i < chara.length-2 && Character.isDigit(chara[i+1])) {
                        cur += '-';
                        last_s = last_alphanum = false;
                    } else {
                        last_s = last_alphanum = false;
                        if(!"".equals(trim(cur))) {
                            ret.add(trim(cur));
                            cur = "";
                        }
                        cur = "";
                        if (i == chara.length-1)
                        continue;
                    }
                } else if(cond.contains(chara[i])) {
                    if(i == 0 || i == chara.length || chara[i-1] == ' ') {
                        last_s = last_alphanum = false;
                        if(!"".equals(trim(cur))) {
                            ret.add(trim(cur));
                            cur = "";
                        } else {
                            if(!"".equals(cur)) {
                                cur = "";
                            }
                        }
                    } else if(i < chara.length-1 && Character.isLetterOrDigit(chara[i-1]) && Character.isLetterOrDigit(chara[i+1])) {
                        if(chara[i] == '’') {
                            cur += '\'';
                        } else {
                            cur += chara[i];
                        }
                        last_s = last_alphanum = false;
                    } else if(!last_s && (chara[i] == '’' || chara[i] == '\'')) {
                        last_s = last_alphanum = false;
                        if(!"".equals(trim(cur))) {
                            ret.add(trim(cur));
                            cur = "";
                        } else {
                            if(!"".equals(cur)) {
                                cur = "";
                            }
                        }
                    } else if(last_s && (chara[i] == '’' || chara[i] == '\'')) {
                        last_s = last_alphanum = false;
                        cur += '\'';
                    } else {
                        last_s = last_alphanum = false;
                        if(!"".equals(trim(cur))) {
                            ret.add(trim(cur));
                            cur = "";
                        } else {
                            if(!"".equals(cur)) {
                                cur = "";
                            }
                        }
                    }
                } else {
                    cur += chara[i];
                    last_s = last_alphanum = false;
                }

            }
            if(!"".equals(trim(cur))) {
                ret.add(trim(cur));
                cur = "";
                continue;
            }
        }
        if(!"".equals(trim(cur))) {
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

    public static List<String> getBundles(List<String> subsentences, int arity) {
        List<String> ret = new ArrayList<String>();
        for(String s : subsentences) {
            String[] words = s.split(" ");
            if(words.length < arity) {
                continue;
            }
            for(int i=0; i < words.length-arity+1; i++) {
                String[] tmp = Arrays.copyOfRange(words, i, i+arity);
                ret.add(join(tmp, " "));
            }
        }
        return ret;
    }

    public static String getPreGram(String[] s, int arity) {
        if(arity > s.length) {
            return null;
        }
        return Utils.join(Arrays.copyOfRange(s, 0, arity), " ");
    }

    public static String getPreGram(String s, int arity) {
        String grams[] = s.split(" ");
        return getPreGram(grams, arity);
    }

    public static String getPostGram(String[] s, int arity) {
        if(arity > s.length) {
            return null;
        }
        return Utils.join(Arrays.copyOfRange(s, s.length-arity, arity+1), " ");
    }
    public static String getPostGram(String s, int arity) {
        String grams[] = s.split(" ");
        return getPostGram(grams, arity);        
    }

    public static String markMatches(String s, String find, String pre, String post) {
        StringBuilder out = new StringBuilder();
        int len = s.length();
        int pos = -1;
        int lastpos = 0;
        while((pos = s.indexOf(find, pos+1)) != -1) {
            out.append(s.substring(lastpos, pos));
            out.append(pre);
            out.append(s.substring(pos, pos+find.length()));
            out.append(post);
            pos += find.length()-1;
            lastpos = pos+1;
        }
        return out.toString();
    }

    public static String markBundleMatches(String s, String find, String pre, String post) {
        StringBuilder out = new StringBuilder();
        int len = s.length();
        int pos = -1;
        int lastpos = 0;
        while((pos = s.toLowerCase().indexOf(find.toLowerCase(), pos+1)) != -1) {
            int last_match = s.length() - find.length() - 1;
            if(((pos == 0) || (pos > 0 && s.charAt(pos-1) == ' ')) 
              || ((pos == last_match) || (pos < last_match && s.charAt(pos+find.length()+1) == ' '))) {
                out.append(s.substring(lastpos, pos));
                out.append(pre);
                out.append(s.substring(pos, pos+find.length()));
                out.append(post);
                pos += find.length()-1;
                lastpos = pos+1;
            } else {
                continue;
            }
        }
        return out.toString();
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
