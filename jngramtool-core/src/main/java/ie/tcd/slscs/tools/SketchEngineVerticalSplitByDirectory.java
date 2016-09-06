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

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.List;
import ie.tcd.slscs.bundles.Utils;

public class SketchEngineVerticalSplitByDirectory {

    public static void main(String[] args) {
        String line;

        try {
            InputStream fis = new FileInputStream(args[0]);
            InputStreamReader isr = new InputStreamReader(fis, Charset.forName("UTF-8"));
            BufferedReader br = new BufferedReader(isr);
            OutputStream fos = null;
            OutputStreamWriter osw = null;
            BufferedWriter bw = null;
            String lastpath = "";
            while ((line = br.readLine()) != null) {
                if(line.startsWith("<file ")) {
                    int parent_beg = line.indexOf("parent_folder=\"", 5);
                    parent_beg += 14;
                    int parent_end = line.indexOf('"', parent_beg+1);
                    String folder = line.substring(parent_beg+1, parent_end);
                    int filename_beg = line.indexOf(" filename=\"", 5);
                    filename_beg += 11;
                    int filename_end = line.indexOf('"', filename_beg+1);
                    String filename = line.substring(filename_beg, filename_end);
                    int dir_end = filename.lastIndexOf('/');
                    String directory = filename.substring(0, dir_end);
                    
                    System.err.println("File: " + filename);
                    if(!directory.equals(lastpath)) {
                        System.err.println("DIR: " + directory);
                        if(bw != null) {
                            bw.flush();
                            bw.close();
                        }
                        fos = new FileOutputStream(directory.replaceAll("/", "_") + "merged.vert");
                        osw = new OutputStreamWriter(fos, Charset.forName("UTF-8"));
                        bw = new BufferedWriter(osw);
                        lastpath = directory;
                    }
                    bw.write(line);
                    bw.newLine();

                } else {
                    if(bw != null) {
                        bw.write(line);
                        bw.newLine();
                    }
                }
            }
            if(bw != null) {
                bw.flush();
                bw.close();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}
