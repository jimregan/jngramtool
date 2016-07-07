import java.util.*;

/*
 * Copyright (C) 2004 by Zhang Le <ejoy@users.sourceforge.net>
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
public class StringReduction {
    public static Map<String, Integer> reduce1_base(Map<String, Integer> m, int freq, boolean orig) {
        Map<String, Integer> out = new TreeMap<String, Integer>();
        Map<String, Integer> sort = new TreeMap<String, Integer>(m);
        for (Map.Entry<String, Integer> a  : sort.entrySet()) {
            for (Map.Entry<String, Integer> b  : sort.entrySet()) {
                if (a.equals(b)) {
                    continue;
                }
                if ((Math.abs(a.getValue()) - Math.abs(b.getValue()) < freq)
                        && Tools.is_substr(a.getKey(), b.getKey())) {
                    if (a.getValue() > 0) {
                        if (orig) {
                            a.setValue(-a.getValue());
                        } else {
                            a.setValue(Math.abs(a.getValue()) - Math.abs(b.getValue()));
                        }

                    }
                }
            }
        }
        for (Map.Entry<String, Integer> k  : sort.entrySet()) {
            if (k.getValue() > 0) {
                out.put(k.getKey(), k.getValue());
            }
        }
        return out;
    }

    public static Map<String, Integer> reduce1(Map<String, Integer> m, int freq) {
        return reduce1_base(m, freq, true);
    }

    public static Map<String, Integer> reduce1fix(Map<String, Integer> m, int freq) {
        return reduce1_base(m, freq, false);
    }
}
