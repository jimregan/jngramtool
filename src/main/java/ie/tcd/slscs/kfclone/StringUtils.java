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
    public static String replacePunctWithSpace(String s) {
        String out = "";
        for (char c : s.toCharArray()) {
            if (c == '.' || c == ',' || c == '-' || c == '\'') {
                out += ' ';
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

    public static String replaceNumbers(String s) {
        String out = "";
        for (char c : s.toCharArray()) {
            if (isNum(c)) {
                out += '#';
            } else {
                out += c;
            }
        }
        return out;
    }

    public static String replaceAllNumbers(String s) {
        String out = "";
        boolean numberSeen = false;
        for (char c : s.toCharArray()) {
            if (isNum(c)) {
                if (!numberSeen) {
                    out += '#';
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
}
