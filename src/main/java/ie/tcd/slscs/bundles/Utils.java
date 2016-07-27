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
}
