package ie.tcd.slscs.bundles;

import ie.tcd.slscs.ngramtool.NGram;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Durrant2015Utils {

    /**
     * Modified version of the text normalisation
     * mentioned in Durrant 2015, p. 6, replacing
     * digits with 'N' to match the n-grams in the
     * article.
     *
     * @see #normaliseDurrant(String) for the
     * exact normalisation method mentioned.
     */
    static String normalise(String s) {
        return s.toLowerCase()
                .replaceAll("\\p{Punct}+", "")
                .replaceAll("\\p{Digit}+", "N")
                .replaceAll("\\p{Space}+", " ");
    }

    static String normaliseDurrant(String s) {
        return s.toLowerCase()
                .replaceAll("\\p{Punct}+", "")
                .replaceAll("\\p{Digit}+", "")
                .replaceAll("\\p{Space}+", " ");
    }

    /**
     * Calculates n-gram overlap from Durrant 2015, p. 6
     * @param a First "corpus" of n-grams
     * @param b Second "corpus" of n-grams
     * @return Overlap
     */
    static double ngramOverlap (List<NGram> a, List<NGram> b) {
        Map<String, Integer> la = new HashMap<String, Integer>();
        Map<String, Integer> lb = new HashMap<String, Integer>();
        int n1 = 0;
        int n2 = 0;
        int l1 = a.size();
        int l2 = b.size();

        for (NGram n : a) {
            la.put(n.getText(), n.getCount());
        }
        for (NGram n : b) {
            lb.put(n.getText(), n.getCount());
        }

        for (NGram n : a) {
            if (lb.get(n.getText()) != null) {
                n1++;
            }
        }
        for (NGram n : b) {
            if (la.get(n.getText()) != null) {
                n2++;
            }
        }

        return ((n1 + n2 * 1.0) / (l1 + l2 * 1.0));
    }
}
