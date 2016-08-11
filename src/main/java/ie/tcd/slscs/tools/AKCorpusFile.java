package ie.tcd.slscs.tools;

import ie.tcd.slscs.bundles.Utils;
import ie.tcd.slscs.ngramtool.NGram;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Pattern;
import java.util.regex.Matcher;
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

public class AKCorpusFile {
    String filename;
    String author;
    String language;
    String year;
    String field;

    List<String> text;

    AKCorpusFile() {
        text = new ArrayList<String>();
    }
    AKCorpusFile(String filename, String author, String year) {
        this();
        this.filename = filename;
        this.author = author.toLowerCase();
        this.year = year;
        String[] tmp = filename.split("\\/");
        this.field = tmp[0];
        this.language = tmp[1];
    }
    AKCorpusFile(String[] a) {
        this(a[0], a[1], a[2]);
    }
    AKCorpusFile(String s) {
        this();
        this.filename = s;
        String ps = "([a-z][-a-z]*)(\\d\\d\\d\\d)\\.txt";
        Pattern p = Pattern.compile(ps);
        String[] tmp = filename.split("\\/");
        this.field = tmp[0];
        this.language = tmp[1];
        if(tmp[2].matches("\\-\\d\\d\\d\\d\\-")) {
            String[] tmpa = tmp[2].split("-");
            this.author = tmpa[0].toLowerCase();
            this.year = tmpa[1];
        } else if(s.matches(ps)) {
            Matcher m = p.matcher(s);
            m.find();
            this.author = m.group(1).toLowerCase();
            this.year = m.group(2);
        }
    }
    public void read(String path) throws IOException {
        String line;
        String fullfile = path + filename;
        InputStream fis = new FileInputStream(fullfile);
        InputStreamReader isr = new InputStreamReader(fis, Charset.forName("UTF-8"));
        BufferedReader br = new BufferedReader(isr);

        while ((line = br.readLine()) != null) {
            text.add(line);
        }
    }
    public List<String> getText() {
        return text;
    }
    public void clearText() {
        text.clear();
    }
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(filename);
        sb.append("\t");
        sb.append(author);
        sb.append("\t");
        sb.append(language);
        sb.append("\t");
        sb.append(year);
        sb.append("\t");
        sb.append(field);
        return sb.toString();
    }
}
