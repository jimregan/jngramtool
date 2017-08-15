package ie.tcd.slscs.itut.bundles;

import ie.tcd.slscs.itut.ngramtool.NGram;

import java.util.*;

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
public class Filter {
    static void filterByAuthor(String author, Map<String, List<NGram>> ngrams) {
        Map<String, Integer> others = new HashMap<String, Integer>();
        List<NGram> current = new ArrayList<NGram>();
        for(Map.Entry<String, List<NGram>> e : ngrams.entrySet()) {
            if(!author.equals(e.getKey())) {
                for (NGram n : e.getValue()) {
                    if(others.containsKey(n.getText())) {
                        others.put(n.getText(), others.get(n.getText()) + n.getCount());
                    } else {
                        others.put(n.getText(), n.getCount());
                    }
                }
            } else {
                current = e.getValue();
            }
        }
        if(current.size() == 0) {
            return;
        } else {
            Iterator<NGram> it = current.iterator();
            while (it.hasNext()) {
                NGram n = it.next();
                if (!others.containsKey(n.getText())) {
                    it.remove();
                }
            }
        }
    }
}
