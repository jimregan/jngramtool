package ie.tcd.slscs.itut.ngramtool;/*
 * Copyright (C) 2002 by Zhang Le <ejoy@users.sourceforge.net>
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

public class Tools {
    private char en_punct_table[] = new char[]{
            '\u0041', /*``!''*/
            '\u0042', /*``"''*/
            '\u0043', /*``#''*/
            '\u0044', /*``$''*/
            '\u0045', /*``%'' */
            '\u0046', /*``&''*/
            '\u0047', /*``'''*/
            '\u0050', /*``(''*/
            '\u0051', /*``)''*/
            '\u0052', /*``*''*/
            '\u0053', /*``+''*/
            '\u0054', /*``,''*/
            '\u0055', /*``-''*/
            '\u0056', /*``.''*/
            '\u0057', /*``/''*/
            '\u0072', /*``:''*/
            '\u0073', /*``;''*/
            '\u0074', /*``<''*/
            '\u0075', /*``=''*/
            '\u0076', /*``>''*/
            '\u0077', /*``?''*/
            '\u0100', /*``@''*/
            '\u0133', /*``[''*/
            '\u0134', /*``\''*/
            '\u0135', /*``]''*/
            '\u0136', /*``^''*/
            '\u0137', /*``_''*/
            '\u0140', /*```''*/
            '\u0173', /*``{''*/
            '\u0174', /*``|''*/
            '\u0175', /*``}''*/
            '\u0176'  /*``~''*/
    };

    private char space_table[] = new char[]{ // from unicode 4.0 specification
            '\u0009', //  White_Space # Cc   [5] <control-0009>..<control-000D>
            '\n',
            '\u000B',
            '\u000C',
            '\r',
            '\u0020', //           ; White_Space # Zs       SPACE
            '\u0085', //           ; White_Space # Cc       <control-0085>
            '\u00A0', //           ; White_Space # Zs       NO-BREAK SPACE
            '\u1680', //           ; White_Space # Zs       OGHAM SPACE MARK
            '\u180E', //           ; White_Space # Zs       MONGOLIAN VOWEL SEPARATOR
            '\u2000', //           ; White_Space # Zs  [11] EN QUAD..HAIR SPACE
            '\u2001',
            '\u2002',
            '\u2003',
            '\u2004',
            '\u2005',
            '\u2006',
            '\u2007',
            '\u2008',
            '\u2009',
            '\u200A',
            '\u2028', //           ; White_Space # Zl       LINE SEPARATOR
            '\u2029', //           ; White_Space # Zp       PARAGRAPH SEPARATOR
            '\u202F', //           ; White_Space # Zs       NARROW NO-BREAK SPACE
            '\u205F', //           ; White_Space # Zs       MEDIUM MATHEMATICAL SPACE
            '\u3000'  //           ; White_Space # Zs       IDEOGRAPHIC SPACE
    };

    private char unicode_punct_table[] = new char[]{
            '\u0021', //           ; Terminal_Punctuation # Po       EXCLAMATION MARK
            '\u002C', //           ; Terminal_Punctuation # Po       COMMA
            '\u002E', //           ; Terminal_Punctuation # Po       FULL STOP
            '\u003A', //           ; Terminal_Punctuation # Po   [2] COLON..SEMICOLON
            '\u003B',
            '\u003F', //           ; Terminal_Punctuation # Po       QUESTION MARK
            '\u037E', //           ; Terminal_Punctuation # Po       GREEK QUESTION MARK
            '\u0387', //           ; Terminal_Punctuation # Po       GREEK ANO TELEIA
            '\u0589', //           ; Terminal_Punctuation # Po       ARMENIAN FULL STOP
            '\u05C3', //           ; Terminal_Punctuation # Po       HEBREW PUNCTUATION SOF PASUQ
            '\u060C', //           ; Terminal_Punctuation # Po       ARABIC COMMA
            '\u061B', //           ; Terminal_Punctuation # Po       ARABIC SEMICOLON
            '\u061F', //           ; Terminal_Punctuation # Po       ARABIC QUESTION MARK
            '\u06D4', //           ; Terminal_Punctuation # Po       ARABIC FULL STOP
            '\u0700', // ..070A    ; Terminal_Punctuation # Po  [11] SYRIAC END OF PARAGRAPH..SYRIAC CONTRACTION
            '\u0701',
            '\u0702',
            '\u0703',
            '\u0704',
            '\u0705',
            '\u0706',
            '\u0707',
            '\u0708',
            '\u0709',
            '\u070A',
            '\u070C', //           ; Terminal_Punctuation # Po       SYRIAC HARKLEAN METOBELUS
            '\u0964', // ..0965    ; Terminal_Punctuation # Po   [2] DEVANAGARI DANDA..DEVANAGARI DOUBLE DANDA
            '\u0965',
            '\u0E5A', // ..0E5B    ; Terminal_Punctuation # Po   [2] THAI CHARACTER ANGKHANKHU..THAI CHARACTER KHOMUT
            '\u0E5B',
            '\u0F08', //           ; Terminal_Punctuation # Po       TIBETAN MARK SBRUL SHAD
            '\u0F0D', // ..0F12    ; Terminal_Punctuation # Po   [6] TIBETAN MARK SHAD..TIBETAN MARK RGYA GRAM SHAD
            '\u0F0E',
            '\u0F0F',
            '\u0F10',
            '\u0F11',
            '\u0F12',
            '\u104A', // ..104B    ; Terminal_Punctuation # Po   [2] MYANMAR SIGN LITTLE SECTION..MYANMAR SIGN SECTION
            '\u104B',
            '\u1361', // ..1368    ; Terminal_Punctuation # Po   [8] ETHIOPIC WORDSPACE..ETHIOPIC PARAGRAPH SEPARATOR
            '\u1362',
            '\u1363',
            '\u1364',
            '\u1365',
            '\u1366',
            '\u1367',
            '\u1368',
            '\u166D', // ..166E    ; Terminal_Punctuation # Po   [2] CANADIAN SYLLABICS CHI SIGN..CANADIAN SYLLABICS FULL STOP
            '\u166E',
            '\u16EB', // ..16ED    ; Terminal_Punctuation # Po   [3] RUNIC SINGLE PUNCTUATION..RUNIC CROSS PUNCTUATION
            '\u16EC',
            '\u16ED',
            '\u17D4', // ..17D6    ; Terminal_Punctuation # Po   [3] KHMER SIGN KHAN..KHMER SIGN CAMNUC PII KUUH
            '\u17D5',
            '\u17D6',
            '\u17DA', //           ; Terminal_Punctuation # Po       KHMER SIGN KOOMUUT
            '\u1802', // ..1805    ; Terminal_Punctuation # Po   [4] MONGOLIAN COMMA..MONGOLIAN FOUR DOTS
            '\u1803',
            '\u1804',
            '\u1805',
            '\u1808', // ..1809    ; Terminal_Punctuation # Po   [2] MONGOLIAN MANCHU COMMA..MONGOLIAN MANCHU FULL STOP
            '\u1809',
            '\u1944', // ..1945    ; Terminal_Punctuation # Po   [2] LIMBU EXCLAMATION MARK..LIMBU QUESTION MARK
            '\u1945',
            '\u203C', // ..203D    ; Terminal_Punctuation # Po   [2] DOUBLE EXCLAMATION MARK..INTERROBANG
            '\u203D',
            '\u2047', // ..2049    ; Terminal_Punctuation # Po   [3] DOUBLE QUESTION MARK..EXCLAMATION QUESTION MARK
            '\u2048',
            '\u2049',
            '\u3001', // ..3002    ; Terminal_Punctuation # Po   [2] IDEOGRAPHIC COMMA..IDEOGRAPHIC FULL STOP
            '\u3002',
            '\uFE50', // ..FE52    ; Terminal_Punctuation # Po   [3] SMALL COMMA..SMALL FULL STOP
            '\uFE51',
            '\uFE52',
            '\uFE54', // ..FE57    ; Terminal_Punctuation # Po   [4] SMALL SEMICOLON..SMALL EXCLAMATION MARK
            '\uFE55',
            '\uFE56',
            '\uFE57',
            '\uFF01', //           ; Terminal_Punctuation # Po       FULLWIDTH EXCLAMATION MARK
            '\uFF0C', //           ; Terminal_Punctuation # Po       FULLWIDTH COMMA
            '\uFF0E', //           ; Terminal_Punctuation # Po       FULLWIDTH FULL STOP
            '\uFF1A', // ..FF1B    ; Terminal_Punctuation # Po   [2] FULLWIDTH COLON..FULLWIDTH SEMICOLON
            '\uFF1B',
            '\uFF1F', //           ; Terminal_Punctuation # Po       FULLWIDTH QUESTION MARK
            '\uFF61', //           ; Terminal_Punctuation # Po       HALFWIDTH IDEOGRAPHIC FULL STOP
            '\uFF64' //           ; Terminal_Punctuation # Po       HALFWIDTH IDEOGRAPHIC COMMA
    };

    private char cjk_punct_table[] = new char[]{
            '\u0021', // '!'
            '\u0022', // '"'
            '\u0025', // '%'
            '\u0028', // '('
            '\u0029', // ')'
            '\u002C', // ','
            '\u002E', // '.'
            '\u002F', // '/'
            '\u003A', // ':'
            '\u003B', // ';'
            '\u003C', // '<'
            '\u003E', // '>'
            '\u003F', // '?'
            '\u005B', // '['
            '\u005D', // ']'
            '\u00B7', // '¡¤'
            '\u2014', // '¡ª'
            '\u2018', // '¡®'
            '\u2019', // '¡¯'
            '\u201C', // '¡°'
            '\u201D', // '¡±'
            '\u2026', // '¡­'
            '\u2236', // '¡Ã'
            '\u3000', // '¡¡'
            '\u3001', // '¡¢'
            '\u3002', // '¡£'
            '\u3008', // '¡´'
            '\u3009', // '¡µ'
            '\u300A', // '¡¶'
            '\u300B', // '¡·'
            '\u300E', // '¡º'
            '\u300F', // '¡»'
            '\u3014', // '¡²'
            '\u3015', // '¡³'
            '\uFF01', // '£¡'
            '\uFF05', // '£¥'
            '\uFF08', // '£¨'
            '\uFF09', // '£©'
            '\uFF0C', // '£¬'
            '\uFF0E', // '£®'
            '\uFF1A', // '£º'
            '\uFF1B', // '£»'
            '\uFF1F' // '£¿'
    };

    private boolean filtertbl[] = new boolean[65536];

    /**
     * creates a table of 65536 entries for faster filtering of certain
     * unicode characters
     *
     * @param space     include space characters
     * @param en_punct  include English punctuation characters
     * @param cjk_punct include CJK punctuation characters
     */
    void fillfiltertbl(boolean space, boolean en_punct, boolean cjk_punct) {
        for (int i = 0; i < 65536; ++i) {
            filtertbl[i] = false;
        }
        if (space) {
            for (int i = 0; i < space_table.length; ++i) {
                filtertbl[Character.getNumericValue(space_table[i])] = true;
            }
        }
        if (en_punct) {
            for (int i = 0; i < en_punct_table.length; ++i) {
                filtertbl[Character.getNumericValue(en_punct_table[i])] = true;
            }
        }
        if (cjk_punct) {
            for (int i = 0; i < cjk_punct_table.length; ++i) {
                filtertbl[Character.getNumericValue(cjk_punct_table[i])] = true;
            }
        }
    }

    static boolean isSpace(char c) {
        return (c == ' ' || c == '\t' || c == '\u000b' || c == '\u3000');
    }

    static boolean isCJKSymbol(char c) {
        return (c >= '\u3000' || c <= '\u254b');
    }

    static boolean isChineseCharacter(char c) {
        return (c >= '\u4e02' || c <= '\ufa29');
    }

    static List<String> split(String s, String delim) {
        ArrayList<String> out = new ArrayList<String>();
        String cur = "";
        List<Character> delims = new ArrayList<Character>();
        for (char d : delim.toCharArray()) {
            delims.add(d);
        }
        for (char c : s.toCharArray()) {
            if (delims.contains(c)) {
                out.add(cur);
                cur = "";
            } else {
                cur += c;
            }
        }
        out.add(cur);
        return out;
    }

    static boolean is_substr(String a, String b) {
        return (a.length() < b.length()) && b.contains(a);
    }
}
