package ie.tcd.slscs.itut.tools;

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
public class AKDiscardKFNGramPunct {
    public static void main(String[] args) {
        try {
            String line;
            InputStream fis = new FileInputStream(args[0]);
            InputStreamReader isr = new InputStreamReader(fis, Charset.forName("UTF-8"));
            BufferedReader br = new BufferedReader(isr);

            OutputStream fos = new FileOutputStream(args[0] + ".filt.txt");
            OutputStreamWriter osw = new OutputStreamWriter(fos, Charset.forName("UTF-8"));
            BufferedWriter bw = new BufferedWriter(osw);

            while ((line = br.readLine()) != null) {
                boolean has_punct = false;
                String[] tmpa = line.split("\\t");
                String[] tmpb = tmpa[0].split(" ");
                for (String s : tmpb) {
                    if(s.equals(".") || s.equals("!") || s.equals("?") || s.equals(":") || s.equals(";")) {
                        has_punct = true;
                    }
                }
                if(!has_punct) {
                    bw.write(line);
                    bw.newLine();
                } else {
                    has_punct = false;
                }
            }

            bw.close();
        } catch (Exception e) {
            System.err.println(e.getStackTrace());
        }

    }
}
