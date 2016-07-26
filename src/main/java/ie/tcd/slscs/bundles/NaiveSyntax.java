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
import ie.tcd.slscs.kfclone.StringUtils;
import ie.tcd.slscs.ngramtool.NGram;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/**
 * This classifier uses some naive single word checks to guess
 * if an n-gram belongs to a syntactic category
 */
public class NaiveSyntax implements Classifier {
    private List<String> preps;
    private List<String> dets;
    public NaiveSyntax() {
        preps = new ArrayList<String>();
        dets = new ArrayList<String>();
        initPreps();
        initDets();
    }
    void initPreps() {
        preps.add("about");
        preps.add("above");
        preps.add("across");
        preps.add("after");
        preps.add("against");
        preps.add("along");
        preps.add("alongside");
        preps.add("amid");
        preps.add("amidst");
        preps.add("among");
        preps.add("apropos");
        preps.add("around");
        preps.add("as");
        preps.add("at");
        preps.add("before");
        preps.add("behind");
        preps.add("below");
        preps.add("beside");
        preps.add("between");
        preps.add("beyond");
        preps.add("but");
        preps.add("by");
        preps.add("despite");
        preps.add("ere");
        preps.add("except");
        preps.add("for");
        preps.add("from");
        preps.add("in");
        preps.add("inside");
        preps.add("into");
        preps.add("like");
        preps.add("near");
        preps.add("of");
        preps.add("off");
        preps.add("on");
        preps.add("onto");
        preps.add("out");
        preps.add("outside");
        preps.add("over");
        preps.add("per");
        preps.add("plus");
        preps.add("round");
        preps.add("since");
        preps.add("through");
        preps.add("throughout");
        preps.add("till");
        preps.add("to");
        preps.add("toward");
        preps.add("towards");
        preps.add("under");
        preps.add("unlike");
        preps.add("until");
        preps.add("up");
        preps.add("upon");
        preps.add("via");
        preps.add("with");
        preps.add("within");
        preps.add("without");
    }
    void initDets() {
        dets.add("a");
        dets.add("another");
        dets.add("any");
        dets.add("both");
        dets.add("each");
        dets.add("either");
        dets.add("enough");
        dets.add("every");
        dets.add("few");
        dets.add("fewer");
        dets.add("her");
        dets.add("his");
        dets.add("its");
        dets.add("less");
        dets.add("little");
        dets.add("many");
        dets.add("more");
        dets.add("most");
        dets.add("much");
        dets.add("my");
        dets.add("no");
        dets.add("other");
        dets.add("our");
        dets.add("several");
        dets.add("some");
        dets.add("such");
        dets.add("that");
        dets.add("the");
        dets.add("their");
        dets.add("this");
        dets.add("various");
        dets.add("what");
        dets.add("whatever");
        dets.add("whatsoever");
        dets.add("which");
        dets.add("whose");
        dets.add("your");
    }
    public String classify(NGram n) {
        return "FIXME";
    }
    public String isMWPrep(NGram n) {
        String[] ss = n.getText().split(" ");
        int last = ss.length - 1;
        if(preps.contains(ss[0]) && preps.contains(ss[last])) {
            if(ss[last] == "of") {
                return "PP+of";
            } else {
                return "other PP";
            }
        } else {
            return "";
        }
    }
    public String isNPLike(NGram n) {
        String[] ss = n.getText().split(" ");
        int last = ss.length - 1;
        if(dets.contains(ss[0])) {
            if(ss[last] == "of") {
                return "NP+of";
            } else {
                return "other NP";
            }
        } else {
            return "";
        }
    }
    public String getFields() {
        return "Naive Syntax";
    }

}
