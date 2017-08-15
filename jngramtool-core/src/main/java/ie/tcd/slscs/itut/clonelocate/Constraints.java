package ie.tcd.slscs.itut.clonelocate;

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
import java.util.ArrayList;
import java.util.List;

public class Constraints {
    public boolean ignoreCase = true;
    public boolean skipNormalTags = true;
    public boolean useStopWords = false;
    public boolean useSkipChars = false;
    public boolean useEqualChars = false;

    private List<Character> delims;
    private List<String> stopwords;
    private List<Character> skipchars;
    private List<Character> equalchars;

    Constraints() {
        delims = new ArrayList<Character>();
        stopwords = new ArrayList<String>();
    }

    public void setDelims(String s) {
        delims.clear();
        for(Character c : s.toCharArray()) {
            delims.add(c);
        }
    }
    public void setDelims() {
        setDelims(".,;:!#$^&()[]{}<>+=/\\|`~\"");
    }

    public String getDelims() {
        String out = "";
        for (Character c : delims) {
            out += c;
        }
        return out;
    }
    public boolean isDelimeter(char c) {
        if(delims.contains(c)) {
            return true;
        } else {
            return false;
        }
    }

    public void addStopWord(String s) {
        stopwords.add(s);
    }
    public void addStopWords(List<String> list) {
        stopwords.addAll(list);
    }
    public List<String> getStopWords() {
        return stopwords;
    }
    public boolean isStopWord(String s) {
        if(stopwords.contains(s)) {
            return true;
        } else {
            return false;
        }
    }
    public void removeStopWord(String s) {
        stopwords.remove(s);
    }
    public void setSkipChars(String s) {
        skipchars.clear();
        for(Character c : s.toCharArray()) {
            skipchars.add(c);
        }
    }
    public void setSkipChars() {
        setSkipChars("-=");
    }

    public String getSkipChars() {
        String out = "";
        for (Character c : skipchars) {
            out += c;
        }
        return out;
    }
    public boolean isSkipChar(char c) {
        if(!useSkipChars) {
            return false;
        } else {
            if (skipchars.contains(c)) {
                return true;
            } else {
                return false;
            }
        }
    }

}
