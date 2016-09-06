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
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.HashSet;

import ie.tcd.slscs.bundles.Utils;

public class Biber1999Academic implements Classifier {
    private Map<String, String> bundles;
    private Set<String> pre4gram;
    private Set<String> post4gram;
    private Set<String> pre5gram;
    private Set<String> post5gram;
    private Map<String, String> sections;

    public Biber1999Academic() {
        bundles = new HashMap<String, String>();
        sections = new HashMap<String, String>();
        pre4gram = new HashSet<String>();
        post4gram = new HashSet<String>();
        pre5gram = new HashSet<String>();
        post5gram = new HashSet<String>();
        init_bundles();
        init_sections();
    }
    private void init_sections() {
        sections.put("NP+of", "13.2.4.1");
        sections.put("other NP", "13.2.4.2");
        sections.put("other NP + post nominal clause", "13.2.4.2");
        sections.put("other NP + PP", "13.2.4.2");
        sections.put("PP+of", "13.2.4.3");
        sections.put("other PP", "13.2.4.4");
        sections.put("anticipatory it", "13.2.4.5");
        sections.put("anticipatory it + adjective phrase", "13.2.4.5");
        sections.put("anticipatory it + verb phrase", "13.2.4.5");
        sections.put("passive verb + PP", "13.2.4.6");
        sections.put("copula be +noun phrase", "13.2.4.7");
        sections.put("copula be +adjective phrase", "13.2.4.7");
        sections.put("copula be +noun/adjective phrase", "13.2.4.7");
        sections.put("verb phrase + that clause", "13.2.4.8");
        sections.put("that clause", "13.2.4.8");
        sections.put("noun + verb phrase + that clause", "13.2.4.8");
        sections.put("predicative adjective + to-clause", "13.2.4.9");
        sections.put("verb phrase + to-clause", "13.2.4.9");
        sections.put("to-clause", "13.2.4.9");
        sections.put("adverbial clause", "13.2.4.10");
        sections.put("pronoun/noun phrase + be", "13.2.4.11");
        sections.put("this + be", "13.2.4.11");
        sections.put("there + be", "13.2.4.11");
        sections.put("other expressions", "13.2.4.12");
    }
    private void init_bundles() {
        addEntry("the end of the", "NP+of", true, false);
        addEntry("the beginning of the", "NP+of", true, false);
        addEntry("the base of the", "NP+of", true, false);
        addEntry("the position of the", "NP+of", false, false);
        addEntry("the shape of the", "NP+of", false, false);
        addEntry("the size of the", "NP+of", false, false);
        addEntry("the shrcture of the", "NP+of", false, false);
        addEntry("the surface of the", "NP+of", true, false);
        addEntry("the top of the", "NP+of", false, false);
        addEntry("the start of the", "NP+of", true, false);
        addEntry("the form of a", "NP+of", true, false);
        addEntry("the form of the", "NP+of", false, false);
        addEntry("the length of the", "NP+of", false, false);
        addEntry("the magnitude of the", "NP+of", false, false);
        addEntry("the edge of the", "NP+of", false, false);
        addEntry("the composition of the", "NP+of", false, false);
        addEntry("both sides of the", "NP+of", false, false);
        addEntry("the centre of the", "NP+of", false, false);
        addEntry("the temperature of the", "NP+of", false, false);
        addEntry("the level of the", "NP+of", true, false);
        addEntry("the context of the", "NP+of", true, false);
        addEntry("different parts of the", "NP+of", true, false);
        addEntry("other parts of the", "NP+of", false, false);
        addEntry("part of the body", "NP+of", false, false);
        addEntry("parts of the body", "NP+of", false, false);
        addEntry("parts of the world", "NP+of", false, false);
        addEntry("the paw of the", "NP+of", true, false);
        addEntry("the rest of the", "NP+of", false, false);
        addEntry("the total number of", "NP+of", false, false);
        addEntry("the first of these", "NP+of", false, false);
        addEntry("and the number of", "NP+of", false, false);
        addEntry("the sum of the", "NP+of", false, false);
        addEntry("one of the most", "NP+of", true, true);
        addEntry("one of the main", "NP+of", false, false);
        addEntry("the case of the", "NP+of", true, false);
        addEntry("the case of a", "NP+of", true, false);
        addEntry("the nature of the", "NP+of", true, false);
        addEntry("the use of the", "NP+of", true, false);
        addEntry("the value of the", "NP+of", false, false);
        addEntry("the role of the", "NP+of", false, false);
        addEntry("the basis of the", "NP+of", true, false);
        addEntry("the purpose of the", "NP+of", false, false);
        addEntry("the use of a", "NP+of", false, false);
        addEntry("the importance of the", "NP+of", false, false);
        addEntry("the results of the", "NP+of", false, false);
        addEntry("the effect of the", "NP+of", false, false);
        addEntry("the effects of the", "NP+of", false, false);
        addEntry("the development of the", "NP+of", false, false);
        addEntry("the time of the", "NP+of", true, false);
        addEntry("and the development of", "NP+of", false, false);
        addEntry("the development of a", "NP+of", false, false);
        addEntry("the formation of the", "NP+of", false, false);
        addEntry("the history of the", "NP+of", false, false);
        addEntry("the course of the", "NP+of", true, false);
        addEntry("the early stages of", "NP+of", true, false);
        addEntry("the origin of the", "NP+of", false, false);
        addEntry("the presence of a", "NP+of", false, false);
        addEntry("the presence of the", "NP+of", false, false);
        addEntry("presence or absence of", "NP+of", true, false);
        addEntry("the absence of a", "NP+of", false, false);
        addEntry("the existence of a", "NP+of", false, false);
        addEntry("point of view of", "NP+of", true, false);
        addEntry("the point of view", "NP+of", true, true);
        addEntry("the ability of the", "NP+of", false, false);
        addEntry("the needs of the", "NP+of", false, false);
        addEntry("the work of the", "NP+of", false, false);
        addEntry("per cent of the", "NP+of", false, false);
        addEntry("the division of labour", "NP+of", true, false);
        addEntry("the secretary of state", "NP+of", false, false);
        addEntry("the point of view of", "NP+of", true, false);
        addEntry("the aim of this study", "NP+of", false, true);
        addEntry("the presence or absence of", "NP+of", false, false);
        addEntry("the first part of the", "NP+of", false, false);
        addEntry("the other end of the", "NP+of", false, false);
        addEntry("the rate of change of", "NP+of", false, false);
        addEntry("one of the most important", "NP+of", false, false);

        addEntry("the way in which", "other NP + post nominal clause", false, true);
        addEntry("the ways in which", "other NP + post nominal clause", false, false);
        addEntry("way in which the", "other NP + post nominal clause", true, false);
        addEntry("such a way that", "other NP + post nominal clause", true, false);
        addEntry("the extent to which", "other NP + post nominal clause", true, true);
        addEntry("extent to which the", "other NP + post nominal clause", true, false);
        addEntry("the fact that the", "other NP + post nominal clause", false, false);
        addEntry("the fact that it", "other NP + post nominal clause", false, false);
        addEntry("the degree to which", "other NP + post nominal clause", false, false);
        addEntry("the relationship between the", "other NP + PP", false, false);
        addEntry("the difference between the", "other NP + PP", false, false);
        addEntry("an important part in", "other NP + PP", false, false);
        addEntry("an important role in", "other NP + PP", false, false);
        addEntry("an increase in the", "other NP + PP", false, false);
        addEntry("the same way as", "other NP + PP", true, false);
        addEntry("the way in which the", "other NP", false, false);
        addEntry("such a way as to", "other NP", true, false);
        addEntry("the extent to which the", "other NP", false, false);
        addEntry("and the extent to which", "other NP", false, false);

        addEntry("about the nature of", "PP+of", false, false);
        addEntry("as a result of", "PP+of", false, true);
        addEntry("as a function of", "PP+of", false, false);
        addEntry("as part of the", "PP+of", false, false);
        addEntry("as a consequence of", "PP+of", false, false);
        addEntry("as a matter of", "PP+of", false, false);
        addEntry("as a means of", "PP+of", false, false);
        addEntry("as part of a", "PP+of", false, false);
        addEntry("at the end of", "PP+of", false, true);
        addEntry("at the time of", "PP+of", false, true);
        addEntry("at the beginning of", "PP+of", false, true);
        addEntry("at the level of", "PP+of", false, true);
        addEntry("at the expense of", "PP+of", false, false);
        addEntry("ot the start of", "PP+of", false, true);
        addEntry("by the end of", "PP+of", false, true);
        addEntry("by the presence of", "PP+of", false, false);
        addEntry("by the use of", "PP+of", false, false);
        addEntry("for the development of", "PP+of", false, false);
        addEntry("for the purpose of", "PP+of", false, false);
        addEntry("for the purposes of", "PP+of", false, false);
        addEntry("from the point of", "PP+of", false, true);
        addEntry("in the case of", "PP+of", false, true);
        addEntry("in the absence of", "PP+of", false, false);
        addEntry("in the form of", "PP+of", false, true);
        addEntry("in the presence of", "PP+of", false, false);
        addEntry("in a number of", "PP+of", false, true);
        addEntry("in terms of the", "PP+of", false, false);
        addEntry("in the context of", "PP+of", false, true);
        addEntry("in the course of", "PP+of", false, true);
        addEntry("in the development of", "PP+of", false, false);
        addEntry("in the number of", "PP+of", false, false);
        addEntry("in the process of", "PP+of", false, false);
        addEntry("in a variety of", "PP+of", false, true);
        addEntry("in the area of", "PP+of", false, false);
        addEntry("in the direction of", "PP+of", false, false);
        addEntry("in the face of", "PP+of", false, false);
        addEntry("in the formation of", "PP+of", false, false);
        addEntry("in the pathogenesis of", "PP+of", false, false);
        addEntry("in the study of", "PP+of", false, false);
        addEntry("in the treatment of", "PP+of", false, false);
        addEntry("in the use of", "PP+of", false, true);
        addEntry("in view of the", "PP+of", false, false);
        addEntry("of a number of", "PP+of", false, false);
        addEntry("of some of the", "PP+of", false, false);
        addEntry("of the fleets of", "PP+of", false, false);
        addEntry("of the nature of", "PP+of", false, true);
        addEntry("of the use of", "PP+of", false, false);
        addEntry("on the basis of", "PP+of", false, true);
        addEntry("on the part of", "PP+of", false, true);
        addEntry("on the surface of", "PP+of", false, true);
        addEntry("over a period of", "PP+of", false, false);
        addEntry("to the development of", "PP+of", false, false);
        addEntry("to that of the", "PP+of", true, false);
        addEntry("to the presence of", "PP+of", false, false);
        addEntry("to the use of", "PP+of", false, false);
        addEntry("with the exception of", "PP+of", false, false);
        addEntry("as a result of the", "PP+of", false, false);
        addEntry("as in the case of", "PP+of", false, false);
        addEntry("at the end of the", "PP+of", false, false);
        addEntry("at the beginning of the", "PP+of", false, false);
        addEntry("at the time of the", "PP+of", false, false);
        addEntry("at the base of the", "PP+of", false, false);
        addEntry("at the end of a", "PP+of", false, false);
        addEntry("at the end of this", "PP+of", false, false);
        addEntry("at the level of the", "PP+of", false, false);
        addEntry("at the start of the", "PP+of", false, false);
        addEntry("at the time of writing", "PP+of", false, false);
        addEntry("by the end of the", "PP+of", false, false);
        addEntry("from the point of view", "PP+of", false, true);
        addEntry("in the case of the", "PP+of", false, false);
        addEntry("in the case of a", "PP+of", false, false);
        addEntry("in the context of the", "PP+of", false, false);
        addEntry("in the division of labour", "PP+of", false, false);
        addEntry("in the form of a", "PP+of", false, false);
        addEntry("in a number of ways", "PP+of", false, false);
        addEntry("in a variety of ways", "PP+of", false, false);
        addEntry("in different parts of the", "PP+of", false, false);
        addEntry("in the course of the", "PP+of", false, false);
        addEntry("in the early stages of", "PP+of", false, false);
        addEntry("in the use of the", "PP+of", false, false);
        addEntry("of the nature of the", "PP+of", false, false);
        addEntry("on the basis of the", "PP+of", false, false);
        addEntry("on the basis of their", "PP+of", false, false);
        addEntry("on the part of the", "PP+of", false, false);
        addEntry("on the surface of the", "PP+of", false, false);
        addEntry("similar to that of the", "PP+of", false, false);
        addEntry("similar to those of the", "PP+of", false, false);
        addEntry("from the point of view of", "PP+of", false, false);

        addEntry("as in the case", "other PP", false, true);
        addEntry("at the same time", "other PP", true, true);
        addEntry("between the two groups", "other PP", false, false);
        addEntry("by the fact that", "other PP", false, false);
        addEntry("for the first time", "other PP", false, false);
        addEntry("from the fact that", "other PP", false, false);
        addEntry("in such a way", "other PP", false, true);
        addEntry("in the same way", "other PP", false, true);
        addEntry("in the present study", "other PP", false, false);
        addEntry("in a way that", "other PP", false, false);
        addEntry("in addition to the", "other PP", false, false);
        addEntry("in an attempt to", "other PP", false, false);
        addEntry("in contrast to the", "other PP", false, false);
        addEntry("in relation to the", "other PP", false, false);
        addEntry("in the early stages", "other PP", false, true);
        addEntry("in the first place", "other PP", false, false);
        addEntry("in the next chapter", "other PP", false, false);
        addEntry("in the next section", "other PP", false, false);
        addEntry("in the nineteenth century", "other PP", false, false);
        addEntry("in the sense that", "other PP", false, false);
        addEntry("in this case the", "other PP", false, false);
        addEntry("in the United States", "other PP", false, false);
        addEntry("in England and Wales", "other PP", false, false);
        addEntry("in the United Kingdom", "other PP", false, false);
        addEntry("of the fact that", "other PP", false, false);
        addEntry("of the most important", "other PP", true, false);
        addEntry("of the nineteenth century", "other PP", false, false);
        addEntry("on the other hand", "other PP", false, false);
        addEntry("on the one hand", "other PP", false, true);
        addEntry("on the grounds that", "other PP", false, false);
        addEntry("similar to that of", "other PP", true, true);
        addEntry("similar to those of", "other PP", false, true);
        addEntry("to the extent that", "other PP", false, false);
        addEntry("to the fact that", "other PP", false, false);
        addEntry("with respect to the", "other PP", false, false);
        addEntry("and at the same time", "other PP", false, false);
        addEntry("at the same time as", "other PP", false, false);
        addEntry("in the same way as", "other PP", false, false);
        addEntry("in such a way that", "other PP", false, false);
        addEntry("in such a way as", "other PP", false, true);
        addEntry("of the way in which", "other PP", false, false);
        addEntry("on the one hand and", "other PP", false, false);
        addEntry("in such a way as to", "other PP", false, false);

        addEntry("it is possible to", "anticipatory it + adjective phrase", false, false);
        addEntry("it is possible that", "anticipatory it + adjective phrase", false, true);
        addEntry("it is not possible", "anticipatory it + adjective phrase", false, true);
        addEntry("it is impossible to", "anticipatory it + adjective phrase", false, false);
        addEntry("it is likely that", "anticipatory it + adjective phrase", false, false);
        addEntry("it is unlikely that", "anticipatory it + adjective phrase", false, false);
        addEntry("it is important to", "anticipatory it + adjective phrase", true, false);
        addEntry("it is important that", "anticipatory it + adjective phrase", false, true);
        addEntry("it is necessary to", "anticipatory it + adjective phrase", false, false);
        addEntry("it is interesting to", "anticipatory it + adjective phrase", false, true);
        addEntry("it is clear that", "anticipatory it + adjective phrase", false, true);
        addEntry("it is not clear", "anticipatory it + adjective phrase", false, false);
        addEntry("it is difficult to", "anticipatory it + adjective phrase", false, false);
        addEntry("it is easy to", "anticipatory it + adjective phrase", false, false);
        addEntry("it is not surprising", "anticipatory it + adjective phrase", false, true);
        addEntry("it is true that", "anticipatory it + adjective phrase", false, false);
        addEntry("it can be seen", "anticipatory it + verb phrase", false, true);
        addEntry("it should be noted", "anticipatory it + verb phrase", false, true);
        addEntry("it has been shown", "anticipatory it + verb phrase", false, true);
        addEntry("it has been suggested", "anticipatory it + verb phrase", false, true);
        addEntry("it has also been", "anticipatory it + verb phrase", false, false);
        addEntry("it is to be", "anticipatory it + verb phrase", false, false);
        addEntry("it may be that", "anticipatory it + verb phrase", false, false);
        addEntry("it was found that", "anticipatory it + verb phrase", false, false);
        addEntry("it is not possible to", "anticipatory it + adjective phrase", false, false);
        addEntry("it may be possible to", "anticipatory it + adjective phrase", false, false);
        addEntry("it should be possible to", "anticipatory it + adjective phrase", false, false);
        addEntry("it is also possible to", "anticipatory it + adjective phrase", false, false);
        addEntry("it is possible that the", "anticipatory it + adjective phrase", false, false);
        addEntry("it may be necessary to", "anticipatory it + adjective phrase", false, false);
        addEntry("it is not necessary to", "anticipatory it + adjective phrase", false, false);
        addEntry("it is interesting to note", "anticipatory it + adjective phrase", false, true);
        addEntry("it is clear that the", "anticipatory it + adjective phrase", false, false);
        addEntry("it is important that the", "anticipatory it + adjective phrase", false, false);
        addEntry("it is not surprising that", "anticipatory it + adjective phrase", false, false);
        addEntry("it should be noted that", "anticipatory it + verb phrase", false, true);
        addEntry("it may be noted that", "anticipatory it + verb phrase", false, false);
        addEntry("it has been sugested that", "anticipatory it + verb phrase", false, false);
        addEntry("it has been shown that", "anticipatory it + verb phrase", false, false);
        addEntry("it can be shown that", "anticipatory it + verb phrase", false, false);
        addEntry("it can be seen that", "anticipatory it + verb phrase", false, false);
        addEntry("it has been argued that", "anticipatory it + verb phrase", false, false);
        addEntry("it has been found that", "anticipatory it + verb phrase", false, false);
        addEntry("it is interesting to note that", "anticipatory it", false, false);
        addEntry("it should be noted that the", "anticipatory it", false, false);

        addEntry("is shown in figure", "passive verb + PP", false, false);
        addEntry("is shown in fig.", "passive verb + PP", false, false);
        addEntry("are shown in table", "passive verb + PP", false, false);
        addEntry("is based on the", "passive verb + PP", false, false);
        addEntry("be found in the", "passive verb + PP", true, false);
        addEntry("can be found in", "passive verb + PP", false, false);
        addEntry("is referred to as", "passive verb + PP", false, false);
        addEntry("referred to as the", "passive verb + PP", false, false);
        addEntry("be related to the", "passive verb + PP", false, false);
        addEntry("is related to the", "passive verb + PP", false, false);
        addEntry("be taken into account", "passive verb + PP", true, false);
        addEntry("be thought of as", "passive verb + PP", false, false);
        addEntry("be used as a", "passive verb + PP", false, false);
        addEntry("can be seen as", "passive verb + PP", false, false);
        addEntry("is given by the", "passive verb + PP", false, false);
        addEntry("is known as the", "passive verb + PP", false, false);
        addEntry("was approved by the", "passive verb + PP", false, false);
        addEntry("is to be found in", "passive verb + PP", false, false);

        addEntry("is one of the", "copula be +noun phrase", true, true);
        addEntry("are a number of", "copula be +noun phrase", true, false);
        addEntry("is part of the", "copula be +noun phrase", false, false);
        addEntry("be the result of", "copula be +noun phrase", false, false);
        addEntry("is a matter of", "copula be +noun phrase", false, false);
        addEntry("is the same as", "copula be +noun phrase", false, false);
        addEntry("was no significant difference", "copula be +noun phrase", true, false);
        addEntry("is due to the", "copula be +adjective phrase", false, false);
        addEntry("may be due to", "copula be +adjective phrase", false, false);
        addEntry("is equal to the", "copula be +adjective phrase", false, false);
        addEntry("is similar to that", "copula be +adjective phrase", false, true);
        addEntry("is one of the most", "copula be +noun/adjective phrase", false, false);
        addEntry("was no significant difference between", "copula be +noun/adjective phrase", true, false);
        addEntry("is similar to that of", "copula be +noun/adjective phrase", false, false);
        addEntry("may or may not be", "copula be +noun/adjective phrase", false, false);

        addEntry("should be noted that", "verb phrase + that clause", true, true);
        addEntry("be noted that the", "verb phrase + that clause", true, false);
        addEntry("has been shown that", "verb phrase + that clause", true, false);
        addEntry("has been suggested that", "verb phrase + that clause", true, false);
        addEntry("can be seen that", "verb phrase + that clause", true, false);
        addEntry("does not mean that", "verb phrase + that clause", true, false);
        addEntry("is that it is", "verb phrase + that clause", false, false);
        addEntry("that there is a", "that clause", false, false);
        addEntry("that there is no", "that clause", false, false);
        addEntry("that it is a", "that clause", false, false);
        addEntry("that it is not", "that clause", false, false);
        addEntry("that it is the", "that clause", false, false);
        addEntry("studies have shown that", "noun + verb phrase + that clause", false, false);
        addEntry("should be noted that the", "verb phrase + that clause", true, true);

        addEntry("are likely to be", "predicative adjective + to-clause", false, false);
        addEntry("is likely to be", "predicative adjective + to-clause", false, false);
        addEntry("more likely to be", "predicative adjective + to-clause", false, false);
        addEntry("are more likely to", "predicative adjective + to-clause", false, false);
        addEntry("may be able to", "predicative adjective + to-clause", false, false);
        addEntry("should be able to", "predicative adjective + to-clause", false, false);
        addEntry("will be able to", "predicative adjective + to-clause", false, false);
        addEntry("is not possible to", "predicative adjective + to-clause", true, false);
        addEntry("has been shown to", "verb phrase + to-clause", false, true);
        addEntry("been shown to be", "verb phrase + to-clause", true, false);
        addEntry("hove been shown to", "verb phrase + to-clause", false, false);
        addEntry("can be used to", "verb phrase + to-clause", false, false);
        addEntry("may be used to", "verb phrase + to-clause", false, false);
        addEntry("is said to be", "verb phrase + to-clause", false, false);
        addEntry("does not seem to", "verb phrase + to-clause", false, true);
        addEntry("was found to be", "verb phrase + to-clause", false, false);
        addEntry("would have to be", "verb phrase + to-clause", false, false);
        addEntry("to be able to", "to-clause", false, false);
        addEntry("to ensure that the", "to-clause", false, false);
        addEntry("to be found in", "to-clause", true, true);
        addEntry("to be the most", "to-clause", false, false);
        addEntry("to deal with the", "to-clause", false, false);
        addEntry("to do with the", "to-clause", false, false);
        addEntry("to say that the", "to-clause", false, false);
        addEntry("is not to say that", "to-clause", true, false);
        addEntry("is interesting to note that", "to-clause", true, false);
        addEntry("can also be used to", "to-clause", false, false);
        addEntry("has been shown to be", "to-clause", false, false);
        addEntry("does not seem to be", "to-clause", false, false);
        addEntry("to be found in the", "to-clause", false, false);
        addEntry("to be taken into account", "to-clause", false, false);

        addEntry("as shown in figure", "adverbial clause", false, false);
        addEntry("as shown in fig.", "adverbial clause", false, false);
        addEntry("as we have seen", "adverbial clause", false, false);
        addEntry("as we shall see", "adverbial clause", false, false);
        addEntry("if there is a", "adverbial clause", false, false);

        addEntry("this is not the", "this + be", false, false);
        addEntry("this is not to", "this + be", false, true);
        addEntry("there was no significant", "there + be", false, true);
        addEntry("there are a number", "there + be", false, true);
        addEntry("there has been a", "there + be", false, false);
        addEntry("this does not mean that", "pronoun/noun phrase + be", false, false);
        addEntry("this is not to say", "pronoun/noun phrase + be", false, true);
        addEntry("there was no signficant difference", "pronoun/noun phrase + be", false, true);
        addEntry("there were no significant differences", "pronoun/noun phrase + be", false, false);
        addEntry("there was no correlation between", "pronoun/noun phrase + be", false, false);
        addEntry("there are a number of", "pronoun/noun phrase + be", false, false);
        addEntry("there is no doubt that", "pronoun/noun phrase + be", false, false);
        addEntry("aim of this study was", "pronoun/noun phrase + be", true, false);
        addEntry("it is one of the", "pronoun/noun phrase + be", false, false);
        addEntry("this is not to say that", "pronoun/noun phrase + be", false, false);
        addEntry("there was no significant difference between", "pronoun/noun phrase + be", false, false);
        addEntry("the aim of this study was", "pronoun/noun phrase + be", false, false);

        addEntry("as well as the", "other expressions", false, false);
        addEntry("as well as in", "other expressions", false, false);
        addEntry("than that of the", "other expressions", false, false);
        addEntry("may or may not", "other expressions", false, true);
        addEntry("the presence or absence", "other expressions", false, false);
    }
    private void addEntry(String bundle, String cls, boolean pre, boolean post) {
        bundles.put(bundle, cls);
        String tmp[] = bundle.split(" ");
        int arity = tmp.length;
        if(pre) {
            if(arity == 4) {
                pre4gram.add(bundle);
            } else if (arity == 5) {
                pre5gram.add(bundle);
            } else {
                System.err.println("Error in bundle: " + bundle);
            }
        }
        if(post) {
            if(arity == 4) {
                post4gram.add(bundle);
            } else if (arity == 5) {
                post5gram.add(bundle);
            } else {
                System.err.println("Error in bundle: " + bundle);
            }
        }
    }
    public String getFields() {
        return "Classification";
    }

    private String getPrePostString(String bundle, boolean pre, boolean post) {
        StringBuilder out = new StringBuilder("");
        if(pre || post) {
            out.append(" (");
        }
        if(post) {
            out.append('+');
        }
        if(pre || post) {
            out.append(bundle);
        }
        if(pre) {
            out.append('+');
        }
        if(pre || post) {
            out.append(')');
        }
        return out.toString();
    }
    private String doPrePost(String s, int n) {
        String pre = Utils.getPreGram(s, n);
        String post = Utils.getPostGram(s, n);
        boolean ckpre = pre4gram.contains(pre);
        boolean ckpost = post4gram.contains(post);
        String prepost = "";
        if(pre.equals(post)) {
            prepost = bundles.get(pre);
            prepost += getPrePostString(pre, ckpre, ckpost);
        } else if(ckpre && ckpost) {
            prepost = bundles.get(pre);
            prepost += getPrePostString(pre, true, false) + ", " + getPrePostString(post, false, true);
        } else if(ckpre) {
            prepost = bundles.get(pre);
            prepost += getPrePostString(pre, true, false);
        } else if(ckpost) {
            prepost = bundles.get(post);
            prepost += getPrePostString(post, false, true);
        } else {
            prepost += "";
        }
        return prepost;
    }

    public String classify(NGram n) {
        String out = bundles.get(n.getText());
        String ret = "";
        if(out != null) {
            return out + " (" + sections.get(out) + ")";
        } else {
            String tmp[] = n.getText().split(" ");
            if(tmp.length > 5) {
                ret = doPrePost(n.getText(), 5);
            } else if("".equals(ret) && tmp.length > 4) {
                ret = doPrePost(n.getText(), 4);
            } else {
                ret = "";
            }
        }
        return ret;
    }
}
