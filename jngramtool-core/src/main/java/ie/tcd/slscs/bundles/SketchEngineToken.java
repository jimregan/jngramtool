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

public class SketchEngineToken {
    private String surface;
    private String tag;
    private String lemmatag;
    private String lemma;
    public SketchEngineToken(String sf, String t, String lt) {
        surface = sf;
        tag = t;
        lemmatag = lt;
        lemma = lemmatag.substring(0, lemmatag.length() - 2);
    }
    public String getSurface() {
        return surface;
    }
    public String getTag() {
        return tag;
    }
    public String getLemma() {
        return lemma;
    }
    public String getVertical() {
        return surface + "\t" + tag + "\t" + lemmatag;
    }
}
