package ie.tcd.slscs.tools;

import ie.tcd.slscs.bundles.Utils;
import ie.tcd.slscs.ngramtool.NGram;

import java.util.ArrayList;
import java.util.List;

import java.io.*;
import java.nio.charset.Charset;


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

public class AKCorpus {
    List<AKCorpusFile> file;
    String filename;
    AKCorpus() {
        file = new ArrayList<AKCorpusFile>();
    }
    AKCorpus(String s) {
        this();
        filename = s;
    }
    public void read() throws IOException {
        String line;
        InputStream fis = new FileInputStream(filename);
        InputStreamReader isr = new InputStreamReader(fis, Charset.forName("UTF-8"));
        BufferedReader br = new BufferedReader(isr);

        while ((line = br.readLine()) != null) {
            String[] tmp = line.split("\\t");
            if(tmp.length == 3) {
                file.add(new AKCorpusFile(tmp));
            } else {
                System.err.println("Error with line: " + line);
            }
        }
    }
    public void printDetails() {
        for (AKCorpusFile f : file) {
            System.out.println(f.toString());
        }
    }
}
