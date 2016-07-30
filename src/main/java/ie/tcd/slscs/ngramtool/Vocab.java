package ie.tcd.slscs.ngramtool;/*
 * Copyright (C) 2004 by Zhang Le <ejoy@users.sourceforge.net>
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
import java.io.*;
import java.nio.charset.Charset;
import java.util.HashMap;
import java.util.Map;

public class Vocab {
    private Map<String, Integer> vocab = new HashMap<String, Integer>();
    private int last_id = 0;

    private void clear_vocab() {
        vocab.clear();
        last_id = 0;
    }
    public int idSpace;
    public int idTab;
    public int idVt;
    public int idFullStop;
    public int idQuestion;
    public int idSeparator;
    public int idInter;
    public int idBOS;
    public int idEOS;
    public int idSpecialLast;

    public int add(String s) {
        int out = last_id;
        last_id++;
        vocab.put(s, out);
        return out;
    }

    private void init_special_ids() {
        clear_vocab();
        add("__NULL_ID__");
        idSpace = add(" ");
        idTab = add("\t");
        idVt = add("\u000B");
        idFullStop = add(".");
        idQuestion = add("?");
        idSeparator = add(";");
        idInter = add("!");
        idBOS = add("__BOS__");
        idEOS = add("__EOS__");
        idSpecialLast = idEOS;
    }

    Vocab() {
        init_special_ids();
    }

    private String charset = "UTF-8";
    public void setCharset(String cs) {
        charset = cs;
    }

    void load(String filename) throws IOException {
        String line;
        InputStream fis = new FileInputStream(filename);
        InputStreamReader isr = new InputStreamReader(fis, Charset.forName(charset));
        BufferedReader br = new BufferedReader(isr);

        while ((line = br.readLine()) != null) {
            add(line);
        }
    }

    void save(String filename) throws IOException {
        OutputStream fos = new FileOutputStream(filename);
        OutputStreamWriter osw = new OutputStreamWriter(fos, Charset.forName(charset));
        BufferedWriter bw = new BufferedWriter(osw);

        for (Map.Entry<String, Integer> e : vocab.entrySet()) {
            if (e.getValue() > idSpecialLast) {
                bw.write(e.getKey());
                bw.newLine();
            }
        }
    }
}
