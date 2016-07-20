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
import org.junit.Test;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static org.junit.Assert.*;

public class FilterTest {
    @Test
    public void filterByAuthor() throws Exception {
        Map<String, List<NGram>> ngrams = new HashMap<String, List<NGram>>();
        List<NGram> one = new ArrayList<NGram>();
        List<NGram> two = new ArrayList<NGram>();
        List<NGram> three = new ArrayList<NGram>();
        one.add(new NGram("a simple one", 1));
        three.add(new NGram("a simple one", 1));
        two.add(new NGram("a simpler one", 34));
        three.add(new NGram("a simpler one", 1));
        three.add(new NGram("this is unique", 1));
        ngrams.put("one", one);
        ngrams.put("two", two);
        ngrams.put("three", three);
        Filter.filterByAuthor("three", ngrams);
        List<NGram> out = ngrams.get("three");
        System.out.println(out.size());
        for(NGram c : out) {
            System.out.println(c.getText());
        }
    }

}