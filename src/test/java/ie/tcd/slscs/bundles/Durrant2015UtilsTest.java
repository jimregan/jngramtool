package ie.tcd.slscs.bundles;

import ie.tcd.slscs.bundles.Durrant2015Utils;
import ie.tcd.slscs.ngramtool.NGram;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.*;

public class Durrant2015UtilsTest {
    @Test
    public void normalise() throws Exception {
        String inp = "There;s a 90s   thing";
        String exp = "theres a Ns thing";
        String out = Durrant2015Utils.normalise(inp);
        Assert.assertEquals(exp, out);
    }

    @Test
    public void normaliseDurrant() throws Exception {
        String inp = "There;s a 90s   thing";
        String exp = "theres a s thing";
        String out = Durrant2015Utils.normaliseDurrant(inp);
        Assert.assertEquals(exp, out);
    }

    @Test
    public void ngramOverlap() throws Exception {
        List<NGram> a = new ArrayList<NGram>();
        List<NGram> b = new ArrayList<NGram>();
        a.add(new NGram("some overlap", 1));
        a.add(new NGram("more overlap", 1));
        a.add(new NGram("only a", 1));
        a.add(new NGram("also only a", 1));
        b.add(new NGram("some overlap", 1));
        b.add(new NGram("more overlap", 1));
        b.add(new NGram("only b", 1));
        b.add(new NGram("also only b", 1));
        double out = Durrant2015Utils.ngramOverlap(a, b);
        assert(out == 0.5);
    }
}