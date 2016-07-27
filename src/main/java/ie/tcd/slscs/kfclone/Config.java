package ie.tcd.slscs.kfclone;
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

public class Config {
    private boolean case_sensitive = false;
    public boolean isCaseSensitive() {
        return case_sensitive;
    }
    public void setCaseSensitive(boolean cs) {
        case_sensitive = cs;
    }

    private boolean replace_numbers = true;
    private boolean replace_all_numbers = true;
    public boolean replaceNumbers() {
        return replace_numbers;
    }
    public boolean replaceAllNumbers() {
        return replace_all_numbers;
    }
    public void setReplaceNumbers(boolean rep) {
        replace_numbers = rep;
    }
    public void setReplaceAllNumbers(boolean rep) {
        replace_all_numbers = rep;
    }
}
