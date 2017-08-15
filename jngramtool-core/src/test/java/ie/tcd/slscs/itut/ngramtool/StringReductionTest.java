package ie.tcd.slscs.itut.ngramtool;
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
import ie.tcd.slscs.ngramtool.StringReduction;
import org.junit.Test;

import java.util.Map;
import java.util.TreeMap;

public class StringReductionTest {
    Map<String, Integer> m1 = new TreeMap<String, Integer>();
    Map<String, Integer> e1 = new TreeMap<String, Integer>();
    Map<String, Integer> m2 = new TreeMap<String, Integer>();
    Map<String, Integer> e2 = new TreeMap<String, Integer>();

    public StringReductionTest() {
        m1.put("this is a test", 6);
        m1.put("is a test", 6);
        m1.put("this is a", 6);
        e1.put("this is a test", 6);

        m2.put("this is a test", 6);
        m2.put("is a test", 8);
        m2.put("this is a", 2);
        e2.put("this is a test", 6);
        e2.put("is a test", 2);
    }
    @Test
    public void reduce() throws Exception {
        Map<String, Integer> res1 = StringReduction.reduce1(m1, 5);
        assert(res1.toString().equals(e1.toString()));
        //reduce1's algorithm seems to not reduce in the way I expect
        Map<String, Integer> res2 = StringReduction.reduce1unique(m2, 5);
        System.out.print(res2.toString());
        assert(res2.toString().equals(e2.toString()));
    }

}