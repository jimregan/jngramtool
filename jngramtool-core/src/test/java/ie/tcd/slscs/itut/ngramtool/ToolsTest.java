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
import ie.tcd.slscs.itut.ngramtool.Tools;

import java.util.ArrayList;
import java.util.List;

public class ToolsTest {
    @org.junit.Test
    public void isSpace() throws Exception {
        assert(Tools.isSpace(' '));
    }

    @org.junit.Test
    public void isCJKSymbol() throws Exception {
        assert(Tools.isCJKSymbol('\ufa30'));
    }

    @org.junit.Test
    public void isChineseCharacter() throws Exception {
        assert(Tools.isChineseCharacter('\ufa30'));
    }

    @org.junit.Test
    public void split() throws Exception {
        List<String> expected = new ArrayList<String>();
        expected.add("this");
        expected.add("is");
        expected.add("a");
        expected.add("test");
        String delim = " ,;";
        String in = "this is;a,test";
        List<String> out = Tools.split(in, delim);
        assert(out.toString().contentEquals(expected.toString()));
    }

    @org.junit.Test
    public void is_substr() throws Exception {
        assert(Tools.is_substr("this", "this is"));
        assert(Tools.is_substr("is a", "this is a"));
    }

}