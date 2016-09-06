package ie.tcd.slscs.tools;

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

import ie.tcd.slscs.bundles.Utils;
import ie.tcd.slscs.ngramtool.NGram;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Pattern;
import java.util.regex.Matcher;
import java.io.*;
import java.nio.charset.Charset;

/**
 * This tool reads a tab-delimited text file that describes a corpus from which
 * to extract lexical bundles.
 * 
 * <p>
 * The text file should contain 5 entries:
 * <ul>
 * <li>filename</li>
 * <li>author</li>
 * <li>year</li>
 * </ul>
 * 
 * <p>
 * The filename is expected to be contained in a directory structure 
 * organised by field, and by native language: e.g., 
 * <pre>linguistics/fr/author1.txt</pre>
 * 
 * <p>
 * The tool takes two options, the path to the directory that contains the 
 * corpus, and the file that describes the corpus.
 * 
 * @author jaoregan
 *
 */
public class BundleCorpusReader {
    public static void main(String[] args) {
        AKCorpus corp = new AKCorpus(args[1]);
        String path = args[0];
        try {
            corp.read();
            corp.getBundles(path);
            corp.writeBundles(args[1] + "-bundles.txt");
        } catch (IOException io) {
            System.err.println("IOException: " + io.getMessage());
        } catch (Exception e) {
            System.err.println(e.getStackTrace());
        }
    }
}
