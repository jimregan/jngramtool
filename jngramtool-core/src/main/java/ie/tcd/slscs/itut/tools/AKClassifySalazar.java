package ie.tcd.slscs.itut.tools;

import java.io.*;
import java.nio.charset.Charset;
import java.util.HashMap;
import java.util.Map;
import ie.tcd.slscs.itut.ngramtool.NGram;
import ie.tcd.slscs.itut.bundles.Classifier;
import ie.tcd.slscs.itut.bundles.SalazarClassify;
import ie.tcd.slscs.itut.bundles.Utils;

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
public class AKClassifySalazar {
    public static void main(String[] args) {
        try {
            String line;
            InputStream fis = new FileInputStream(args[0]);
            InputStreamReader isr = new InputStreamReader(fis, Charset.forName("UTF-8"));
            BufferedReader br = new BufferedReader(isr);

            OutputStream fos = new FileOutputStream(args[0] + ".cls.tsv");
            OutputStreamWriter osw = new OutputStreamWriter(fos, Charset.forName("UTF-8"));
            BufferedWriter bw = new BufferedWriter(osw);

            Classifier cls = new SalazarClassify();
            while ((line = br.readLine()) != null) {
                String[] tmp = line.split("\\t");
                NGram ng = new NGram(tmp[0], Integer.parseInt(tmp[1]));
                String clsfy = cls.classify(ng);
                bw.write(line);
                bw.write('\t');
                bw.write(clsfy);
                bw.newLine();
            }

            bw.close();
        } catch (Exception e) {
            System.err.println(e.getStackTrace());
        }

    }
}
