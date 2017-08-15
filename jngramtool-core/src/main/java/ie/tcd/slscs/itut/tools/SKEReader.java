package ie.tcd.slscs.itut.tools;

import java.util.Map;

import ie.tcd.slscs.itut.bundles.SketchEngineVerticalReader;

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

public class SKEReader {
    public static void main(String[] args) {
        System.err.println("Starting");
        SketchEngineVerticalReader reader = new SketchEngineVerticalReader();
        if(args.length > 1) {
            try {
                reader.read(args[0]);
                Map<String, String> map = reader.getCorpus().getIDtoFilenameMap();
                for(Map.Entry<String, String> e : map.entrySet()) {
                    System.err.println(e.getKey() + " " + e.getValue());
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }
}
