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

public class Durrant2015Test {
    @Test
    public void classifierTest() throws Exception {
        Durrant2015 durrant = new Durrant2015();
        NGram inp1 = new NGram("on the basis of", 2);
        NGram inp2 = new NGram("was found to be", 3);
        NGram inp3 = new NGram("my fake n-gram", 3);
        String exp1 = "Stance: Framing";
        String exp2 = "Stance: Epistemic";
        String unk = "Unknown";

        String out1 = durrant.classify(inp1);
        String out2 = durrant.classify(inp2);
        String out3 = durrant.classify(inp3);
        assertEquals(exp1, out1);
        assertEquals(exp2, out2);
        assertEquals(exp2, unk);
        durrant.setField(true, false);
        out1 = durrant.classify(inp1);
        out2 = durrant.classify(inp2);
        out3 = durrant.classify(inp3);
        assertEquals(exp1, out1);
        assertEquals(exp2, unk);
        assertEquals(exp2, unk);
        durrant.setField(false, true);
        out1 = durrant.classify(inp1);
        out2 = durrant.classify(inp2);
        out3 = durrant.classify(inp3);
        assertEquals(exp1, unk);
        assertEquals(exp2, out2);
        assertEquals(exp2, unk);
    }

}
