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

import ie.tcd.slscs.itut.ngramtool.NGram;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Kozicka2016Second implements Classifier {
    private Map<String, SalazarClass> bundles;
    public Kozicka2016Second() {
        bundles = new HashMap<String, SalazarClass>();
        init_bundles();
    }
    private void init_bundles() {
        //native
        bundles.put("are a number of", new SalazarClass("are a number of", "", "copula be", "", "", "")); // 10, 8, 4
        bundles.put("it may be that", new SalazarClass("it may be that", "", "anticipatory it", "", "", "")); // 11, 8, 5
        bundles.put("in the context of", new SalazarClass("in the context of", "", "PP+of", "framing", "", "")); // 62, 28, 9
        bundles.put("at the expense of", new SalazarClass("at the expense of", "", "PP+of", "", "", "")); // 12, 12, 6
        bundles.put("the united states and", new SalazarClass("the united states and", "", "other NP", "", "", "")); // 13, 5, 4
        bundles.put("on the other hand", new SalazarClass("on the other hand", "", "other PP", "comparative", "additive", "")); // 38, 25, 8
        bundles.put("the ways in which", new SalazarClass("the ways in which", "", "other NP", "", "", "")); // 29, 18, 8
        bundles.put("in so far as", new SalazarClass("in so far as", "", "!!adverbial clause", "", "", "")); // 24, 8, 4
        bundles.put("at the time of", new SalazarClass("at the time of", "", "PP+of", "", "", "")); // 25, 8, 6
        bundles.put("in contrast to the", new SalazarClass("in contrast to the", "", "other PP", "", "", "")); // 15, 12, 8
        bundles.put("the end of the", new SalazarClass("the end of the", "", "NP+of", "", "", "")); // 22, 17, 6
        bundles.put("the relationship between the", new SalazarClass("the relationship between the", "", "other NP", "", "", "")); // 10, 8, 6
        bundles.put("as a result of", new SalazarClass("as a result of", "", "PP+of", "causative", "", "")); // 48, 24, 9
        bundles.put("the vast majority of", new SalazarClass("the vast majority of", "", "NP+of", "", "", "")); // 12, 8, 5
        bundles.put("as well as a", new SalazarClass("as well as a", "", "other expression", "", "", "")); // 15, 11, 7
        bundles.put("it is possible to", new SalazarClass("it is possible to", "", "anticipatory it", "", "", "")); // 21, 15, 8
        bundles.put("in the early years", new SalazarClass("in the early years", "", "other PP", "", "", "")); // 13, 8, 5
        bundles.put("it is difficult to", new SalazarClass("it is difficult to", "", "anticipatory it", "engagement (p-o)", "", "")); // 16, 13, 6
        bundles.put("that there is a", new SalazarClass("that there is a", "", "(Verb phrase +) type 8", "", "", "")); // 18, 13, 9
        bundles.put("as part of a", new SalazarClass("as part of a", "", "PP+of", "", "", "")); // 15, 13, 7
        bundles.put("are more likely to", new SalazarClass("are more likely to", "", "(V/A)+to type 9", "", "", "")); // 26, 14, 7
        bundles.put("with respect to the", new SalazarClass("with respect to the", "", "other PP", "", "", "")); // 14, 11, 5
        bundles.put("the boundaries of the", new SalazarClass("the boundaries of the", "", "NP+of", "", "", "")); // 12, 5, 4
        bundles.put("more likely to be", new SalazarClass("more likely to be", "", "(V/A)+to type 9", "", "", "")); // 19, 15, 7
        bundles.put("at the same time", new SalazarClass("at the same time", "", "other PP", "framing", "additive", "")); // 64, 32, 9
        bundles.put("the development of a", new SalazarClass("the development of a", "", "NP+of", "", "", "")); // 20, 13, 7
        bundles.put("of the impact of", new SalazarClass("of the impact of", "", "PP+of", "", "", "")); // 10, 8, 5
        bundles.put("the quality of the", new SalazarClass("the quality of the", "", "NP+of", "", "", "")); // 10, 7, 6
        bundles.put("per cent of the", new SalazarClass("per cent of the", "", "NP+of", "", "", "")); // 13, 7, 4
        bundles.put("there are a number", new SalazarClass("there are a number", "", "pronoun/noun phrase + be type 11", "", "", "")); // 10, 8, 4
        bundles.put("the course of the", new SalazarClass("the course of the", "", "NP+of", "", "", "")); // 12, 8, 4
        bundles.put("on the one hand", new SalazarClass("on the one hand", "", "other PP", "", "", "")); // 33, 21, 8
        bundles.put("in the united states", new SalazarClass("in the united states", "", "other PP", "location (r-o)", "", "")); // 51, 10, 6
        bundles.put("at the end of", new SalazarClass("at the end of", "", "PP+of", "location", "", "")); // 13, 9, 5
        bundles.put("an understanding of the", new SalazarClass("an understanding of the", "", "NP+of", "", "", "")); // 17, 16, 9
        bundles.put("in the wake of", new SalazarClass("in the wake of", "", "PP+of", "", "", "")); // 15, 8, 5
        bundles.put("in the case of", new SalazarClass("in the case of", "", "PP+of", "framing", "", "")); // 54, 28, 9
        bundles.put("it is clear that", new SalazarClass("it is clear that", "", "anticipatory it", "stance", "", "it is clear")); // 14, 7, 5
        bundles.put("in a number of", new SalazarClass("in a number of", "", "PP+of", "quantification", "", "")); // 12, 10, 8
        bundles.put("when it comes to", new SalazarClass("when it comes to", "", "!!other expression", "", "", "")); // 11, 9, 6
        bundles.put("on the part of", new SalazarClass("on the part of", "", "PP+of", "", "", "")); // 12, 9, 6
        bundles.put("to be able to", new SalazarClass("to be able to", "", "(V/A)+to type 9", "", "", "")); // 17, 14, 6
        bundles.put("on the basis of", new SalazarClass("on the basis of", "", "PP+of", "framing", "", "")); // 36, 20, 9
        bundles.put("for the purposes of", new SalazarClass("for the purposes of", "", "PP+of", "", "", "")); // 10, 8, 6
        bundles.put("as well as the", new SalazarClass("as well as the", "", "other expression", "", "", "")); // 45, 31, 9
        bundles.put("the case of the", new SalazarClass("the case of the", "", "other NP", "", "", "")); // 15, 12, 7
        bundles.put("in the process of", new SalazarClass("in the process of", "", "PP+of", "", "", "")); // 14, 10, 6
        bundles.put("in the form of", new SalazarClass("in the form of", "", "PP+of", "", "", "")); // 34, 21, 9
        bundles.put("the second world war", new SalazarClass("the second world war", "", "other NP", "", "", "")); // 16, 7, 5
        bundles.put("one of the most", new SalazarClass("one of the most", "", "NP+of", "", "", "")); // 20, 18, 9
        bundles.put("the way in which", new SalazarClass("the way in which", "", "other NP", "", "", "")); // 28, 12, 6
        bundles.put("from the perspective of", new SalazarClass("from the perspective of", "", "PP+of", "", "", "")); // 14, 10, 7
        bundles.put("in the face of", new SalazarClass("in the face of", "", "PP+of", "", "", "")); // 36, 21, 8
        bundles.put("the size of the", new SalazarClass("the size of the", "", "NP+of", "", "", "")); // 14, 8, 6
        bundles.put("as part of the", new SalazarClass("as part of the", "", "PP+of", "", "", "")); // 16, 12, 8
        bundles.put("were more likely to", new SalazarClass("were more likely to", "", "V/A+to type 9", "", "", "")); // 15, 6, 4
        bundles.put("are likely to be", new SalazarClass("are likely to be", "", "(V/A)+to type 9", "stance", "inferential", "")); // 11, 8, 5
        bundles.put("be more likely to", new SalazarClass("be more likely to", "", "!!(V/A)+to type 9", "", "", "")); // 12, 5, 3
        bundles.put("the results of the", new SalazarClass("the results of the", "", "NP+of", "", "", "")); // 10, 8, 5
        bundles.put("research has shown that", new SalazarClass("research has shown that", "", "(verb phrase)+that type 8", "", "", "")); // 10, 6, 3
        bundles.put("the significance of the", new SalazarClass("the significance of the", "", "NP+of", "", "", "")); // 10, 9, 6
        bundles.put("at the level of", new SalazarClass("at the level of", "", "PP+of", "description", "", "")); // 16, 12, 6
        bundles.put("the nature of the", new SalazarClass("the nature of the", "", "NP+of", "", "", "")); // 44, 26, 8
        bundles.put("in addition to the", new SalazarClass("in addition to the", "", "other PP", "", "", "")); // 10, 9, 6
        bundles.put("a great deal of", new SalazarClass("a great deal of", "", "NP+of", "", "", "")); // 11, 8, 5
        bundles.put("it is important to", new SalazarClass("it is important to", "", "anticipatory it", "engagement", "stance", "")); // 28, 21, 7
        bundles.put("as well as to", new SalazarClass("as well as to", "", "!!other expression", "", "", "")); // 12, 10, 6
        bundles.put("in relation to the", new SalazarClass("in relation to the", "", "other PP", "", "", "")); // 15, 13, 9
        bundles.put("to the development of", new SalazarClass("to the development of", "", "PP+of", "", "", "")); // 13, 8, 6
        bundles.put("in the name of", new SalazarClass("in the name of", "", "PP+of", "", "", "")); // 13, 8, 3
        bundles.put("the role of the", new SalazarClass("the role of the", "", "NP+of", "", "", "")); // 16, 10, 5
        bundles.put("appears to be a", new SalazarClass("appears to be a", "", "(V/A)+to type 9", "", "", "")); // 11, 9, 6
        bundles.put("for the first time", new SalazarClass("for the first time", "", "other PP", "", "", "")); // 15, 12, 6
        bundles.put("the extent to which", new SalazarClass("the extent to which", "", "other NP", "", "", "")); // 47, 23, 8
        bundles.put("as a means of", new SalazarClass("as a means of", "", "PP+of", "", "", "")); // 11, 10, 7
        bundles.put("the future of the", new SalazarClass("the future of the", "", "NP+of", "", "", "")); // 10, 5, 5
        bundles.put("there has been a", new SalazarClass("there has been a", "", "pronoun/noun phrase + be type 11", "", "", "")); // 12, 9, 6
        bundles.put("in the absence of", new SalazarClass("in the absence of", "", "PP+of", "framing", "", "")); // 12, 8, 6
        bundles.put("of the twentieth century", new SalazarClass("of the twentieth century", "", "other PP", "", "", "")); // 11, 8, 6
        bundles.put("at the heart of", new SalazarClass("at the heart of", "", "PP+of", "", "", "")); // 11, 8, 7
        bundles.put("as well as their", new SalazarClass("as well as their", "", "!!other expression", "", "", "")); // 14, 10, 7
        bundles.put("in a way that", new SalazarClass("in a way that", "", "other PP", "", "", "")); // 15, 11, 6
        bundles.put("in the same way", new SalazarClass("in the same way", "", "other PP", "comparative", "", "in the same")); // 11, 7, 5
        bundles.put("in the field of", new SalazarClass("in the field of", "", "PP+of", "", "", "")); // 11, 10, 4
        bundles.put("a wide range of", new SalazarClass("a wide range of", "", "NP+of", "grouping", "", "")); // 22, 12, 6
        bundles.put("about the nature of", new SalazarClass("about the nature of", "", "PP+of", "", "", "")); // 13, 11, 7
        bundles.put("to the extent that", new SalazarClass("to the extent that", "", "other PP", "", "", "")); // 13, 8, 5
        bundles.put("in terms of the", new SalazarClass("in terms of the", "", "PP+of", "", "", "")); // 23, 19, 8
        bundles.put("a result of the", new SalazarClass("a result of the", "", "NP+of", "", "", "")); // 15, 11, 7
        bundles.put("the fact that the", new SalazarClass("the fact that the", "", "other NP", "", "", "")); // 22, 16, 8
        bundles.put("the question of how", new SalazarClass("the question of how", "", "!!NP+of", "", "", "")); // 10, 9, 5
        bundles.put("as a form of", new SalazarClass("as a form of", "", "adverbial clause", "", "", "")); // 17, 12, 6
        bundles.put("the wake of the", new SalazarClass("the wake of the", "", "NP+of", "", "", "")); // 10, 5, 3
        bundles.put("the importance of the", new SalazarClass("the importance of the", "", "NP+of", "", "", "")); // 13, 10, 6
        bundles.put("is likely to be", new SalazarClass("is likely to be", "", "V/A+to-clause type 9", "stance (p-o)", "inferential", "")); // 10, 8, 6
        bundles.put("at the university of", new SalazarClass("at the university of", "", "NP+of", "location (r-o)", "", "")); // 11, 9, 6
        bundles.put("the degree to which", new SalazarClass("the degree to which", "", "other NP", "description (r-o)", "", "")); // 20, 12, 5
        bundles.put("of the concept of", new SalazarClass("of the concept of", "", "PP+of", "", "", "")); // 10, 6, 5
        bundles.put("the power of the", new SalazarClass("the power of the", "", "NP+of", "", "", "")); // 10, 7, 5

        //non-native
        bundles.put("in central and eastern", new SalazarClass("in central and eastern", "", "other PP", "", "", "")); // 24
        bundles.put("of the european union", new SalazarClass("of the european union", "", "other PP", "", "", "")); // 37
        bundles.put("it is also important", new SalazarClass("it is also important", "", "anticipatory it", "", "", "")); // 11
        bundles.put("a high level of", new SalazarClass("a high level of", "", "NP+of", "", "", "")); // 19
        bundles.put("in the context of", new SalazarClass("in the context of", "", "PP+of", "", "", "")); // 43
        bundles.put("of the labour market", new SalazarClass("of the labour market", "", "other PP", "", "", "")); // 25
        bundles.put("it was assumed that", new SalazarClass("it was assumed that", "", "anticipatory it", "", "", "")); // 11
        bundles.put("the basis of the", new SalazarClass("the basis of the", "", "NP+of", "", "", "")); // 30
        bundles.put("on the other hand", new SalazarClass("on the other hand", "", "other PP", "", "", "")); // 146
        bundles.put("for the sake of", new SalazarClass("for the sake of", "", "PP+of", "", "", "")); // 10
        bundles.put("be seen as a", new SalazarClass("be seen as a", "", "passive verb + PP", "", "", "")); // 13
        bundles.put("at the beginning of", new SalazarClass("at the beginning of", "", "PP+of", "", "", "")); // 38
        bundles.put("the behaviour of the", new SalazarClass("the behaviour of the", "", "NP+of", "", "", "")); // 19
        bundles.put("at the time of", new SalazarClass("at the time of", "", "PP+of", "", "", "")); // 10
        bundles.put("the end of the", new SalazarClass("the end of the", "", "NP+of", "", "", "")); // 44
        bundles.put("the concept of the", new SalazarClass("the concept of the", "", "NP+of", "", "", "")); // 12
        bundles.put("and the european union", new SalazarClass("and the european union", "", "other NP", "", "", "")); // 12
        bundles.put("as a result of", new SalazarClass("as a result of", "", "PP+of", "", "", "")); // 63
        bundles.put("in the development of", new SalazarClass("in the development of", "", "PP+of", "", "", "")); // 11
        bundles.put("the beginning of the", new SalazarClass("the beginning of the", "", "NP+of", "", "", "")); // 36
        bundles.put("it is impossible to", new SalazarClass("it is impossible to", "", "anticipatory it", "", "", "")); // 11
        bundles.put("in the number of", new SalazarClass("in the number of", "", "PP+of", "", "", "")); // 15
        bundles.put("it should be stressed", new SalazarClass("it should be stressed", "", "anticipatory it", "", "", "")); // 10
        bundles.put("as well as a", new SalazarClass("as well as a", "", "other expression", "", "", "")); // 22
        bundles.put("the development of the", new SalazarClass("the development of the", "", "NP+of", "", "", "")); // 34
        bundles.put("of this article is", new SalazarClass("of this article is", "", "!!other PP", "", "", "")); // 11
        bundles.put("central and eastern europe", new SalazarClass("central and eastern europe", "", "other NP", "", "", "")); // 41
        bundles.put("in comparison with the", new SalazarClass("in comparison with the", "", "other PP", "", "", "")); // 12
        bundles.put("an important role in", new SalazarClass("an important role in", "", "other NP", "", "", "")); // 12
        bundles.put("and the use of", new SalazarClass("and the use of", "", "NP+of", "", "", "")); // 11
        bundles.put("it is possible to", new SalazarClass("it is possible to", "", "anticipatory it", "", "", "")); // 21
        bundles.put("in the light of", new SalazarClass("in the light of", "", "PP+of", "", "", "")); // 15
        bundles.put("and to what extent", new SalazarClass("and to what extent", "", "other PP", "", "", "")); // 34
        bundles.put("it is difficult to", new SalazarClass("it is difficult to", "", "anticipatory it", "", "", "")); // 12
        bundles.put("the rest of the", new SalazarClass("the rest of the", "", "NP+of", "", "", "")); // 10
        bundles.put("in view of the", new SalazarClass("in view of the", "", "PP+of", "", "", "")); // 11
        bundles.put("answer to the question", new SalazarClass("answer to the question", "", "other NP", "", "", "")); // 11
        bundles.put("to a large extent", new SalazarClass("to a large extent", "", "!!other PP", "", "", "")); // 20
        bundles.put("the idea of the", new SalazarClass("the idea of the", "", "NP+of", "", "", "")); // 10
        bundles.put("the members of the", new SalazarClass("the members of the", "", "NP+of", "", "", "")); // 24
        bundles.put("that there is a", new SalazarClass("that there is a", "", "verb phrase + that-clause type 8", "", "", "")); // 17
        bundles.put("the quality of life", new SalazarClass("the quality of life", "", "NP+of", "", "", "")); // 14
        bundles.put("the framework of the", new SalazarClass("the framework of the", "", "NP+of", "", "", "")); // 11
        bundles.put("in the sphere of", new SalazarClass("in the sphere of", "", "PP+of", "", "", "")); // 28
        bundles.put("a part of the", new SalazarClass("a part of the", "", "NP+of", "", "", "")); // 10
        bundles.put("of the most important", new SalazarClass("of the most important", "", "other PP", "", "", "")); // 23
        bundles.put("with regard to the", new SalazarClass("with regard to the", "", "other PP", "", "", "")); // 19
        bundles.put("the turn of the", new SalazarClass("the turn of the", "", "NP+of", "", "", "")); // 12
        bundles.put("at the same time", new SalazarClass("at the same time", "", "other PP", "", "", "")); // 94
        bundles.put("the development of a", new SalazarClass("the development of a", "", "NP+of", "", "", "")); // 11
        bundles.put("the form of a", new SalazarClass("the form of a", "", "NP+of", "", "", "")); // 11
        bundles.put("took place in the", new SalazarClass("took place in the", "", "!!other expression", "", "", "")); // 10
        bundles.put("the context of the", new SalazarClass("the context of the", "", "NP+of", "", "", "")); // 14
        bundles.put("the second half of", new SalazarClass("the second half of", "", "NP+of", "", "", "")); // 20
        bundles.put("second half of the", new SalazarClass("second half of the", "", "NP+of", "", "", "")); // 16
        bundles.put("of development of the", new SalazarClass("of development of the", "", "PP+of", "", "", "")); // 12
        bundles.put("of the present study", new SalazarClass("of the present study", "", "other PP", "", "", "")); // 11
        bundles.put("can be observed in", new SalazarClass("can be observed in", "", "passive verb + PP", "", "", "")); // 19
        bundles.put("per cent of the", new SalazarClass("per cent of the", "", "NP+of", "", "", "")); // 21
        bundles.put("the aim of this", new SalazarClass("the aim of this", "", "NP+of", "", "", "")); // 11
        bundles.put("of the 21st century", new SalazarClass("of the 21st century", "", "other PP", "", "", "")); // 18
        bundles.put("the aim of the", new SalazarClass("the aim of the", "", "NP+of", "", "", "")); // 12
        bundles.put("in accordance with the", new SalazarClass("in accordance with the", "", "other PP", "", "", "")); // 23
        bundles.put("in each of the", new SalazarClass("in each of the", "", "PP+of", "", "", "")); // 12
        bundles.put("presented in table 1", new SalazarClass("presented in table 1", "", "passive verb + PP", "", "", "")); // 10
        bundles.put("the course of the", new SalazarClass("the course of the", "", "NP+of", "", "", "")); // 12
        bundles.put("on the one hand", new SalazarClass("on the one hand", "", "other PP", "", "", "")); // 54
        bundles.put("on the development of", new SalazarClass("on the development of", "", "PP+of", "", "", "")); // 11
        bundles.put("in the united states", new SalazarClass("in the united states", "", "other PP", "", "", "")); // 11
        bundles.put("and the number of", new SalazarClass("and the number of", "", "NP+of", "", "", "")); // 11
        bundles.put("are presented in table", new SalazarClass("are presented in table", "", "passive verb + PP", "", "", "")); // 23
        bundles.put("at the end of", new SalazarClass("at the end of", "", "PP+of", "", "", "")); // 44
        bundles.put("the fact that they", new SalazarClass("the fact that they", "", "other NP", "", "", "")); // 11
        bundles.put("of the role of", new SalazarClass("of the role of", "", "PP+of", "", "", "")); // 10
        bundles.put("in the case of", new SalazarClass("in the case of", "", "PP+of", "", "", "")); // 90
        bundles.put("in the course of", new SalazarClass("in the course of", "", "PP+of", "", "", "")); // 30
        bundles.put("of central and eastern", new SalazarClass("of central and eastern", "", "other PP", "", "", "")); // 13
        bundles.put("to the fact that", new SalazarClass("to the fact that", "", "other PP", "", "", "")); // 28
        bundles.put("when it comes to", new SalazarClass("when it comes to", "", "!!other expression", "", "", "")); // 13
        bundles.put("on the part of", new SalazarClass("on the part of", "", "PP+of", "", "", "")); // 22
        bundles.put("the introduction of the", new SalazarClass("the introduction of the", "", "NP+of", "", "", "")); // 10
        bundles.put("as compared to the", new SalazarClass("as compared to the", "", "!!adverbial clause", "", "", "")); // 11
        bundles.put("in the area of", new SalazarClass("in the area of", "", "PP+of", "", "", "")); // 22
        bundles.put("to the emergence of", new SalazarClass("to the emergence of", "", "PP+of", "", "", "")); // 10
        bundles.put("to be able to", new SalazarClass("to be able to", "", "V/A + to-clause", "", "", "")); // 13
        bundles.put("in the opinion of", new SalazarClass("in the opinion of", "", "PP+of", "", "", "")); // 12
        bundles.put("it can be assumed", new SalazarClass("it can be assumed", "", "anticipatory it", "", "", "")); // 10
        bundles.put("on the basis of", new SalazarClass("on the basis of", "", "PP+of", "", "", "")); // 89
        bundles.put("to the problem of", new SalazarClass("to the problem of", "", "PP+of", "", "", "")); // 10
        bundles.put("it should be emphasized", new SalazarClass("it should be emphasized", "", "anticipatory it", "", "", "")); // 10
        bundles.put("as well as the", new SalazarClass("as well as the", "", "other expression", "", "", "")); // 60
        bundles.put("as the most important", new SalazarClass("as the most important", "", "other PP/ adverbial clause", "", "", "")); // 11
        bundles.put("the case of the", new SalazarClass("the case of the", "", "NP+of", "", "", "")); // 13
        bundles.put("in the level of", new SalazarClass("in the level of", "", "PP+of", "", "", "")); // 11
        bundles.put("in the process of", new SalazarClass("in the process of", "", "PP+of", "", "", "")); // 35
        bundles.put("in poland in the", new SalazarClass("in poland in the", "", "PP+of", "", "", "")); // 10
        bundles.put("in the form of", new SalazarClass("in the form of", "", "PP+of", "", "", "")); // 59
        bundles.put("the second world war", new SalazarClass("the second world war", "", "other NP", "", "", "")); // 12
        bundles.put("one of the most", new SalazarClass("one of the most", "", "NP+of", "", "", "")); // 33
        bundles.put("the way in which", new SalazarClass("the way in which", "", "other NP", "", "", "")); // 12
        bundles.put("as well as for", new SalazarClass("as well as for", "", "!!other expression", "", "", "")); // 10
        bundles.put("from the perspective of", new SalazarClass("from the perspective of", "", "PP+of", "", "", "")); // 11
        bundles.put("and on the other", new SalazarClass("and on the other", "", "other PP", "", "", "")); // 18
        bundles.put("at the turn of", new SalazarClass("at the turn of", "", "PP+of", "", "", "")); // 11
        bundles.put("from the fact that", new SalazarClass("from the fact that", "", "other PP", "", "", "")); // 11
        bundles.put("in the group of", new SalazarClass("in the group of", "", "PP+of", "", "", "")); // 25
        bundles.put("it is assumed that", new SalazarClass("it is assumed that", "", "anticipatory it", "", "", "")); // 11
        bundles.put("in the face of", new SalazarClass("in the face of", "", "PP+of", "", "", "")); // 10
        bundles.put("the size of the", new SalazarClass("the size of the", "", "NP+of", "", "", "")); // 11
        bundles.put("turned out to be", new SalazarClass("turned out to be", "", "(V/A)+to-clause", "", "", "")); // 21
        bundles.put("and the ability to", new SalazarClass("and the ability to", "", "other NP", "", "", "")); // 11
        bundles.put("it is necessary to", new SalazarClass("it is necessary to", "", "anticipatory it", "", "", "")); // 20
        bundles.put("the former soviet union", new SalazarClass("the former soviet union", "", "other NP", "", "", "")); // 24
        bundles.put("seems to be a", new SalazarClass("seems to be a", "", "(V/A)+to-clause", "", "", "")); // 11
        bundles.put("is based on a", new SalazarClass("is based on a", "", "passive verb + PP", "", "", "")); // 12
        bundles.put("the level of the", new SalazarClass("the level of the", "", "NP+of", "", "", "")); // 15
        bundles.put("the results of the", new SalazarClass("the results of the", "", "NP+of", "", "", "")); // 31
        bundles.put("is one of the", new SalazarClass("is one of the", "", "copula be", "", "", "")); // 34
        bundles.put("the differences in the", new SalazarClass("the differences in the", "", "other NP", "", "", "")); // 11
        bundles.put("the structure of the", new SalazarClass("the structure of the", "", "NP+of", "", "", "")); // 19
        bundles.put("the part of the", new SalazarClass("the part of the", "", "NP+of", "", "", "")); // 14
        bundles.put("the total number of", new SalazarClass("the total number of", "", "NP+of", "", "", "")); // 12
        bundles.put("at the level of", new SalazarClass("at the level of", "", "PP+of", "", "", "")); // 20
        bundles.put("within the framework of", new SalazarClass("within the framework of", "", "PP+of", "", "", "")); // 17
        bundles.put("in the second half", new SalazarClass("in the second half", "", "other PP", "", "", "")); // 17
        bundles.put("the nature of the", new SalazarClass("the nature of the", "", "NP+of", "", "", "")); // 10
        bundles.put("is based on the", new SalazarClass("is based on the", "", "passive verb + PP", "", "", "")); // 20
        bundles.put("the point of view", new SalazarClass("the point of view", "", "NP+of", "", "", "")); // 33
        bundles.put("it is important to", new SalazarClass("it is important to", "", "anticipatory it", "", "", "")); // 14
        bundles.put("be explained by the", new SalazarClass("be explained by the", "", "!!passive verb + PP", "", "", "")); // 10
        bundles.put("as well as in", new SalazarClass("as well as in", "", "!!other expression", "", "", "")); // 18
        bundles.put("is the fact that", new SalazarClass("is the fact that", "", "!!copula be", "", "", "")); // 13
        bundles.put("in relation to the", new SalazarClass("in relation to the", "", "other PP", "", "", "")); // 25
        bundles.put("should be noted that", new SalazarClass("should be noted that", "", "VP + that type 8", "", "", "")); // 18
        bundles.put("to the development of", new SalazarClass("to the development of", "", "PP+of", "", "", "")); // 17
        bundles.put("the role of the", new SalazarClass("the role of the", "", "NP+of", "", "", "")); // 24
        bundles.put("ability to cope with", new SalazarClass("ability to cope with", "", "other NP", "", "", "")); // 10
        bundles.put("in a group of", new SalazarClass("in a group of", "", "PP+of", "", "", "")); // 10
        bundles.put("from the point of", new SalazarClass("from the point of", "", "PP+of", "", "", "")); // 33
        bundles.put("it should be noted", new SalazarClass("it should be noted", "", "anticipatory it", "", "", "")); // 27
        bundles.put("for the first time", new SalazarClass("for the first time", "", "other PP", "", "", "")); // 11
        bundles.put("the analysis of the", new SalazarClass("the analysis of the", "", "NP+of", "", "", "")); // 12
        bundles.put("a positive relation between", new SalazarClass("a positive relation between", "", "other NP", "", "", "")); // 11
        bundles.put("the extent to which", new SalazarClass("the extent to which", "", "other NP", "", "", "")); // 13
        bundles.put("the creation of a", new SalazarClass("the creation of a", "", "NP+of", "", "", "")); // 13
        bundles.put("of the development of", new SalazarClass("of the development of", "", "PP+of", "", "", "")); // 13
        bundles.put("by the fact that", new SalazarClass("by the fact that", "", "other PP", "", "", "")); // 14
        bundles.put("in the first place", new SalazarClass("in the first place", "", "other PP", "", "", "")); // 10
        bundles.put("the activities of the", new SalazarClass("the activities of the", "", "NP+of", "", "", "")); // 16
        bundles.put("of the number of", new SalazarClass("of the number of", "", "PP+of", "", "", "")); // 21
        bundles.put("the number of children", new SalazarClass("the number of children", "", "NP+of", "", "", "")); // 17
        bundles.put("of the child and", new SalazarClass("of the child and", "", "other PP", "", "", "")); // 13
        bundles.put("point of view of", new SalazarClass("point of view of", "", "NP+of", "", "", "")); // 34
        bundles.put("in the field of", new SalazarClass("in the field of", "", "PP+of", "", "", "")); // 27
        bundles.put("in terms of the", new SalazarClass("in terms of the", "", "PP+of", "", "", "")); // 33
        bundles.put("with the exception of", new SalazarClass("with the exception of", "", "PP+of", "", "", "")); // 18
        bundles.put("a result of the", new SalazarClass("a result of the", "", "NP+of", "", "", "")); // 15
        bundles.put("the fact that the", new SalazarClass("the fact that the", "", "other NP", "", "", "")); // 36
        bundles.put("in the european union", new SalazarClass("in the european union", "", "other PP", "", "", "")); // 13
        bundles.put("to take part in", new SalazarClass("to take part in", "", "(V/A)+ to-clause", "", "", "")); // 12
        bundles.put("the countries of the", new SalazarClass("the countries of the", "", "NP+of", "", "", "")); // 10
        bundles.put("the importance of the", new SalazarClass("the importance of the", "", "NP+of", "", "", "")); // 13
        bundles.put("of view of the", new SalazarClass("of view of the", "", "PP+of", "", "", "")); // 14
        bundles.put("on the level of", new SalazarClass("on the level of", "", "PP+of", "", "", "")); // 11
        bundles.put("can be found in", new SalazarClass("can be found in", "", "passive verb + PP", "", "", "")); // 13
        bundles.put("in such a way", new SalazarClass("in such a way", "", "other PP", "", "", "")); // 12
        bundles.put("of the concept of", new SalazarClass("of the concept of", "", "PP+of", "", "", "")); // 13
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
