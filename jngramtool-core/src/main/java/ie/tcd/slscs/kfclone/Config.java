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

import java.util.ArrayList;
import java.util.List;

public class Config {
    Config() {
        tokenchars = new ArrayList<Character>();
        setKeepAsToken();
    }
    private boolean case_sensitive = false;
    public boolean isCaseSensitive() {
        return case_sensitive;
    }
    public void setCaseSensitive(boolean cs) {
        case_sensitive = cs;
    }

    /**
     * For reading the 'optCase' option from the config
     * @param s
     */
    public void setCaseSensitive(String s) {
        if("1".equals(s)) {
            setCaseSensitive(true);
        } else {
            setCaseSensitive(false);
        }
    }
    public void setCaseSensitive(int i) {
        if(i == 1) {
            setCaseSensitive(true);
        } else {
            setCaseSensitive(false);
        }
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
    public void setReplaceNumbers(String s) {
        if("2".equals(s)) {
            setReplaceNumbers(true);
            setReplaceAllNumbers(true);
        } else if("1".equals(s)) {
            setReplaceNumbers(true);
            setReplaceAllNumbers(false);
        } else {
            setReplaceNumbers(false);
            setReplaceAllNumbers(false);
        }
    }
    public void setReplaceNumbers(int i) {
        if(i == 2) {
            setReplaceNumbers(true);
            setReplaceAllNumbers(true);
        } else if(i == 1) {
            setReplaceNumbers(true);
            setReplaceAllNumbers(false);
        } else {
            setReplaceNumbers(false);
            setReplaceAllNumbers(false);
        }
    }
    public int getReplaceNumbersIndex() {
        if(replace_all_numbers) {
            return 2;
        } else if(replace_numbers) {
            return 1;
        } else {
            return 0;
        }
    }

    private boolean use_keep_as_token = false;
    private String keep_as_token = ".:;!¡?¿©";
    private List<Character> tokenchars;
    public void useKeepAsToken(boolean b) {
        use_keep_as_token = b;
    }
    private void setKeepAsToken() {
        tokenchars.clear();
        for (Character c : keep_as_token.toCharArray()) {
            tokenchars.add(c);
        }
    }
    public void setKeepAsToken(String s) {
        keep_as_token = s;
        setKeepAsToken();
    }
    public boolean isTokenChar(char c) {
        return tokenchars.contains(c);
    }

    public String getKeepChars() {
        return keepChars;
    }

    public void setKeepChars(String keepChars) {
        if(keepChars != null && !"".equals(keepChars)) {
            this.keepChars = keepChars;
        }
    }

    private String keepChars = "0123456789ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyzÀÁÂÃÄÅÆÇÈÉÊËÌÍÎÏÐÑÒÓÔÕÖØŒÙÚÛÜÝŸÞßªàáâãäåæçèéêëìíîïðñºòóôõöøœùúûüýþÿŠŽšž©";

    public String getLcMapChars() {
        return lcMapChars;
    }
    public void setLcMapChars(String lcMapChars) {
        if(lcMapChars != null && !"".equals(lcMapChars)) {
            this.lcMapChars = lcMapChars;
        }
    }
    private String lcMapChars = "0123456789abcdefghijklmnopqrstuvwxyzabcdefghijklmnopqrstuvwxyzàáâãäåæçèéêëìíîïðñòóôõöøœùúûüýÿþßªàáâãäåæçèéêëìíîïðñºòóôõöøœùúûüýþÿšžšž©";

    public String getCsMapChars() {
        return csMapChars;
    }
    public void setCsMapChars(String csMapChars) {
        if(csMapChars != null && !"".equals(csMapChars)) {
            this.csMapChars = csMapChars;
        }
    }
    private String csMapChars = "0123456789ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyzÀÁÂÃÄÅÆÇÈÉÊËÌÍÎÏÐÑÒÓÔÕÖØŒÙÚÛÜÝŸÞßªàáâãäåæçèéêëìíîïðñºòóôõöøœùúûüýþÿŠŽšž©";

    public String getSortOrder() {
        return sortOrder;
    }
    public void setSortOrder(String sortOrder) {
        if(sortOrder != null && !"".equals(sortOrder)) {
            this.sortOrder = sortOrder;
        }
    }
    private String sortOrder = ".,-\n#0123456789AÀÁÂÃÄÅÆaªàáâãäåæBbCÇcç©DdÐðEÈÉÊËeèéêëFfGgHhIÌÍÎÏiìíîïJjKkLlMmNÑnñOÒÓÔÕÖØŒoºòóôõöøœPpQqRrSŠsßšTtÞþUÙÚÛÜuùúûüVvWwXxYÝŸyýÿZŽzž";

    public int getRangeSize() {
        return rangeSize;
    }
    public void setRangeSize(int rangeSize) {
        this.rangeSize = rangeSize;
    }
    public void setRangeSize(String rangeSize) {
        if(rangeSize != null && !"".equals(rangeSize)) {
            this.rangeSize = Integer.parseInt(rangeSize);
        }
    }
    private int rangeSize = 80000;

    public String getFontFace() {
        return fontFace;
    }
    public void setFontFace(String fontFace) {
        if(fontFace != null && !"".equals(fontFace)) {
            this.fontFace = fontFace;
        }
    }
    private String fontFace = "Arial";

    public int getFontSize() {
        return fontSize;
    }
    public void setFontSize(int fontSize) {
        this.fontSize = fontSize;
    }
    public void setFontSize(String fontSize) {
        if(fontSize != null && !"".equals(fontSize)) {
            this.fontSize = Integer.parseInt(fontSize);
        }
    }
    private int fontSize = 11;

    public String getConfigPath() {
        return configPath;
    }
    public void setConfigPath(String configPath) {
        this.configPath = configPath;
    }
    private String configPath;

    public int getFloor() {
        return floor;
    }
    public String getFloorString() {
        return Integer.toString(floor);
    }
    public void setFloor(int floor) {
        this.floor = floor;
    }
    public void setFloor(String floor) {
        if(floor != null && !"".equals(floor)) {
            this.floor = Integer.parseInt(floor);
        }
    }
    private int floor = 1;

}
