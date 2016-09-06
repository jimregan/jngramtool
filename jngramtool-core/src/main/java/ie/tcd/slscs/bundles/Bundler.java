package ie.tcd.slscs.bundles;

import ie.tcd.slscs.ngramtool.NGram;

import java.util.*;
import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.InputStream;
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
 * FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT.  IN NO EVENT SHALL
 * THE AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
 * LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING
 * FROM, OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER
 * DEALINGS IN THE SOFTWARE.
 */
public class Bundler {
    private class FileItem {
        String filename;
        String l1;
        String surname;
        String year;
        String journal;
        FileItem(String[] inline) {
            filename = inline[0];
            l1 = inline[1];
            surname = inline[2];
            year = inline[3];
            journal = inline[4];
        }
    }
    public void readFileList(String filename) throws IOException {
        String line;
        InputStream fis = new FileInputStream(filename);
        InputStreamReader isr = new InputStreamReader(fis, Charset.forName("UTF-8"));
        BufferedReader br = new BufferedReader(isr);
        List<FileItem> items = new ArrayList<FileItem>();

        while ((line = br.readLine()) != null) {
            String inline[] = line.split("\\t");
            if(inline.length != 5) {
                System.err.println("Error reading line: " + line);
            } else {
                items.add(new FileItem(inline));
            }
        }
    }

    public void readFile(String filename) throws IOException {
        String line;
        InputStream fis = new FileInputStream(filename);
        InputStreamReader isr = new InputStreamReader(fis, Charset.forName("UTF-8"));
        BufferedReader br = new BufferedReader(isr);
        List<FileItem> items = new ArrayList<FileItem>();

        while ((line = br.readLine()) != null) {
            String inline[] = line.split("\\t");
            if(inline.length != 5) {
                System.err.println("Error reading line: " + line);
            } else {
                items.add(new FileItem(inline));
            }
        }
    }
}
