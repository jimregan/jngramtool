package ie.tcd.slscs.ie.tcd.slscs.bundles;

import ie.tcd.slscs.ngramtool.NGram;

public interface Classifier {
    public String classify(NGram n);
}
