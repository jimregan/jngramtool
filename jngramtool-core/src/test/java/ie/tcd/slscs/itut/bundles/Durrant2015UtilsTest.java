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

import ie.tcd.slscs.itut.bundles.Durrant2015Utils;
import ie.tcd.slscs.itut.ngramtool.NGram;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.*;

public class Durrant2015UtilsTest {
    @Test
    public void normalise() throws Exception {
        String inp = "There;s a 90s   thing";
        String exp = "theres a Ns thing";
        String out = Durrant2015Utils.normalise(inp);
        assertEquals(exp, out);
    }

    @Test
    public void normaliseDurrant() throws Exception {
        String inp = "There;s a 90s   thing";
        String exp = "theres a s thing";
        String out = Durrant2015Utils.normaliseDurrant(inp);
        assertEquals(exp, out);
    }

    @Test
    public void ngramOverlap() throws Exception {
        List<NGram> a = new ArrayList<NGram>();
        List<NGram> b = new ArrayList<NGram>();
        a.add(new NGram("some overlap", 1));
        a.add(new NGram("more overlap", 1));
        a.add(new NGram("only a", 1));
        a.add(new NGram("also only a", 1));
        b.add(new NGram("some overlap", 1));
        b.add(new NGram("more overlap", 1));
        b.add(new NGram("only b", 1));
        b.add(new NGram("also only b", 1));
        double out = Durrant2015Utils.ngramOverlap(a, b);
        assert(out == 0.5);
    }
}