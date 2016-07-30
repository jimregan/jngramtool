package ie.tcd.slscs.kfclone;
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

import java.util.ArrayList;
import java.util.List;

public class StringUtils {
    private static boolean isPunct(char c, boolean hyphen) {
        if (c == '.' || c == ',' || c == '\'') {
            return true;
        } else if (hyphen && c == '-') {
            return true;
        } else {
            return false;
        }
    }
    public static String replacePunctWithSpace(String s) {
        String out = "";
        for (char c : s.toCharArray()) {
            if (isPunct(c, true)) {
                out += ' ';
            } else {
                out += c;
            }
        }
        return out;
    }
    public static String replaceNonInternalPunctWithSpace(String s, boolean hyphen) {
        String out = "";
        char[] chars = s.toCharArray();
        int len = chars.length;
        for (int i = 0; i <=len; i++) {
            if(hyphen && chars[i] == '-') {
                continue;
            }
            if (isPunct(chars[i], !hyphen)) {
                if (i == 0 || i == len) {
                    out += ' ';
                } else if ((chars[i-1] == ' ') && (chars[i+i] == ' ' || isPunct(chars[i+1], true))) {
                    out += ' ';
                } else {
                    out += chars[i];
                }
            } else {
                out += chars[i];
            }
        }
        return out;
    }

    public static String observeTreatAsToken(String s, Config cfg) {
        String out = "";
        for (char c : replacePunctWithSpace(s).toCharArray()) {
            if(cfg.isTokenChar(c)) {
                out += ' ';
                out += c;
            } else {
                out += c;
            }
        }
        return out;
    }

    private static boolean isNum(char c) {
        if (c <= '9' && c >= '0') {
            return true;
        } else {
            return false;
        }
    }

    public static String replaceNumbers(String s, char replacement) {
        String out = "";
        for (char c : s.toCharArray()) {
            if (isNum(c)) {
                out += replacement;
            } else {
                out += c;
            }
        }
        return out;
    }
    public static String replaceNumbers(String s) {
        return replaceNumbers(s, '#');
    }

    public static String replaceAllNumbers(String s, char replacement) {
        String out = "";
        boolean numberSeen = false;
        for (char c : s.toCharArray()) {
            if (isNum(c)) {
                if (!numberSeen) {
                    out += replacement;
                    numberSeen = true;
                } else {
                    continue;
                }
            } else {
                out += c;
                numberSeen = false;
            }
        }
        return out;
    }
    public static String replaceAllNumbers(String s) {
        return replaceAllNumbers(s, '#');
    }

    public static String getIndexString(String s, String keep) {
        String out = "";
        List<Character> kc = new ArrayList<Character>();
        for (char c : keep.toCharArray()) {
            kc.add(c);
        }
        for (char c : s.toCharArray()) {
            if (kc.contains(c)) {
                out += c;
            } else {
                out += ' ';
            }
        }
        return out;
    }

    public static String getIndexString(String s) {
        String keep = "0123456789ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyzÀÁÂÃÄÅÆÇÈÉÊËÌÍÎÏÐÑÒÓÔÕÖØŒÙÚÛÜÝŸÞßªàáâãäåæçèéêëìíîïðñºòóôõöøœùúûüýþÿŠŽšž©";
        return getIndexString(s, keep);
    }

    public static String stripSpace(String s) {
        StringBuilder sb = new StringBuilder();
        boolean sawspace = false;
        for(char c : s.toCharArray()) {
            if(sawspace && c == ' ') {
                continue;
            } else {
                sb.append(c);
                if(c == ' ') {
                    sawspace = true;
                } else {
                    sawspace = false;
                }
            }
        }
        return sb.toString();
    }

    public static String processString(String s, Config cfg) {
        if(!cfg.isCaseSensitive()) {
            s = s.toLowerCase();
        }
        if(cfg.replaceAllNumbers()) {
            s = replaceAllNumbers(s);
        } else if(cfg.replaceNumbers()) {
            s = replaceNumbers(s);
        }
        s = stripSpace(s);
        return s;
    }

    public static List<Integer> getRange(String s) {
        List<Integer> out = new ArrayList<Integer>();
        String cur = "";
        int last = 0;
        boolean isRange = false;
        for (char c : s.toCharArray()) {
            if(c == '-') {
                isRange = true;
                last = Integer.parseInt(cur);
                cur = "";
            } else if(c == ',') {
                int tmp = Integer.parseInt(cur);
                if(isRange) {
                    for(int i=last; i<=tmp; i++) {
                        out.add(i);
                    }
                    isRange = false;
                } else {
                    out.add(tmp);
                }
                cur = "";
            } else if(isNum(c)) {
                cur += c;
            } else {
                continue;
            }
        }
        int tmp = Integer.parseInt(cur);
        if(isRange) {
            for(int i=last; i<=tmp; i++) {
                out.add(i);
            }
            isRange = false;
        } else {
            out.add(tmp);
        }
        return out;
    }
}
