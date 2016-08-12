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

import ie.tcd.slscs.ngramtool.NGram;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Kozicka2016Initial implements Classifier {
    private Map<String, SalazarClass> bundles;
    public Kozicka2016Initial() {
        bundles = new HashMap<String, SalazarClass>();
        init_bundles();
    }
    private void init_bundles() {
        bundles.put("it may be that", new SalazarClass("it may be that", "", "anticipatory it", "", "", ""));
        bundles.put("on the other hand", new SalazarClass("on the other hand", "hand", "other PP", "comparative", "additive", ""));
        bundles.put("at the time of", new SalazarClass("at the time of", "", "PP+of", "", "", ""));
        bundles.put("the end of the", new SalazarClass("the end of the", "", "NP+of", "", "", ""));
        bundles.put("as a result of", new SalazarClass("as a result of", "result", "adverbial clause", "causative", "", ""));
        bundles.put("in the early years", new SalazarClass("in the early years", "", "other PP", "", "", ""));
        bundles.put("it is difficult to", new SalazarClass("it is difficult to", "difficult", "anticipatory it", "engagement (p-o)", "", "is difficult to"));
        bundles.put("a total of #", new SalazarClass("a total of #", "", "NP+of", "", "", ""));
        bundles.put("that there is a", new SalazarClass("that there is a", "", "(Verb phrase +) type 8 ", "", "", ""));
        bundles.put("as part of a", new SalazarClass("as part of a", "", "adverbial clause", "", "", ""));
        bundles.put("are more likely to", new SalazarClass("are more likely to", "", "(V/A)+to type 9", "", "", ""));
        bundles.put("the boundaries of the", new SalazarClass("the boundaries of the", "", "NP+of", "", "", ""));
        bundles.put("more likely to be", new SalazarClass("more likely to be", "", "(V/A)+to type 9", "", "", ""));
        bundles.put("the development of a", new SalazarClass("the development of a", "", "NP+of", "", "", ""));
        bundles.put("the course of the", new SalazarClass("the course of the", "", "NP+of", "", "", ""));
        bundles.put("on the one hand", new SalazarClass("on the one hand", "", "other PP", "", "", ""));
        bundles.put("is clear that the", new SalazarClass("is clear that the", "", "(verb phrase+)that type 8", "", "", ""));
        bundles.put("in the wake of", new SalazarClass("in the wake of", "", "PP+of", "", "", ""));
        bundles.put("of the nineteenth century", new SalazarClass("of the nineteenth century", "", "other PP", "", "", ""));
        bundles.put("in the case of", new SalazarClass("in the case of", "case", "PP+of", "framing", "", ""));
        bundles.put("it is clear that", new SalazarClass("it is clear that", "clear", "anticipatory it", "stance", "", "it is clear"));
        bundles.put("in a number of", new SalazarClass("in a number of", "number", "PP+of", "quantification", "", ""));
        bundles.put("when it comes to", new SalazarClass("when it comes to", "", "other expression", "", "", ""));
        bundles.put("on the part of", new SalazarClass("on the part of", "", "PP+of", "", "", ""));
        bundles.put("for the purposes of", new SalazarClass("for the purposes of", "", "PP+of", "", "", ""));
        bundles.put("the case of the", new SalazarClass("the case of the", "", "other NP", "", "", ""));
        bundles.put("in the process of", new SalazarClass("in the process of", "", "PP+of", "", "", ""));
        bundles.put("in the form of", new SalazarClass("in the form of", "", "PP+of", "", "", ""));
        bundles.put("one of the most", new SalazarClass("one of the most", "", "NP+of", "", "", ""));
        bundles.put("the way in which", new SalazarClass("the way in which", "", "other NP", "", "", ""));
        bundles.put("from the perspective of", new SalazarClass("from the perspective of", "", "PP+of", "", "", ""));
        bundles.put("are likely to be", new SalazarClass("are likely to be", "likely", "(V/A)+to type 9", "stance", "inferential", ""));
        bundles.put("the results of the", new SalazarClass("the results of the", "", "NP+of", "", "", ""));
        bundles.put("# and # and", new SalazarClass("# and # and", "", "", "", "", ""));
        bundles.put("at the level of", new SalazarClass("at the level of", "level", "PP+of", "description", "", ""));
        bundles.put("a great deal of", new SalazarClass("a great deal of", "", "NP+of", "", "", ""));
        bundles.put("as well as to", new SalazarClass("as well as to", "", "other expression", "", "", ""));
        bundles.put("in relation to the", new SalazarClass("in relation to the", "", "other PP", "", "", ""));
        bundles.put("from # to #", new SalazarClass("from # to #", "", "other PP", "", "", ""));
        bundles.put("in the late #s", new SalazarClass("in the late #s", "", "other PP", "", "", ""));
        bundles.put("the role of the", new SalazarClass("the role of the", "", "NP+of", "", "", ""));
        bundles.put("appears to be a", new SalazarClass("appears to be a", "", "(V/A)+to type 9", "", "", ""));
        bundles.put("for the first time", new SalazarClass("for the first time", "", "other PP", "", "", ""));
        bundles.put("the extent to which", new SalazarClass("the extent to which", "", "other NP", "", "", ""));
        bundles.put("the future of the", new SalazarClass("the future of the", "", "NP+of", "", "", ""));
        bundles.put("there has been a", new SalazarClass("there has been a", "", "(Verb phrase +) type 8", "", "", ""));
        bundles.put("of the twentieth century", new SalazarClass("of the twentieth century", "", "other PP", "", "", ""));
        bundles.put("at the heart of", new SalazarClass("at the heart of", "", "PP+of", "", "", ""));
        bundles.put("in a way that", new SalazarClass("in a way that", "", "other PP", "", "", ""));
        bundles.put("in the same way", new SalazarClass("in the same way", "same", "other PP", "comparative", "", "in the same"));
        bundles.put("in the field of", new SalazarClass("in the field of", "", "PP+of", "", "", ""));
        bundles.put("about the nature of", new SalazarClass("about the nature of", "", "PP+of", "", "", ""));
        bundles.put("in terms of the", new SalazarClass("in terms of the", "", "PP+of", "", "", ""));
        bundles.put("a result of the", new SalazarClass("a result of the", "", "NP+of", "", "", ""));
        bundles.put("the importance of the", new SalazarClass("the importance of the", "", "NP+of", "", "", ""));
        bundles.put("the power of the", new SalazarClass("the power of the", "", "NP+of", "", "", ""));
        bundles.put("are a number of", new SalazarClass("are a number of", "", "(V/A)+to type 9", "", "", ""));
        bundles.put("in the context of", new SalazarClass("in the context of", "context", "PP+of", "framing", "", ""));
        bundles.put("at the expense of", new SalazarClass("at the expense of", "", "PP+of", "", "", ""));
        bundles.put("the united states and", new SalazarClass("the united states and", "", "other NP", "", "", ""));
        bundles.put("the ways in which", new SalazarClass("the ways in which", "", "other NP", "", "", ""));
        bundles.put("in so far as", new SalazarClass("in so far as", "", "", "", "", ""));
        bundles.put("in contrast to the", new SalazarClass("in contrast to the", "", "other PP", "", "", ""));
        bundles.put("the relationship between the", new SalazarClass("the relationship between the", "", "other NP", "", "", ""));
        bundles.put("the vast majority of", new SalazarClass("the vast majority of", "", "NP+of", "", "", ""));
        bundles.put("as well as a", new SalazarClass("as well as a", "", "other expression", "", "", ""));
        bundles.put("it is possible to", new SalazarClass("it is possible to", "", "anticipatory it", "", "", ""));
        bundles.put("with respect to the", new SalazarClass("with respect to the", "", "other PP", "", "", ""));
        bundles.put("at the same time", new SalazarClass("at the same time", "time", "other PP", "framing", "additive", ""));
        bundles.put("of the impact of", new SalazarClass("of the impact of", "", "PP+of", "", "", ""));
        bundles.put("in the #s and", new SalazarClass("in the #s and", "", "other PP", "", "", ""));
        bundles.put("the quality of the", new SalazarClass("the quality of the", "", "NP+of", "", "", ""));
        bundles.put("per cent of the", new SalazarClass("per cent of the", "", "NP+of", "", "", ""));
        bundles.put("there are a number", new SalazarClass("there are a number", "", "(Verb phrase +) type 8", "", "", ""));
        bundles.put("between # and #", new SalazarClass("between # and #", "", "other PP", "", "", ""));
        bundles.put("in the united states", new SalazarClass("in the united states", "", "other PP", "location (r-o)", "", ""));
        bundles.put("# per cent of", new SalazarClass("# per cent of", "", "NP+of", "", "", ""));
        bundles.put("# # and #", new SalazarClass("# # and #", "", "", "", "", ""));
        bundles.put("at the end of", new SalazarClass("at the end of", "end", "PP+of", "location", "", ""));
        bundles.put("an understanding of the", new SalazarClass("an understanding of the", "", "NP+of", "", "", ""));
        bundles.put("to be able to", new SalazarClass("to be able to", "", "(V/A)+to type 9", "", "", ""));
        bundles.put("on the basis of", new SalazarClass("on the basis of", "basis", "PP+of", "framing", "", ""));
        bundles.put("in # and #", new SalazarClass("in # and #", "", "other PP", "", "", ""));
        bundles.put("# per cent had", new SalazarClass("# per cent had", "", "", "", "", ""));
        bundles.put("that there is no", new SalazarClass("that there is no", "", "verb phase + that (type 8)", "", "", ""));
        bundles.put("as well as the", new SalazarClass("as well as the", "", "other expression", "", "", ""));
        bundles.put("the second world war", new SalazarClass("the second world war", "", "other NP", "", "", ""));
        bundles.put("in the face of", new SalazarClass("in the face of", "", "PP+of", "", "", ""));
        bundles.put("the size of the", new SalazarClass("the size of the", "", "NP+of", "", "", ""));
        bundles.put("as part of the", new SalazarClass("as part of the", "", "adverbial clause", "", "", ""));
        bundles.put("were more likely to", new SalazarClass("were more likely to", "", "V/A+to", "", "", ""));
        bundles.put("be more likely to", new SalazarClass("be more likely to", "", "copula be", "", "", ""));
        bundles.put("research has shown that", new SalazarClass("research has shown that", "", "(verb phrase)+that type 8", "", "", ""));
        bundles.put("the significance of the", new SalazarClass("the significance of the", "", "NP+of", "", "", ""));
        bundles.put("the nature of the", new SalazarClass("the nature of the", "", "NP+of", "", "", ""));
        bundles.put("in addition to the", new SalazarClass("in addition to the", "", "other PP", "", "", ""));
        bundles.put("it is important to", new SalazarClass("it is important to", "note", "anticipatory it", "engagement", "stance", ""));
        bundles.put("to the development of", new SalazarClass("to the development of", "", "PP+of", "", "", ""));
        bundles.put("in the name of", new SalazarClass("in the name of", "", "PP+of", "", "", ""));
        bundles.put("as a means of", new SalazarClass("as a means of", "", "adverbial clause", "", "", ""));
        bundles.put("in the absence of", new SalazarClass("in the absence of", "absence", "PP+of", "framing", "", ""));
        bundles.put("as well as their", new SalazarClass("as well as their", "", "other expression", "", "", ""));
        bundles.put("the #s and #s", new SalazarClass("the #s and #s", "", "other NP", "", "", ""));
        bundles.put("a wide range of", new SalazarClass("a wide range of", "range", "NP+of", "grouping", "", ""));
        bundles.put("to the extent that", new SalazarClass("to the extent that", "", "other PP", "", "", ""));
        bundles.put("the fact that the", new SalazarClass("the fact that the", "", "NP+of", "", "", ""));
        bundles.put("the question of how", new SalazarClass("the question of how", "", "NP+of", "", "", ""));
        bundles.put("as a form of", new SalazarClass("as a form of", "", "adverbial clause", "", "", ""));
        bundles.put("the wake of the", new SalazarClass("the wake of the", "", "NP+of", "", "", ""));
        bundles.put("is likely to be", new SalazarClass("is likely to be", "likely", "V/A+to", "stance (p-o)", "inferential", ""));
        bundles.put("at the university of", new SalazarClass("at the university of", "", "NP+of", "location (r-o)", "", ""));
        bundles.put("the degree to which", new SalazarClass("the degree to which", "", "other NP", "description (r-o)", "", ""));
        bundles.put("of the concept of", new SalazarClass("of the concept of", "", "PP+of", "", "", ""));
    }
    public String getFields() {
        return "bundle\tkeyword\tstructure\tfunction 1\tfunction 2\tvariant of";
    }

    public String classify(NGram n) {
        SalazarClass c = bundles.get(n.getText());
        if(c != null) {
            return c.toString();
        } else {
            return "Unknown";
        }
    }
}
