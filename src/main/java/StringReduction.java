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
    public void reduce(Map<String, Integer> m, int freq) {
        //Map<String, Integer> sort = new TreeMap<String, Integer>(m);
        // TODO : move this out of here!
        // TODO : object comparison is probably enough to avoid the ArrayList
        List<Map.Entry<String, Integer>> sort = new ArrayList<Map.Entry<String, Integer>>(m.entrySet());
        Collections.sort(sort,
                new Comparator<Map.Entry<String, Integer>>() {
                    public int compare(Map.Entry<String, Integer> a, Map.Entry<String, Integer> b) {
                        return a.getKey().compareTo(b.getKey());
                    }
                });
        int size = sort.size();
        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                // Avoid self comparison
                if (i == j) {
                    continue;
                }
                if ((Math.abs(sort.get(i).getValue()) - Math.abs(sort.get(j).getValue()) < freq)
                        && Tools.is_substr(sort.get(i).getKey(), sort.get(j).getKey())) {
                    if (sort.get(i).getValue() > 0) {
                        sort.get(i).setValue(-sort.get(i).getValue());
                    }
                }
            }
        }
    }

}
