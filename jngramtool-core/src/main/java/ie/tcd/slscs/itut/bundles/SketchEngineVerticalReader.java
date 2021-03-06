package ie.tcd.slscs.itut.bundles;

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

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.List;
import ie.tcd.slscs.itut.bundles.Utils;
import ie.tcd.slscs.itut.bundles.SketchEngineSentence;
import ie.tcd.slscs.itut.bundles.SketchEngineFile;
import ie.tcd.slscs.itut.bundles.SketchEngineFragment;

public class SketchEngineVerticalReader {
    SketchEngineCorpus corpus;
    public SketchEngineVerticalReader() {
        corpus = new SketchEngineCorpus();
    }

    public void read(BufferedReader br) throws IOException {
        String line;
        SketchEngineFile file = null;
        SketchEngineSentence sent = null;
        SketchEngineFragment phrase = null;

        while ((line = br.readLine()) != null) {
            if(line.startsWith("<file ")) {
                int parent_beg = line.indexOf("parent_folder=\"", 5);
                parent_beg += 14;
                int parent_end = line.indexOf('"', parent_beg+1);
                String parent = line.substring(parent_beg+1, parent_end);
                int id_beg = line.indexOf(" id=\"", 5);
                id_beg += 5;
                int id_end = line.indexOf('"', id_beg+1);
                String id = line.substring(id_beg, id_end);
                int filename_beg = line.indexOf(" filename=\"", 5);
                filename_beg += 11;
                int filename_end = line.indexOf('"', filename_beg+1);
                String filename = line.substring(filename_beg, filename_end);
                file = new SketchEngineFile(parent, id, filename);
            } else if("</file>".equals(line)) {
                if(file != null) {
                    corpus.add(file);
                }
            } else if("<s>".equals(line)) {
                sent = new SketchEngineSentence();
            } else if("</s>".equals(line)) {
                // ends both the sentence and current phrase
                if(sent != null) {
                    if(phrase != null) {
                        sent.add(phrase);
                        phrase = null;
                    }
                    file.add(sent);
                }
            } else if("<g/>".equals(line)) {
                if(phrase != null) {
                    phrase.setGroup(true);
                    sent.add(phrase);
                }
                phrase = new SketchEngineFragment();
            } else if(line.matches("\\t")) {
                String[] tmp = line.split("\\t");
                phrase.add(new SketchEngineToken(tmp[0], tmp[1], tmp[2]));
            }
        }
    }
    public void read(InputStreamReader isr) throws IOException {
        read(new BufferedReader(isr));
    }

    public void read(FileInputStream isr, String cs) throws IOException {
        read(new InputStreamReader(isr, Charset.forName(cs)));
    }

    public void read(FileInputStream isr) throws IOException {
        read(new InputStreamReader(isr, Charset.forName("UTF-8")));
    }

    public void read(String s, String cs) throws IOException {
        read(new FileInputStream(s), cs);
    }

    public void read(String s) throws IOException {
        read(new FileInputStream(s), "UTF-8");
    }

    public SketchEngineCorpus getCorpus() {
        return corpus;
    }
}
