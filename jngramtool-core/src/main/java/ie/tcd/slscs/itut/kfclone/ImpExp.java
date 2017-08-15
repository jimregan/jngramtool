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

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.List;

// Started to overdo it a little :D
public class ImpExp {
    static List<NGram> load(BufferedReader br) throws IOException {
        List<NGram> out = new ArrayList<NGram>();
        String line;

        while ((line = br.readLine()) != null) {
            String tmp[];
            tmp = line.split("\\t");
            if(tmp.length != 2) {
                throw new IOException("Error reading file: incorrect number of fields\n");
            }
            out.add(new NGram(tmp[0], Integer.parseInt(tmp[1])));
        }
        return out;
    }
    static List<NGram> load(InputStreamReader isr) throws IOException {
        return ImpExp.load(new BufferedReader(isr));
    }

    static List<NGram> load(FileInputStream isr, String cs) throws IOException {
        return ImpExp.load(new InputStreamReader(isr, Charset.forName(cs)));
    }

    static List<NGram> load(FileInputStream isr) throws IOException {
        return ImpExp.load(new InputStreamReader(isr, Charset.forName("UTF-8")));
    }

    static List<NGram> load(String s, String cs) throws IOException {
        return ImpExp.load(new FileInputStream(s), cs);
    }

    static List<NGram> load(String s) throws IOException {
        return ImpExp.load(new FileInputStream(s), "UTF-8");
    }
}
