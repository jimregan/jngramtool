package ie.tcd.slscs.ie.tcd.slscs.bundles;

import ie.tcd.slscs.ngramtool.NGram;

import java.util.HashMap;
import java.util.Map;

// There are much smarter things I could have done here.
// I didn't. This code is craaaaaaaap.
/**
 * This classifies ngrams into subcategories, based on the ngrams given in
 * Durrant 2015 (see below).
 *
 * <pre>
 * @article{Durrant19042015,
 * author = {Durrant, Philip},
 * title = {Lexical Bundles and Disciplinary Variation in University
 * Students’ Writing: Mapping the Territories},
 * year = {2015},
 * doi = {10.1093/applin/amv011},
 * URL = {http://applij.oxfordjournals.org/content/early/2015/04/17/applin.amv011.abstract},
 * eprint = {http://applij.oxfordjournals.org/content/early/2015/04/17/applin.amv011.full.pdf+html},
 * journal = {Applied Linguistics}
 * }
 * </pre>
 */
public class Durrant2015 implements Classifier {

    private Map<SubCategory, Category> subcatCatMap;
    private Map<String, SubCategory> ngramMap;

    public Durrant2015() {
        ngramMap = new HashMap<String, SubCategory>();
        subcatCatMap = new HashMap<SubCategory, Category>();
        initSubcatCatMap();
        setupNgramToSubcatMap();
    }

    public enum Category {
        research,
        stance,
        text
    }

    public enum SubCategory {
        location,
        procedure,
        quantification,
        description,
        int_framing_attr,

        transition,
        resultative,
        structuring,
        framing,
        s_centrality,
        s_epistemic,
        s_modality,

        centrality,
        epistemic,
        modality,
        t_framing,
        t_resultative,
        t_structuring,
        t_transition
    }

    public String classify(NGram n) {
        String out = "";
        return out;
    }

    public String getCategoryString (Category c) {
        if (c == Category.research) {
            return "Research";
        } else if (c == Category.stance) {
            return "Stance";
        } else if (c == Category.text) {
            return "Text";
        } else {
            return "Unknown category";
        }
    }

    public String getSubCategoryString (SubCategory c) {
        if (c == SubCategory.location) {
            return "Location";
        } else if (c == SubCategory.procedure) {
            return "Procedure";
        } else if (c == SubCategory.quantification) {
            return "Quantification";
        } else if (c == SubCategory.description) {
            return "Description";
        } else if (c == SubCategory.int_framing_attr) {
            return "Intangible framing attributes";
        } else if (c == SubCategory.transition || c == SubCategory.t_transition) {
            return "Transition";
        } else if (c == SubCategory.resultative || c == SubCategory.t_resultative) {
            return "Resultative";
        } else if (c == SubCategory.structuring || c == SubCategory.t_structuring) {
            return "Structuring";
        } else if (c == SubCategory.framing || c == SubCategory.t_framing) {
            return "Framing";
        } else if (c == SubCategory.centrality || c == SubCategory.s_centrality) {
            return "Centrality";
        } else if (c == SubCategory.epistemic || c == SubCategory.s_epistemic) {
            return "Epistemic";
        } else if (c == SubCategory.modality || c == SubCategory.s_modality) {
            return "Modality";
        } else {
            return "Unknown category";
        }
    }

    private void initSubcatCatMap() {
        subcatCatMap.put(SubCategory.location, Category.research);
        subcatCatMap.put(SubCategory.procedure, Category.research);
        subcatCatMap.put(SubCategory.quantification, Category.research);
        subcatCatMap.put(SubCategory.description, Category.research);
        subcatCatMap.put(SubCategory.int_framing_attr, Category.research);

        subcatCatMap.put(SubCategory.transition, Category.stance);
        subcatCatMap.put(SubCategory.resultative, Category.stance);
        subcatCatMap.put(SubCategory.structuring, Category.stance);
        subcatCatMap.put(SubCategory.framing, Category.stance);
        subcatCatMap.put(SubCategory.s_centrality, Category.stance);
        subcatCatMap.put(SubCategory.s_epistemic, Category.stance);
        subcatCatMap.put(SubCategory.s_modality, Category.stance);

        subcatCatMap.put(SubCategory.centrality, Category.text);
        subcatCatMap.put(SubCategory.epistemic, Category.text);
        subcatCatMap.put(SubCategory.modality, Category.text);
        subcatCatMap.put(SubCategory.t_resultative, Category.text);
        subcatCatMap.put(SubCategory.t_structuring, Category.text);
        subcatCatMap.put(SubCategory.t_transition, Category.text);
        subcatCatMap.put(SubCategory.t_framing, Category.text);
    }

    private void setupNgramToSubcatMap() {
        // Table 2, p. 17
        ngramMap.put("of the concept of", SubCategory.int_framing_attr);
        ngramMap.put("the existence of a", SubCategory.int_framing_attr);
        ngramMap.put("the existence of the", SubCategory.int_framing_attr);
        ngramMap.put("the fact that it", SubCategory.int_framing_attr);
        ngramMap.put("the form of the", SubCategory.int_framing_attr);
        ngramMap.put("the idea of a", SubCategory.int_framing_attr);
        ngramMap.put("the nature of the", SubCategory.int_framing_attr);
        ngramMap.put("the power of the", SubCategory.int_framing_attr);
        ngramMap.put("the role of the", SubCategory.int_framing_attr);
        ngramMap.put("the validity of the", SubCategory.int_framing_attr);
        ngramMap.put("the idea of the", SubCategory.int_framing_attr);

        ngramMap.put("at the time of", SubCategory.location);
        ngramMap.put("in the Ns and", SubCategory.location);
        ngramMap.put("in the process of", SubCategory.location);
        ngramMap.put("the Ns and Ns", SubCategory.location);

        ngramMap.put("as a means of", SubCategory.procedure);
        ngramMap.put("in a way that", SubCategory.procedure);
        ngramMap.put("in an attempt to", SubCategory.procedure);
        ngramMap.put("the use of the", SubCategory.procedure);
        ngramMap.put("the way in which", SubCategory.procedure);
        ngramMap.put("way in which the", SubCategory.procedure);

        ngramMap.put("the extent to which", SubCategory.quantification);

        ngramMap.put("at the heart of", SubCategory.s_centrality);
        ngramMap.put("in the first place", SubCategory.s_centrality);
        ngramMap.put("one of the main", SubCategory.s_centrality);
        ngramMap.put("the importance of the", SubCategory.s_centrality);

        ngramMap.put("appears to be a", SubCategory.s_epistemic);
        ngramMap.put("be argued that the", SubCategory.s_epistemic);
        ngramMap.put("be seen as a", SubCategory.s_epistemic);
        ngramMap.put("can be seen as", SubCategory.s_epistemic);
        // Table 2, p. 18
        ngramMap.put("could be argued that", SubCategory.s_epistemic);
        ngramMap.put("it can be argued", SubCategory.s_epistemic);
        ngramMap.put("it could be argued", SubCategory.s_epistemic);
        ngramMap.put("it is not a", SubCategory.s_epistemic);
        ngramMap.put("that it is not", SubCategory.s_epistemic);
        ngramMap.put("that it is the", SubCategory.s_epistemic);
        ngramMap.put("that there is no", SubCategory.s_epistemic);
        ngramMap.put("that there was a", SubCategory.s_epistemic);
        ngramMap.put("there seems to be", SubCategory.s_epistemic);

        ngramMap.put("it is impossible to", SubCategory.s_modality);

        ngramMap.put("as part of the", SubCategory.framing);
        ngramMap.put("for the purposes of", SubCategory.framing);
        ngramMap.put("in relation to the", SubCategory.framing);
        ngramMap.put("in the context of", SubCategory.framing);
        ngramMap.put("in the light of", SubCategory.framing);
        ngramMap.put("on the basis of", SubCategory.framing);
        ngramMap.put("on the part of", SubCategory.framing);
        ngramMap.put("the context of the", SubCategory.framing);
        ngramMap.put("the part of the", SubCategory.framing);
        ngramMap.put("to the extent that", SubCategory.framing);

        ngramMap.put("does not mean that", SubCategory.resultative);

        ngramMap.put("an example of the", SubCategory.transition);
        ngramMap.put("as opposed to the", SubCategory.transition);
        ngramMap.put("despite the fact that", SubCategory.transition);
        ngramMap.put("in contrast to the", SubCategory.transition);
        ngramMap.put("in favour of the", SubCategory.transition);
        ngramMap.put("on the one hand", SubCategory.transition);
        ngramMap.put("on the other hand", SubCategory.transition);
        // Table 3, p. 19
        ngramMap.put("the presence of a", SubCategory.description);
        ngramMap.put("the presence of the", SubCategory.description);
        ngramMap.put("the shape of the", SubCategory.description);

        ngramMap.put("at the bottom of", SubCategory.location);
        ngramMap.put("on the surface of", SubCategory.location);
        ngramMap.put("the bottom of the", SubCategory.location);
        ngramMap.put("the centre of the", SubCategory.location);
        ngramMap.put("the surface of the", SubCategory.location);
        ngramMap.put("the top of the", SubCategory.location);

        ngramMap.put("a measure of the", SubCategory.procedure);
        ngramMap.put("be used as a", SubCategory.procedure);
        ngramMap.put("be used in the", SubCategory.procedure);
        ngramMap.put("be used to determine", SubCategory.procedure);
        ngramMap.put("can also be used", SubCategory.procedure);
        ngramMap.put("can be used to", SubCategory.procedure);
        ngramMap.put("could be used to", SubCategory.procedure);
        ngramMap.put("it can be used", SubCategory.procedure);
        ngramMap.put("the use of a", SubCategory.procedure);
        ngramMap.put("to ensure that the", SubCategory.procedure);
        ngramMap.put("used to determine the", SubCategory.procedure);
        ngramMap.put("will be used to", SubCategory.procedure);

        ngramMap.put("a large number of", SubCategory.quantification);
        ngramMap.put("is the same as", SubCategory.quantification);
        ngramMap.put("than that of the", SubCategory.quantification);
        ngramMap.put("the difference between the", SubCategory.quantification);
        ngramMap.put("the efficiency of the", SubCategory.quantification);
        ngramMap.put("the length of the", SubCategory.quantification);
        ngramMap.put("the same as the", SubCategory.quantification);
        ngramMap.put("the size of the", SubCategory.quantification);
        ngramMap.put("the temperature of the", SubCategory.quantification);

        ngramMap.put("it is thought that", SubCategory.s_epistemic);
        ngramMap.put("it was found that", SubCategory.s_epistemic);
        ngramMap.put("was found to be", SubCategory.s_epistemic);

        ngramMap.put("with respect to the", SubCategory.t_framing);

        ngramMap.put("be due to the", SubCategory.t_resultative);
        ngramMap.put("is determined by the", SubCategory.t_resultative);
        ngramMap.put("is due to the", SubCategory.t_resultative);
        ngramMap.put("the reason for this", SubCategory.t_resultative);
        ngramMap.put("this is because the", SubCategory.t_resultative);
        ngramMap.put("this is due to", SubCategory.t_resultative);
        // p. 20
        ngramMap.put("this means that the", SubCategory.t_resultative);

        ngramMap.put("as can be seen", SubCategory.t_structuring);
        ngramMap.put("as shown in figure", SubCategory.t_structuring);
        ngramMap.put("be seen that the", SubCategory.t_structuring);
        ngramMap.put("can be seen from", SubCategory.t_structuring);
        ngramMap.put("can be seen that", SubCategory.t_structuring);
        ngramMap.put("is shown in figure", SubCategory.t_structuring);
        ngramMap.put("it can be seen", SubCategory.t_structuring);
        ngramMap.put("shown in figure the", SubCategory.t_structuring);

        ngramMap.put("is defined as the", SubCategory.t_transition);
    }

    public Category categoryFromSubcategory (SubCategory s) {
        return subcatCatMap.get(s);
    }
}
