package ie.tcd.slscs.ie.tcd.slscs.tools;

import ie.tcd.slscs.ngramtool.NGram;

import java.util.ArrayList;
import java.util.List;

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
public class AKEntry {
    String bundle;
    int freq;
    List<String> languages;
    List<String> years;
    List<String> fields;
    List<String> authors;

    AKEntry() {
        languages = new ArrayList<String>();
        years = new ArrayList<String>();
        fields = new ArrayList<String>();
        authors = new ArrayList<String>();
    }

    AKEntry(String b, int f, String l, String y, String fi, String a) {
        this();
        bundle = b;
        freq = f;
        languages.add(l);
        years.add(y);
        fields.add(fi);
        authors.add(a);
    }
    AKEntry(String[] tmp) {
        this(tmp[0], Integer.parseInt(tmp[1]), tmp[2], tmp[3], tmp[4], tmp[5]);
    }
    AKEntry(String s) {
        this(s.split("\t"));
    }
    public void update(int f, String l, String y, String fi, String a) {
        freq += f;
        languages.add(l);
        years.add(y);
        fields.add(fi);
        authors.add(a);
    }
    public String summariseAuthorField() {
        StringBuilder sb = new StringBuilder(bundle);
        sb.append('\t');
        sb.append(freq);
        sb.append('\t');
        sb.append(authors.size());
        sb.append('\t');
        sb.append(fields.size());
        return sb.toString();
    }
    public static AKEntry entryFromLine(String s) {
        String[] tmp = s.split("\\t");
        return new AKEntry(tmp[0], Integer.parseInt(tmp[1]), tmp[2], tmp[3], tmp[4], tmp[5]);
    }
    public static NGram entryToNgram(AKEntry e) {
        return new NGram(e.bundle, e.freq);
    }
    public NGram toNgram() {
        return new NGram(bundle, freq);
    }
}
