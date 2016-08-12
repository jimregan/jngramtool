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
 * FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL
 * THE AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
 * LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING
 * FROM, OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER
 * DEALINGS IN THE SOFTWARE.
 */

import java.util.ArrayList;
import java.util.List;
import ie.tcd.slscs.bundles.Utils;
import ie.tcd.slscs.bundles.SketchEngineSentence;

public class SketchEngineFile {
    private List<SketchEngineSentence> sentences;
    private List<String> text;
    private String id;
    private String parent_file;
    private String filename;

    SketchEngineFile() {
        sentences = new ArrayList<SketchEngineSentence>();
        text = new ArrayList<String>();
    }
    SketchEngineFile(String pf, String fid, String fname) {
        this();
        filename = fname;
        parent_file = pf;
        id = fid;
    }

    public void add(SketchEngineSentence t) {
        sentences.add(t);
    }
    private void setupText() {
        if(text != null) {
            for(SketchEngineSentence t : sentences) {
                text.add(t.getText());
            }
        }
    }
    public List<String> getText() {
        if(text != null) {
            return text;
        } else {
            setupText();
        }
        return text;
    }
    public List<String> markupMatches(List<String> bundles) {
        setupText();
        List<String> lines = new ArrayList<String>();
        for(String bundle : bundles) {
            lines.add("<h3>" + bundle + "</h3>");
            for(String t : text) {
                String tmp = Utils.markMatches(t, bundle, "<b>", "</b>");
                if(!t.equals(tmp)) {
                    lines.add("<p>" + tmp + "</p>");
                }
            }
        }
        return lines;
    }
}
