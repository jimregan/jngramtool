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
 * FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL
 * THE AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
 * LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING
 * FROM, OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER
 * DEALINGS IN THE SOFTWARE.
 */

import java.util.ArrayList;
import java.util.List;
import ie.tcd.slscs.itut.bundles.Utils;
import ie.tcd.slscs.itut.bundles.SketchEngineFragment;

public class SketchEngineSentence {
    private List<SketchEngineFragment> fragments;
    private String text;

    SketchEngineSentence() {
        fragments = new ArrayList<SketchEngineFragment>();
    }

    public void add(SketchEngineFragment t) {
        fragments.add(t);
    }
    public String getText() {
        if(text != null && !"".equals(text)) {
            return text;
        } else {
            List<String> tmp = new ArrayList<String>();
            for(SketchEngineFragment t : fragments) {
                tmp.add(t.getText());
            }
            text = Utils.join(tmp, " ");
        }
        return text;
    }
}
