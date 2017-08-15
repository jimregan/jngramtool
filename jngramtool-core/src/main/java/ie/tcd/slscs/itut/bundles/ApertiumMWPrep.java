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
import ie.tcd.slscs.itut.kfclone.StringUtils;
import ie.tcd.slscs.itut.ngramtool.NGram;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/**
 * This classifier checks if an n-gram is a multiword preposition,
 * according to the data in Apertium's English-Spanish translator
 */
public class ApertiumMWPrep implements Classifier {
    private List<String> ngrams;
    public ApertiumMWPrep() {
        ngrams = new ArrayList<String>();
        initNGrams();
    }
    void initNGrams() {
        ngrams.add("according to");
        ngrams.add("across the pond");
        ngrams.add("ahead of");
        ngrams.add("along with");
        ngrams.add("apart from");
        ngrams.add("around the middle of");
        ngrams.add("as a");
        ngrams.add("as a result of");
        ngrams.add("as for");
        ngrams.add("as regards");
        ngrams.add("at a rate of");
        ngrams.add("at about");
        ngrams.add("at the beginning of");
        ngrams.add("at the bottom of");
        ngrams.add("at the expense of");
        ngrams.add("at the head of");
        ngrams.add("at the heart of");
        ngrams.add("because of");
        ngrams.add("by dint of");
        ngrams.add("by means of");
        ngrams.add("by order of");
        ngrams.add("by the expense of");
        ngrams.add("due to");
        ngrams.add("except for");
        ngrams.add("for the sake of");
        ngrams.add("from among");
        ngrams.add("in accordance with");
        ngrams.add("in addition to");
        ngrams.add("in compliance with");
        ngrams.add("in front of");
        ngrams.add("in order of");
        ngrams.add("in order to");
        ngrams.add("in pursuit of");
        ngrams.add("in regard to");
        ngrams.add("in spite of");
        ngrams.add("in the middle of");
        ngrams.add("in the order of");
        ngrams.add("in the region of");
        ngrams.add("in view of");
        ngrams.add("instead of");
        ngrams.add("just across");
        ngrams.add("less than");
        ngrams.add("more than");
        ngrams.add("on account of");
        ngrams.add("on the eve of");
        ngrams.add("on top of");
        ngrams.add("out of");
        ngrams.add("owing to");
        ngrams.add("prior to");
        ngrams.add("rather than");
        ngrams.add("right across");
        ngrams.add("right in front of");
        ngrams.add("shortly after");
        ngrams.add("shortly before");
        ngrams.add("so as to");
        ngrams.add("straight across");
        ngrams.add("such as");
        ngrams.add("suitable for");
        ngrams.add("thanks to");
        ngrams.add("to the detriment of");
        ngrams.add("together with");
        ngrams.add("typical of");
        ngrams.add("under the leadership of");
        ngrams.add("unencumbered by");
        ngrams.add("up to");
        ngrams.add("waiting for");
        ngrams.add("with a time of");
        ngrams.add("with a view to");
        ngrams.add("with no");
        ngrams.add("with regard to");
        ngrams.add("without any loss of");
        ngrams.add("with no loss of");
    }
    public String classify(NGram n) {
        if(ngrams.contains(n.getText())) {
            return "Yes";
        } else {
            return "No";
        }
    }
    public String getFields() {
        return "Apertium: MW Preposition";
    }
}
