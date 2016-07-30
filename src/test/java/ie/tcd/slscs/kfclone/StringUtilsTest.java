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

import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.*;

public class StringUtilsTest {
    @Test
    public void replacePunctWithSpace() throws Exception {
        String inp = "this's,a-test.";
        String exp = "this s a test ";
        String out = StringUtils.replacePunctWithSpace(inp);
        assertEquals(exp, out);
    }

    @Test
    public void replaceNumbers() throws Exception {
        String inp = "a 400 and 500 thing";
        String exp = "a ### and ### thing";
        String out = StringUtils.replaceNumbers(inp);
        assertEquals(exp, out);
    }

    @Test
    public void replaceAllNumbers() throws Exception {
        String inp = "a 400 and 500 thing";
        String exp = "a # and # thing";
        String out = StringUtils.replaceAllNumbers(inp);
        assertEquals(exp, out);
    }

    @Test
    public void getIndexString() throws Exception {
        String inp = "ślepy";
        String keep = inp;
        String exp1 = " lepy";
        String exp2 = inp;
        String out1 = StringUtils.getIndexString(inp);
        String out2 = StringUtils.getIndexString(inp, keep);
        assertEquals(out1, exp1);
        assertEquals(out2, exp2);
    }

    @Test
    public void testStripSpace() throws Exception {
        String inp = "this   has a  few    stray spaces";
        String exp = "this has a few stray spaces";
        String out = StringUtils.stripSpace(inp);
        assertEquals(exp, out);
    }

    @Test
    public void testProcessString() {
        String inp = "THIS has 9992,00 in   it";
        String exp = "this has #,# in it";
        Config cfg = new Config();
        cfg.setCaseSensitive(false);
        String out = StringUtils.processString(inp, cfg);
        assertEquals(exp, out);
    }

    @Test
    public void testReplaceNonInternalPunctWithSpace() {
        String inp = "word , hyphenated-word 999,99 9,,9";
        String exp1 = "word   hyphenated-word 999,99 9  9";
        String exp2 = "word   hyphenatedword 999,99 9  9";
        String out1 = StringUtils.replaceNonInternalPunctWithSpace(inp, false);
        String out2 = StringUtils.replaceNonInternalPunctWithSpace(inp, true);
        assertEquals(out1, exp1);
        assertEquals(out2, exp2);
    }

    @Test
    public void testGetRange() {
        String inp = "1-3, 5, 7-10";
        int[] tmp = new int[] {1, 2, 3, 5, 7, 8, 9, 10};
        List<Integer> exp = new ArrayList<Integer>();
        for(Integer i : tmp) {
            exp.add(i);
        }
        List<Integer> out = StringUtils.getRange(inp);
        assertEquals(exp, out);
    }
}
