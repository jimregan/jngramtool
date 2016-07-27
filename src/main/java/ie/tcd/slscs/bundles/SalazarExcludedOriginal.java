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

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/**
 * This classifier checks if an n-gram is present in the list of
 * excluded items from Salazar 2011, Appendix 2
 *
 * <pre>
 * @phdthesis{salazar2011lexical,
 * title={Lexical bundles in scientific English: A corpus-based study of native and non-native writing},
 * author={Salazar, Danica Joy Lorenzo},
 * year={2011},
 * school={Universitat de Barcelona}
 * }
 * </pre>
 */
public class SalazarExcludedOriginal implements Classifier {
    private List<String> ngrams;
    public SalazarExcludedOriginal() {
        ngrams = new ArrayList<String>();
        initNGrams();
    }

    public String getFields() {
        return "Salazar Excluded";
    }

    void initNGrams() {
        ngrams.add("in the presence");
        ngrams.add("in the absence");
        ngrams.add("materials and methods");
        ngrams.add("consistent with the");
        ngrams.add("the expression of");
        ngrams.add("for 30 min");
        ngrams.add("region of the");
        ngrams.add("expression of the");
        ngrams.add("for 10 min");
        ngrams.add("one of the");
        ngrams.add("for 1 h");
        ngrams.add("present in the");
        ngrams.add("analysis of the");
        ngrams.add("it has been");
        ngrams.add("is possible that");
        ngrams.add("in which the");
        ngrams.add("associated with the");
        ngrams.add("on the basis");
        ngrams.add("all of the");
        ngrams.add("end of the");
        ngrams.add("of the two");
        ngrams.add("described in the");
        ngrams.add("the binding of");
        ngrams.add("activity of the");
        ngrams.add("structure of the");
        ngrams.add("suggest that the");
        ngrams.add("based on the");
        ngrams.add("involved in the");
        ngrams.add("to determine the");
        ngrams.add("required for the");
        ngrams.add("to that of");
        ngrams.add("each of the");
        ngrams.add("suggesting that the");
        ngrams.add("due to the");
        ngrams.add("for 5 min");
        ngrams.add("for 15 min");
        ngrams.add("the regulation of");
        ngrams.add("see materials and");
        ngrams.add("relative to the");
        ngrams.add("as described in the");
        ngrams.add("the activation of");
        ngrams.add("suggests that the");
        ngrams.add("presence of the");
        ngrams.add("sequence of the");
        ngrams.add("most of the");
        ngrams.add("according to the");
        ngrams.add("effect on the");
        ngrams.add("members of the");
        ngrams.add("cells in the");
        ngrams.add("that of the");
        ngrams.add("it is not");
        ngrams.add("in the case");
        ngrams.add("function of the");
        ngrams.add("part of the");
        ngrams.add("the exception of");
        ngrams.add("tip of the");
        ngrams.add("result in a");
        ngrams.add("should be noted that");
        ngrams.add("this suggests that the");
        ngrams.add("results are means");
        ngrams.add("in the absence of the");
        ngrams.add("but does not");
        ngrams.add("in the presence of the");
        ngrams.add("inserted into the");
        ngrams.add("this is consistent");
        ngrams.add("in 50 mm");
        ngrams.add("released from the");
        ngrams.add("was added and");
        ngrams.add("lead to the");
        ngrams.add("implicated in the");
        ngrams.add("added to a");
        ngrams.add("and characterization of");
        ngrams.add("with the use");
        ngrams.add("evidence for the");
        ngrams.add("the medium was");
        ngrams.add("reduction in the");
        ngrams.add("in a single");
        ngrams.add("modification of the");
        ngrams.add("it is a");
        ngrams.add("case of the");
        ngrams.add("by using the");
        ngrams.add("formation of the");
        ngrams.add("expressed as a percentage");
        ngrams.add("data not shown this");
        ngrams.add("directed against the");
        ngrams.add("results are consistent");
        ngrams.add("not shown thus");
        ngrams.add("the tip of the");
        ngrams.add("for at least");
        ngrams.add("this result is");
        ngrams.add("at the restrictive");
        ngrams.add("we tested the");
        ngrams.add("is important to");
        ngrams.add("and transferred to");
        ngrams.add("4 h in");
        ngrams.add("the function of the");
        ngrams.add("linked to the");
        ngrams.add("part of a");
        ngrams.add("defects in the");
        ngrams.add("figure 4 the");
        ngrams.add("the results are");
        ngrams.add("figure 3 the");
        ngrams.add("figure 5 the");
        ngrams.add("only in the");
        ngrams.add("addition of the");
        ngrams.add("and at the");
        ngrams.add("washed three times with");
        ngrams.add("a wide range");
        ngrams.add("increase in the");
        ngrams.add("responsible for the");
        ngrams.add("not shown the");
        ngrams.add("the presence of the");
        ngrams.add("compared with the");
        ngrams.add("the case of");
        ngrams.add("activation of the");
        ngrams.add("to bind to");
        ngrams.add("changes in the");
        ngrams.add("by the addition");
        ngrams.add("added to the");
        ngrams.add("the concentration of");
        ngrams.add("there is a");
        ngrams.add("indicating that the");
        ngrams.add("results in a");
        ngrams.add("role in the");
        ngrams.add("and in the");
        ngrams.add("for 2 h");
        ngrams.add("between the two");
        ngrams.add("observed in the");
        ngrams.add("presence or absence");
        ngrams.add("the presence or absence");
        ngrams.add("have been shown");
        ngrams.add("for 4 h");
        ngrams.add("the presence or");
        ngrams.add("corresponding to the");
        ngrams.add("similar to the");
        ngrams.add("used in the");
        ngrams.add("that it is");
        ngrams.add("regions of the");
        ngrams.add("or presence of");
        ngrams.add("1 ml of");
        ngrams.add("effect of the");
        ngrams.add("or absence of");
        ngrams.add("side of the");
        ngrams.add("position of the");
        ngrams.add("used in this");
        ngrams.add("we examined the");
        ngrams.add("found in the");
        ngrams.add("of the same");
        ngrams.add("presence or absence of");
        ngrams.add("is consistent with the");
        ngrams.add("such as the");
        ngrams.add("presence of a");
        ngrams.add("and that the");
        ngrams.add("the presence or absence of");
        ngrams.add("has not been");
        ngrams.add("of this article");
        ngrams.add("used as a");
        ngrams.add("in contrast the");
        ngrams.add("components of the");
        ngrams.add("for 20 min");
        ngrams.add("indicate that the");
        ngrams.add("been shown to be");
        ngrams.add("the presence of a");
        ngrams.add("possible that the");
        ngrams.add("in addition the");
        ngrams.add("10 min at");
        ngrams.add("is likely that");
        ngrams.add("portion of the");
        ngrams.add("change in the");
        ngrams.add("specificity of the");
        ngrams.add("some of the");
        ngrams.add("of the other");
        ngrams.add("that had been");
        ngrams.add("the absence or");
        ngrams.add("show that the");
        ngrams.add("to be a");
        ngrams.add("activity in the");
        ngrams.add("data not shown the");
        ngrams.add("in the absence or");
        ngrams.add("three independent experiments");
        ngrams.add("in the case of the");
        ngrams.add("in the presence of a");
        ngrams.add("be involved in the");
        ngrams.add("an increase in the");
        ngrams.add("with 1 ml of");
        ngrams.add("a large number");
        ngrams.add("which has been");
        ngrams.add("it is important");
        ngrams.add("depends on the");
        ngrams.add("there is an");
        ngrams.add("at a density");
        ngrams.add("5 min at");
        ngrams.add("that has been");
        ngrams.add("not bind to");
        ngrams.add("the case of the");
        ngrams.add("to estimate the");
        ngrams.add("to changes in");
        ngrams.add("fragment from the");
        ngrams.add("in a number");
        ngrams.add("defect in the");
        ngrams.add("for the first");
        ngrams.add("used as the");
        ngrams.add("it is the");
        ngrams.add("of the purified");
        ngrams.add("the presence and");
        ngrams.add("had no effect on the");
        ngrams.add("min at 30 8c");
        ngrams.add("for 20 min at");
        ngrams.add("here we show");
        ngrams.add("with respect to the");
        ngrams.add("it will be");
        ngrams.add("tested for their");
        ngrams.add("were then washed");
        ngrams.add("ability to bind");
        ngrams.add("we were unable");
        ngrams.add("we do not");
        ngrams.add("min at 30");
        ngrams.add("one copy of");
        ngrams.add("that at least");
        ngrams.add("the formation of a");
        ngrams.add("presence of 30");
        ngrams.add("not shown we");
        ngrams.add("respect to the");
        ngrams.add("some of these");
        ngrams.add("associated with a");
        ngrams.add("of a novel");
        ngrams.add("fig 1 a");
        ngrams.add("alignment of the");
        ngrams.add("both of these");
        ngrams.add("identity of the");
        ngrams.add("bottom of the");
        ngrams.add("and the resulting");
        ngrams.add("version of the");
        ngrams.add("figure 1 and");
        ngrams.add("of the various");
        ngrams.add("effect of a");
        ngrams.add("and analysis of");
        ngrams.add("growth of the");
        ngrams.add("in the other");
        ngrams.add("of the complex");
        ngrams.add("in the two");
        ngrams.add("results are means s");
        ngrams.add("it is likely that the");
        ngrams.add("we conclude that the");
        ngrams.add("test this hypothesis");
        ngrams.add("a single copy");
        ngrams.add("able to bind");
        ngrams.add("is likely that the");
        ngrams.add("the crystal structure");
        ngrams.add("decapping in vivo");
        ngrams.add("nature of the");
        ngrams.add("on the other");
        ngrams.add("expressed in the");
        ngrams.add("the materials and methods section");
        ngrams.add("materials and methods section");
        ngrams.add("in the absence or presence");
        ngrams.add("the absence or presence of");
        ngrams.add("absence or presence of");
        ngrams.add("the absence or presence");
        ngrams.add("the materials and methods");
        ngrams.add("and methods section");
        ngrams.add("absence or presence");
        ngrams.add("there is no");
        ngrams.add("resulted in a");
        ngrams.add("the materials and");
        ngrams.add("washed twice with");
        ngrams.add("could not be");
        ngrams.add("shown that the");
        ngrams.add("for 1 h at");
        ngrams.add("localized to the");
        ngrams.add("to be the");
        ngrams.add("final concentration of");
        ngrams.add("none of the");
        ngrams.add("absence of the");
        ngrams.add("control of the");
        ngrams.add("consistent with a");
        ngrams.add("to examine the");
        ngrams.add("detected in the");
        ngrams.add("as well as the");
        ngrams.add("well as the");
        ngrams.add("component of the");
        ngrams.add("surface of the");
        ngrams.add("of the three");
        ngrams.add("in the presence or absence");
        ngrams.add("mm tris hcl");
        ngrams.add("the experimental section");
        ngrams.add("at least two");
        ngrams.add("in the presence or");
        ngrams.add("determine whether the");
        ngrams.add("with or without");
        ngrams.add("half of the");
        ngrams.add("comparison of the");
        ngrams.add("ability of the");
        ngrams.add("sites in the");
        ngrams.add("because of the");
        ngrams.add("to determine whether the");
        ngrams.add("has also been");
        ngrams.add("the position of the");
        ngrams.add("derived from the");
        ngrams.add("member of the");
        ngrams.add("5 ml of");
        ngrams.add("obtained from the");
        ngrams.add("in the regulation");
        ngrams.add("washed three times");
        ngrams.add("min at room");
        ngrams.add("this article has");
        ngrams.add("a final concentration");
        ngrams.add("was added to the");
        ngrams.add("30 min at");
        ngrams.add("adjacent to the");
        ngrams.add("showed that the");
        ngrams.add("of a single");
        ngrams.add("localization of the");
        ngrams.add("of the first");
        ngrams.add("of the human");
        ngrams.add("min at room temperature");
        ngrams.add("has been cited by");
        ngrams.add("a final concentration of");
        ngrams.add("amino acid residues");
        ngrams.add("is required for the");
        ngrams.add("the other hand");
        ngrams.add("c p m");
        ngrams.add("0 5 μg");
        ngrams.add("ligated into the");
        ngrams.add("may also be");
        ngrams.add("several lines of");
        ngrams.add("fig 2 b");
        ngrams.add("agouti protein and");
        ngrams.add("the x chromosome");
        ngrams.add("is regulated by");
        ngrams.add("as has been");
        ngrams.add("under the same");
        ngrams.add("that they are");
        ngrams.add("and analysed by");
        ngrams.add("localizes to the");
        ngrams.add("at a concentration");
        ngrams.add("in addition we");
        ngrams.add("parts of the");
        ngrams.add("characterization of a");
        ngrams.add("except that the");
        ngrams.add("for the initial");
        ngrams.add("used in these");
        ngrams.add("resulting in a");
        ngrams.add("suggested by the");
        ngrams.add("targeted to the");
        ngrams.add("were expressed in");
        ngrams.add("the other two");
        ngrams.add("for binding to");
        ngrams.add("recovered in the");
        ngrams.add("of the entire");
        ngrams.add("to those of");
        ngrams.add("percentage of the");
        ngrams.add("that this is");
        ngrams.add("top of the");
        ngrams.add("of these cells");
        ngrams.add("map of the");
        ngrams.add("and methods the");
        ngrams.add("of the interaction");
        ngrams.add("interaction of the");
        ngrams.add("phase of the");
        ngrams.add("results of the");
        ngrams.add("are means s e");
        ngrams.add("at 37 8c for");
        ngrams.add("at restrictive temperatures");
        ngrams.add("extracts prepared from");
        ngrams.add("early and late");
        ngrams.add("for 48 h");
        ngrams.add("but did not");
        ngrams.add("for 16 h");
        ngrams.add("is not yet");
        ngrams.add("high concentrations of");
        ngrams.add("the same conditions");
        ngrams.add("fig 1 c");
        ngrams.add("a role in the");
        ngrams.add("the bottom of the");
        ngrams.add("agreement with the");
        ngrams.add("to understand the");
        ngrams.add("were collected and");
        ngrams.add("correspond to the");
        ngrams.add("that we have");
        ngrams.add("be the result");
        ngrams.add("by the fact");
        ngrams.add("1 h with");
        ngrams.add("function as a");
        ngrams.add("hypothesis that the");
        ngrams.add("effects on the");
        ngrams.add("for the production");
        ngrams.add("was expressed in");
        ngrams.add("figure 4 a");
        ngrams.add("followed by the");
        ngrams.add("essential for the");
        ngrams.add("consequence of the");
        ngrams.add("and analyzed by");
        ngrams.add("found that the");
        ngrams.add("any of the");
        ngrams.add("role of the");
        ngrams.add("as in the");
        ngrams.add("in materials and methods");
        ngrams.add("at least three");
        ngrams.add("account for the");
        ngrams.add("there was a");
        ngrams.add("as a function");
        ngrams.add("interact with the");
        ngrams.add("in materials and");
        ngrams.add("bound to the");
        ngrams.add("for the presence");
        ngrams.add("incubated in the");
        ngrams.add("three times with");
        ngrams.add("the ability of the");
        ngrams.add("location of the");
        ngrams.add("size of the");
        ngrams.add("results in the");
        ngrams.add("is that the");
        ngrams.add("contribute to the");
        ngrams.add("led to the");
        ngrams.add("and resuspended in");
        ngrams.add("demonstrate that the");
        ngrams.add("suggested that the");
        ngrams.add("with the same");
        ngrams.add("in the materials and methods");
        ngrams.add("in the materials and");
        ngrams.add("close to the");
        ngrams.add("in the materials");
        ngrams.add("described in materials and methods");
        ngrams.add("for 30 min at");
        ngrams.add("described in materials and");
        ngrams.add("described in materials");
        ngrams.add("dependent on the");
        ngrams.add("to a final");
        ngrams.add("to investigate the");
        ngrams.add("is expressed in");
        ngrams.add("face of the");
        ngrams.add("each of these");
        ngrams.add("or in the");
        ngrams.add("it is possible that the");
        ngrams.add("cells were treated with");
        ngrams.add("is possible that the");
        ngrams.add("one or more");
        ngrams.add("have not been");
        ngrams.add("may not be");
        ngrams.add("under the control");
        ngrams.add("it is also");
        ngrams.add("followed by a");
        ngrams.add("the structure of the");
        ngrams.add("basis of the");
        ngrams.add("with the indicated");
        ngrams.add("positions of the");
        ngrams.add("in the first");
        ngrams.add("were washed twice");
        ngrams.add("for example the");
        ngrams.add("related to the");
        ngrams.add("not shown and");
        ngrams.add("addition to the");
        ngrams.add("in the medium");
        ngrams.add("sequences of the");
        ngrams.add("domain of the");
        ngrams.add("site of the");
        ngrams.add("that in the");
        ngrams.add("it should be");
        ngrams.add("is not clear");
        ngrams.add("these results are");
        ngrams.add("shows that the");
        ngrams.add("copies of the");
        ngrams.add("determination of the");
        ngrams.add("binds to the");
        ngrams.add("stability of the");
        ngrams.add("is the first");
        ngrams.add("of the native");
        ngrams.add("even in the");
        ngrams.add("which is a");
        ngrams.add("of which are");
        ngrams.add("of a number");
        ngrams.add("in the reaction");
        ngrams.add("of the corresponding");
        ngrams.add("in the formation");
        ngrams.add("in activation of");
        ngrams.add("of the small");
        ngrams.add("concentration of the");
        ngrams.add("of the growth");
        ngrams.add("the absence or presence of 30");
        ngrams.add("are means s e m");
        ngrams.add("absence or presence of 30");
        ngrams.add("it has been proposed");
        ngrams.add("provided by dr");
        ngrams.add("or presence of 30");
        ngrams.add("materials and methods the");
        ngrams.add("results suggest that the");
        ngrams.add("has recently been");
        ngrams.add("not yet been");
        ngrams.add("was added to a");
        ngrams.add("then treated with");
        ngrams.add("min followed by");
        ngrams.add("a portion of the");
        ngrams.add("there are no");
        ngrams.add("been suggested that");
        ngrams.add("known about the");
        ngrams.add("we have previously");
        ngrams.add("it can be");
        ngrams.add("which have been");
        ngrams.add("fig 1 b");
        ngrams.add("min at 4");
        ngrams.add("separated on a");
        ngrams.add("is activated by");
        ngrams.add("differences between the");
        ngrams.add("but it is");
        ngrams.add("for 3 min");
        ngrams.add("the length of the");
        ngrams.add("were harvested and");
        ngrams.add("as a probe");
        ngrams.add("in 20 mm");
        ngrams.add("the product of the");
        ngrams.add("transferred to a");
        ngrams.add("30 min the");
        ngrams.add("the vicinity of");
        ngrams.add("in the activation of");
        ngrams.add("interacts with the");
        ngrams.add("concentration of 0");
        ngrams.add("the effects of the");
        ngrams.add("it was not");
        ngrams.add("affected by the");
        ngrams.add("attached to the");
        ngrams.add("portions of the");
        ngrams.add("leading to the");
        ngrams.add("for a further");
        ngrams.add("to explain the");
        ngrams.add("leads to the");
        ngrams.add("presence of 0");
        ngrams.add("of each of the");
        ngrams.add("sensitive to the");
        ngrams.add("table 1 in");
        ngrams.add("all of which");
        ngrams.add("on the same");
        ngrams.add("understanding of the");
        ngrams.add("with those of");
        ngrams.add("resulted in the");
        ngrams.add("indicated that the");
        ngrams.add("regulation of the");
        ngrams.add("form of the");
        ngrams.add("effects of the");
        ngrams.add("increasing concentrations of");
        ngrams.add("difference between the");
        ngrams.add("demonstrated that the");
        ngrams.add("one of these");
        ngrams.add("than that of");
        ngrams.add("used for the");
        ngrams.add("in both the");
        ngrams.add("cells were transfected with");
        ngrams.add("no effect on the");
        ngrams.add("was used as a");
        ngrams.add("this study we");
        ngrams.add("the nature of the");
        ngrams.add("however it is");
        ngrams.add("that have been");
        ngrams.add("use of a");
        ngrams.add("in the second");
        ngrams.add("studies of the");
        ngrams.add("studies have shown");
        ngrams.add("by incubation with");
        ngrams.add("of at least");
        ngrams.add("note that the");
        ngrams.add("but not in");
        ngrams.add("the sequence of the");
        ngrams.add("likely that the");
        ngrams.add("in the experimental");
        ngrams.add("the activity of the");
        ngrams.add("copy of the");
        ngrams.add("located in the");
        ngrams.add("function in the");
        ngrams.add("and the other");
        ngrams.add("described in the materials and methods");
        ngrams.add("described in the materials and");
        ngrams.add("described in the experimental");
        ngrams.add("described in the materials");
        ngrams.add("we did not");
        ngrams.add("there was no");
        ngrams.add("as a percentage");
        ngrams.add("away from the");
        ngrams.add("the basis of the");
        ngrams.add("fragment containing the");
        ngrams.add("not shown this");
        ngrams.add("to identify the");
        ngrams.add("isolated from the");
        ngrams.add("use of the");
        ngrams.add("two of the");
        ngrams.add("as described in the materials and");
        ngrams.add("as described in the experimental");
        ngrams.add("as described in the materials");
        ngrams.add("the fact that the");
        ngrams.add("version of this");
        ngrams.add("expressed as a");
        ngrams.add("the absence of the");
        ngrams.add("fact that the");
        ngrams.add("indicates that the");
        ngrams.add("evidence that the");
        ngrams.add("of these two");
        ngrams.add("characterization of the");
        ngrams.add("model for the");
        ngrams.add("differences in the");
        ngrams.add("to that of the");
        ngrams.add("seen in the");
        ngrams.add("residues of the");
        ngrams.add("should be noted");
        ngrams.add("does not appear");
        ngrams.add("are consistent with the");
        ngrams.add("at least one");
        ngrams.add("presence of 1");
        ngrams.add("to inhibit the");
        ngrams.add("important for the");
        ngrams.add("of one or");
        ngrams.add("by using a");
        ngrams.add("and 1 mm");
        ngrams.add("found in a");
        ngrams.add("shown on the");
        ngrams.add("production of the");
        ngrams.add("for each of");
        ngrams.add("added and the");
        ngrams.add("this is a");
        ngrams.add("and used to");
        ngrams.add("out of the");
        ngrams.add("performed in the");
        ngrams.add("in the activation");
        ngrams.add("however in the");
        ngrams.add("not in the");
        ngrams.add("to the manufacturer's instructions");
        ngrams.add("2 5 lg ml");
        ngrams.add("has been proposed that");
        ngrams.add("data not shown thus");
        ngrams.add("is known about the");
        ngrams.add("has been shown that");
        ngrams.add("data not shown and");
        ngrams.add("a conformational change");
        ngrams.add("for 1 h with");
        ngrams.add("for 4 h in");
        ngrams.add("the permissive temperature");
        ngrams.add("reactions were performed");
        ngrams.add("were obtained from the");
        ngrams.add("insight into the");
        ngrams.add("out as described");
        ngrams.add("were washed three");
        ngrams.add("there may be");
        ngrams.add("various concentrations of");
        ngrams.add("acts as a");
        ngrams.add("therefore it is");
        ngrams.add("for 2 hr");
        ngrams.add("only a single");
        ngrams.add("is a member");
        ngrams.add("thus it is");
        ngrams.add("the identity of the");
        ngrams.add("indicated by an");
        ngrams.add("interactions between the");
        ngrams.add("the positions of the");
        ngrams.add("1 min at");
        ngrams.add("in the presence and");
        ngrams.add("the interaction of the");
        ngrams.add("well as in");
        ngrams.add("located at the");
        ngrams.add("probed with the");
        ngrams.add("we used a");
        ngrams.add("transformed with the");
        ngrams.add("we compared the");
        ngrams.add("at the level");
        ngrams.add("examination of the");
        ngrams.add("the column was");
        ngrams.add("and table 1");
        ngrams.add("removal of the");
        ngrams.add("features of the");
        ngrams.add("treated with the");
        ngrams.add("to be an");
        ngrams.add("the results of the");
        ngrams.add("figure 2 a");
        ngrams.add("3 and 5");
        ngrams.add("may be the");
        ngrams.add("orientation of the");
        ngrams.add("residue in the");
        ngrams.add("present in a");
        ngrams.add("site at the");
        ngrams.add("in addition to the");
        ngrams.add("and probed with");
        ngrams.add("supported by the");
        ngrams.add("at least in");
        ngrams.add("and subjected to");
        ngrams.add("and stained with");
        ngrams.add("presence of an");
        ngrams.add("from the same");
        ngrams.add("to study the");
        ngrams.add("residues in the");
        ngrams.add("that the two");
        ngrams.add("expression of a");
        ngrams.add("and that this");
        ngrams.add("as described in materials and");
        ngrams.add("to a final concentration");
        ngrams.add("as described in materials");
        ngrams.add("the present study we");
        ngrams.add("present study we");
        ngrams.add("we found that the");
        ngrams.add("15 min at");
        ngrams.add("the presence of an");
        ngrams.add("depending on the");
        ngrams.add("the end of the");
        ngrams.add("to the manufacturer's");
        ngrams.add("to assess the");
        ngrams.add("at the end");
        ngrams.add("possibility that the");
        ngrams.add("the reaction was");
        ngrams.add("included in the");
        ngrams.add("but not the");
        ngrams.add("formation of a");
        ngrams.add("purification of the");
        ngrams.add("this is the");
        ngrams.add("shown in the");
        ngrams.add("on the basis of the");
        ngrams.add("for 1 hr");
        ngrams.add("the size of the");
        ngrams.add("that there is");
        ngrams.add("in the context");
        ngrams.add("the control of the");
        ngrams.add("properties of the");
        ngrams.add("contrast to the");
        ngrams.add("assembly of the");
        ngrams.add("length of the");
        ngrams.add("figure 2 the");
        ngrams.add("many of the");
        ngrams.add("product of the");
        ngrams.add("fraction of the");
        ngrams.add("those of the");
        ngrams.add("figure 1 the");
        ngrams.add("as in a");
        ngrams.add("these results indicate");
        ngrams.add("the possibility that the");
        ngrams.add("act as a");
        ngrams.add("to each other");
        ngrams.add("encoded by the");
        ngrams.add("not affect the");
        ngrams.add("interaction between the");
        ngrams.add("conclude that the");
        ngrams.add("caused by the");
        ngrams.add("prior to the");
        ngrams.add("together with the");
        ngrams.add("a concentration of");
        ngrams.add("specific for the");
        ngrams.add("distribution of the");
        ngrams.add("of the reaction");
        ngrams.add("fragment of the");
        ngrams.add("of expression of");
        ngrams.add("for 15 min at");
        ngrams.add("under the control of the");
        ngrams.add("supplemented with 10");
        ngrams.add("amounts of the");
        ngrams.add("figure 2 and");
        ngrams.add("absence of a");
        ngrams.add("grown in the");
        ngrams.add("of the full-length");
        ngrams.add("localization to the");
        ngrams.add("to increase the");
        ngrams.add("observed for the");
        ngrams.add("of the up");
        ngrams.add("identified in the");
        ngrams.add("concentrations of the");
        ngrams.add("result of the");
        ngrams.add("in all the");
        ngrams.add("min at 37 8c");
        ngrams.add("these results are consistent");
        ngrams.add("added to a final");
        ngrams.add("it seems likely");
        ngrams.add("seems likely that");
        ngrams.add("carried out on");
        ngrams.add("excess of unlabelled");
        ngrams.add("we show that the");
        ngrams.add("min at 37");
        ngrams.add("h at room");
        ngrams.add("truncated form of");
        ngrams.add("arrows indicate the");
        ngrams.add("was used as the");
        ngrams.add("is involved in the");
        ngrams.add("the hypothesis that the");
        ngrams.add("three times in");
        ngrams.add("can also be");
        ngrams.add("two or more");
        ngrams.add("containing 0 5");
        ngrams.add("which is consistent");
        ngrams.add("relationship between the");
        ngrams.add("although it is");
        ngrams.add("the presence of 1");
        ngrams.add("rather than the");
        ngrams.add("distance between the");
        ngrams.add("mg ml in");
        ngrams.add("that there are");
        ngrams.add("in patients with");
        ngrams.add("to produce a");
        ngrams.add("localize to the");
        ngrams.add("observation that the");
        ngrams.add("on the ability");
        ngrams.add("were prepared and");
        ngrams.add("and can be");
        ngrams.add("comparison with the");
        ngrams.add("not shown to");
        ngrams.add("by binding to");
        ngrams.add("occur in the");
        ngrams.add("that the interaction");
        ngrams.add("in the production");
        ngrams.add("that activation of");
        ngrams.add("forms of the");
        ngrams.add("such that the");
        ngrams.add("is one of");
        ngrams.add("activities of the");
        ngrams.add("specific to the");
        ngrams.add("and absence of");
        ngrams.add("of the four");
        ngrams.add("in the number");
        ngrams.add("and is not");
        ngrams.add("this is in");
        ngrams.add("in each of");
        ngrams.add("region in the");
        ngrams.add("in all of");
        ngrams.add("than in the");
        ngrams.add("region and the");
        ngrams.add("min in the");
        ngrams.add("both of the");
        ngrams.add("loss of function");
        ngrams.add("is inhibited by");
        ngrams.add("we have not");
        ngrams.add("for 3 h");
        ngrams.add("the surface of the");
        ngrams.add("from a single");
        ngrams.add("to form a");
        ngrams.add("all of these");
        ngrams.add("majority of the");
        ngrams.add("disruption of the");
        ngrams.add("interaction with the");
        ngrams.add("to test the");
        ngrams.add("incubated with the");
        ngrams.add("is not a");
        ngrams.add("result in the");
        ngrams.add("the degradation of");
        ngrams.add("of each of");
        ngrams.add("with that of");
        ngrams.add("a member of the");
        ngrams.add("for their ability");
        ngrams.add("in contrast to the");
        ngrams.add("to this article");
        ngrams.add("response to this");
        ngrams.add("with 1 ml");
        ngrams.add("are expressed in");
        ngrams.add("mediated by the");
        ngrams.add("the role of the");
        ngrams.add("necessary for the");
        ngrams.add("the effect of the");
        ngrams.add("revealed that the");
        ngrams.add("table 2 the");
        ngrams.add("indicated by the");
        ngrams.add("and it is");
        ngrams.add("1 2 and");
        ngrams.add("loss of the");
        ngrams.add("site in the");
        ngrams.add("from that of");
        ngrams.add("for 2 h at");
        ngrams.add("room temperature for");
        ngrams.add("more than one");
        ngrams.add("it does not");
        ngrams.add("and stored at");
        ngrams.add("that do not");
        ngrams.add("the location of the");
        ngrams.add("not shown these");
        ngrams.add("been shown that");
        ngrams.add("as a single");
        ngrams.add("may be a");
        ngrams.add("the samples were");
        ngrams.add("decrease in the");
        ngrams.add("proportion of the");
        ngrams.add("determined by the");
        ngrams.add("role for the");
        ngrams.add("by the presence");
        ngrams.add("the stimulation of");
        ngrams.add("to have a");
        ngrams.add("content of the");
        ngrams.add("of the second");
        ngrams.add("levels of the");
        ngrams.add("these data indicate");
        ngrams.add("have shown that the");
        ngrams.add("may play a");
        ngrams.add("be noted that");
        ngrams.add("20 min at");
        ngrams.add("two copies of");
        ngrams.add("have also been");
        ngrams.add("it may be");
        ngrams.add("the majority of the");
        ngrams.add("to be involved");
        ngrams.add("led to a");
        ngrams.add("explanation for the");
        ngrams.add("of both the");
        ngrams.add("reactions were carried out");
        ngrams.add("h at room temperature");
        ngrams.add("tested for their ability");
        ngrams.add("at 4 8c with");
        ngrams.add("in the presence of 1");
        ngrams.add("two copies of the");
        ngrams.add("other members of the");
        ngrams.add("reactions were carried");
        ngrams.add("at a concentration of");
        ngrams.add("the existence of a");
        ngrams.add("for 60 min");
        ngrams.add("not shown suggesting");
        ngrams.add("the remainder of the");
        ngrams.add("for 24 h");
        ngrams.add("there are two");
        ngrams.add("4 h in the");
        ngrams.add("a percentage of the");
        ngrams.add("were crossed to");
        ngrams.add("to bind to the");
        ngrams.add("introduced into the");
        ngrams.add("between these two");
        ngrams.add("determine if the");
        ngrams.add("were pooled and");
        ngrams.add("30 min in");
        ngrams.add("the total number");
        ngrams.add("present in all");
        ngrams.add("not shown figure");
        ngrams.add("in the vicinity");
        ngrams.add("along with a");
        ngrams.add("associates with the");
        ngrams.add("that are required");
        ngrams.add("support of this");
        ngrams.add("existence of a");
        ngrams.add("a function of the");
        ngrams.add("and do not");
        ngrams.add("sides of the");
        ngrams.add("identified as a");
        ngrams.add("only one of");
        ngrams.add("the localization of the");
        ngrams.add("removed from the");
        ngrams.add("remainder of the");
        ngrams.add("diagram of the");
        ngrams.add("with the appropriate");
        ngrams.add("shown to have");
        ngrams.add("except for the");
        ngrams.add("min after the");
        ngrams.add("5 min and");
        ngrams.add("al 1991 the");
        ngrams.add("at the 5'");
        ngrams.add("the reactions were");
        ngrams.add("so that the");
        ngrams.add("this is not");
        ngrams.add("purified from the");
        ngrams.add("interactions with the");
        ngrams.add("sites on the");
        ngrams.add("and purification of");
        ngrams.add("identical to the");
        ngrams.add("in the initial");
        ngrams.add("ends of the");
        ngrams.add("recognition of the");
        ngrams.add("figure 1 a");
        ngrams.add("of the central");
        ngrams.add("in the amount");
        ngrams.add("compared to the");
        ngrams.add("response to the");
        ngrams.add("of the five");
        ngrams.add("of the resulting");
        ngrams.add("independent of the");
        ngrams.add("study of the");
        ngrams.add("and the presence");
        ngrams.add("evidence for a");
        ngrams.add("due to a");
        ngrams.add("is not the");
    }
    public String classify(NGram n) {
        if(ngrams.contains(n.getText())) {
            return "Excluded";
        } else {
            return "Unknown";
        }
    }
    public void filterList(List<NGram> l) {
        Iterator<NGram> it = l.iterator();
        while(it.hasNext()) {
            NGram cur = it.next();
            if(ngrams.contains(cur.getText())) {
                it.remove();
            }
        }
    }
}
