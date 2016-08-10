package ie.tcd.slscs.ie.tcd.slscs.tools;

import java.io.*;
import java.nio.charset.Charset;
import java.util.HashMap;
import java.util.Map;

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
public class AKBundleMerge {
    public static void main(String[] args) {
        Map<String, AKEntry> entries = new HashMap<String, AKEntry>();
        try {
            String line;
            InputStream fis = new FileInputStream(args[0]);
            InputStreamReader isr = new InputStreamReader(fis, Charset.forName("CP1252"));
            BufferedReader br = new BufferedReader(isr);

            while ((line = br.readLine()) != null) {
                String[] tmp = line.split("\\t");
                if(entries.containsKey(tmp[0])) {
                    AKEntry t = entries.get(tmp[0]);
                    t.update(Integer.parseInt(tmp[1]), tmp[2], tmp[3], tmp[4], tmp[5]);
                } else {
                    entries.put(tmp[0], new AKEntry(tmp));
                }
            }

            OutputStream fos = new FileOutputStream(args[0] + ".summ.txt");
            OutputStreamWriter osw = new OutputStreamWriter(fos, Charset.forName("UTF-8"));
            BufferedWriter bw = new BufferedWriter(osw);
            for(String s : entries.keySet()) {
                AKEntry e = entries.get(s);
                bw.write(e.summariseAuthorField());
                bw.newLine();
            }
        } catch (Exception e) {
            System.err.println(e.getStackTrace());
        }

    }
}
