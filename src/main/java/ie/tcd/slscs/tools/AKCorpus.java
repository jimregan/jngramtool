package ie.tcd.slscs.tools;

import ie.tcd.slscs.bundles.Utils;
import ie.tcd.slscs.ngramtool.NGram;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.HashMap;

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
    private Map<String, AKEntry> bundles;
    boolean verbose = true;
    AKCorpus() {
        file = new ArrayList<AKCorpusFile>();
        bundles = new HashMap<String, AKEntry>();
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
                if(verbose) {
                    System.err.println("Adding file: " + tmp[0] + " (" + tmp[1] + ", " + tmp[2] + ")");
                }
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
    public void getBundles(String path) throws IOException {
        for(AKCorpusFile f : file) {
            f.read(path);
            List<String> normed = new ArrayList<String>();
            for(String s : f.getText()) {
                normed.add(Utils.stripSpace(s).toLowerCase());
            }
            f.clearText();
            List<String> subsent = Utils.getSafeSubSentences(normed, ";:()[]–—−‒\u2012\u2022\u202F\uF0B7\uF0A7\uF02D\u00A0\u2002\u2003‘“”‟\"!?\u0008", "-,.'’/");
            normed.clear();
            List<String> newbundles = Utils.getBundles(subsent, 4);
            subsent.clear();
            for(String s : newbundles) {
                if(bundles.get(s) == null) {
                    bundles.put(s, new AKEntry(s, 1, f.language, f.year, f.field, f.author));
                } else {
                    AKEntry tmpe = bundles.get(s);
                    tmpe.update(1, f.language, f.year, f.field, f.author);
                }
            }
            newbundles.clear();
        }
    }
    public void writeBundles() throws IOException {
        for(String s : bundles.keySet()) {
            AKEntry e = bundles.get(s);
            System.out.println(e.summariseAuthorFieldExt());
        }
    }
}
