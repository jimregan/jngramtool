import org.junit.Test;

import java.util.Map;
import java.util.TreeMap;

import static org.junit.Assert.*;

public class StringReductionTest {
    Map<String, Integer> m = new TreeMap<String, Integer>();

    Map<String, Integer> e1 = new TreeMap<String, Integer>();
    public StringReductionTest() {
        m.put("this is a test", 6);
        m.put("is a test", 6);
        m.put("this is a", 6);

        e1.put("this is a test", 6);
    }
    @Test
    public void reduce() throws Exception {
        Map<String, Integer> res = StringReduction.reduce(m, 5);
        assert(res.toString().equals(e1.toString()));
    }

}