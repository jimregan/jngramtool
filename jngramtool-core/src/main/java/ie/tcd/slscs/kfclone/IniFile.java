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

import org.ini4j.Ini;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;

public class IniFile {
    public Config getCfg() {
        return cfg;
    }
    private Config cfg;
    private Ini ini;
    private Ini.Section customise;
    private Ini.Section runtime;
    
    IniFile() {
        cfg = new Config();
        ini = new Ini();
    }
    IniFile(File file) throws Exception {
        this();
        fromFile(file);
    }
    IniFile(String filename) throws Exception {
        this(new File(filename));
    }
    public void fromFile(File file) throws Exception {
        ini.load(new FileReader(file));
        customise = ini.get("Customize");
        runtime = ini.get("Runtime");
        cfg.setKeepChars(customise.get("KeepChars"));
        cfg.setLcMapChars(customise.get("lcMapchars"));
        cfg.setCsMapChars(customise.get("csMapChars"));
        cfg.setKeepAsToken(customise.get("TreatAsToken"));
        cfg.setSortOrder(customise.get("sortorder"));
        cfg.setRangeSize(customise.get("rangesize"));
        cfg.setFontFace(customise.get("DisplayFontFace"));
        cfg.setFontSize(customise.get("DisplayFontSize"));
        cfg.setCaseSensitive(runtime.get("optCase"));
        cfg.setReplaceNumbers(runtime.get("optRemapNum"));
        cfg.setFloor(runtime.get("floor"));
    }
    public void fromFile(String filename) throws Exception {
        fromFile(new File(filename));
    }
    public void fromFile() throws Exception {
        fromFile(tryDefaultLocations());
    }
    private File tryDefaultLocations() throws FileNotFoundException {
        File f;
        f = new File("kfNgram.cfg");
        if(f.isFile()) {
            String dir = System.getProperty("user.dir");
            cfg.setConfigPath(dir + File.pathSeparator + "kfNgram.cfg");
            return f;
        }
        f = new File("C:\\Program Files (x86)\\kfNgram\\kfNgram.cfg");
        if(f.isFile()) {
            cfg.setConfigPath("C:\\Program Files (x86)\\kfNgram\\kfNgram.cfg");
            return f;
        }
        f = new File("C:\\Program Files\\kfNgram\\kfNgram.cfg");
        if(f.isFile()) {
            cfg.setConfigPath("C:\\Program Files\\kfNgram\\kfNgram.cfg");
            return f;
        }
        throw new FileNotFoundException("kfNgram.cfg");
    }
}
