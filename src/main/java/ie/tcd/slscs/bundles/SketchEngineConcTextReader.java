package ie.tcd.slscs.bundles;
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
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.charset.Charset;
import java.util.HashSet;
import java.util.Set;

public class SketchEngineConcTextReader {

    public String read(BufferedReader br) throws IOException {
        String line;
        SketchEngineFile file = null;
        SketchEngineSentence sent = null;
        SketchEngineFragment phrase = null;
        Set<String> ids = new HashSet<String>();
        String last = "";
        while ((line = br.readLine()) != null) {
            if(line.startsWith("#")) {
                continue;
            } else if(line.contains("\t")) {
                String[] sa = line.split("\\t");
                ids.add(sa[0]);
                int bundle_start = sa[1].indexOf("< ", 1) + 2;
                int bundle_end = sa[1].indexOf(" >", bundle_start);
                String cur_bundle = sa[1].substring(bundle_start, bundle_end);
                if(!"".equals(last) && !last.toLowerCase().equals(cur_bundle.toLowerCase())) {
                    System.err.println("Error: current bundle (" + cur_bundle + ") does not match last (" + last + ")");
                }
                last = cur_bundle;
            }
        }
        return "Bundle: " + last + "; texts: " + ids.size();
    }
    public String read(InputStreamReader isr) throws IOException {
        return read(new BufferedReader(isr));
    }

    public String read(FileInputStream isr, String cs) throws IOException {
        return read(new InputStreamReader(isr, Charset.forName(cs)));
    }

    public String read(FileInputStream isr) throws IOException {
        return read(new InputStreamReader(isr, Charset.forName("UTF-8")));
    }

    public String read(String s, String cs) throws IOException {
        return read(new FileInputStream(s), cs);
    }

    public String read(String s) throws IOException {
        return read(new FileInputStream(s), "UTF-8");
    }
}
