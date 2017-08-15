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
import java.util.Map;

public class Durrant2015Utils {

    /**
     * Modified version of the text normalisation
     * mentioned in Durrant 2015, p. 6, replacing
     * digits with 'N' to match the n-grams in the
     * article.
     *
     * @see #normaliseDurrant(String) for the
     * exact normalisation method mentioned.
     */
    static String normalise(String s) {
        return s.toLowerCase()
                .replaceAll("\\p{Punct}+", "")
                .replaceAll("\\p{Digit}+", "N")
                .replaceAll("\\p{Space}+", " ");
    }

    static String normaliseDurrant(String s) {
        return s.toLowerCase()
                .replaceAll("\\p{Punct}+", "")
                .replaceAll("\\p{Digit}+", "")
                .replaceAll("\\p{Space}+", " ");
    }

    /**
     * Calculates n-gram overlap from Durrant 2015, p. 6
     * @param a First "corpus" of n-grams
     * @param b Second "corpus" of n-grams
     * @return Overlap
     */
    static double ngramOverlap (List<NGram> a, List<NGram> b) {
        Map<String, Integer> la = new HashMap<String, Integer>();
        Map<String, Integer> lb = new HashMap<String, Integer>();
        int n1 = 0;
        int n2 = 0;
        int l1 = a.size();
        int l2 = b.size();

        for (NGram n : a) {
            la.put(n.getText(), n.getCount());
        }
        for (NGram n : b) {
            lb.put(n.getText(), n.getCount());
        }

        for (NGram n : a) {
            if (lb.get(n.getText()) != null) {
                n1++;
            }
        }
        for (NGram n : b) {
            if (la.get(n.getText()) != null) {
                n2++;
            }
        }

        return ((n1 + n2 * 1.0) / (l1 + l2 * 1.0));
    }
}
