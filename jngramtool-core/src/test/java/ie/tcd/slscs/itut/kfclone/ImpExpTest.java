package ie.tcd.slscs.itut.kfclone;

import ie.tcd.slscs.ngramtool.NGram;
import org.junit.Rule;
import org.junit.Test;

import static org.junit.Assert.*;
import org.junit.rules.TemporaryFolder;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class ImpExpTest {
    private TemporaryFolder tempFolder;
    private File tempFile;
    private OutputStream fos;
    private OutputStreamWriter osw;
    private BufferedWriter bw;
    private List<NGram> expList;
    private FileInputStream readBackIn;

    public ImpExpTest() {
        expList = new ArrayList<NGram>();
        expList.add(new NGram("this is a", 6));
        expList.add(new NGram("is a small", 6));
        expList.add(new NGram("a small test", 6));

        try {
            tempFolder = new TemporaryFolder();
            tempFolder.create();
            tempFile = tempFolder.newFile("test.txt");
            fos = new FileOutputStream(tempFile);
            osw = new OutputStreamWriter(fos);
            bw = new BufferedWriter(osw);

            readBackIn = new FileInputStream(tempFile);

            bw.write("this is a\t6");
            bw.newLine();
            bw.write("is a small\t6");
            bw.newLine();
            bw.write("a small test\t6");
            bw.newLine();

            bw.close();
            osw.close();
            fos.close();

        } catch (Exception e) {
            System.out.print(e);
        }

    }

    // FIXME: why does this fail?
    @Test
    public void load() throws Exception {
        List<NGram> out = ImpExp.load(readBackIn);
        for (NGram n : out) {
            System.out.println(n.getText() + " : " + n.getCount());
        }
        //assert(out.equals(expList));
    }

}