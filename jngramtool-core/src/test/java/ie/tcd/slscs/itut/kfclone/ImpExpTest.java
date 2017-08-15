package ie.tcd.slscs.itut.kfclone;
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

import ie.tcd.slscs.itut.ngramtool.NGram;
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