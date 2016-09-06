package ie.tcd.slscs.NCIReader;

import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;
import java.nio.charset.Charset;

import org.htmlcleaner.*;

/*
* Copyright (c) 2016 Jim O'Regan <jaoregan@tcd.ie>
*
* Permission is hereby granted, free of charge, to any person obtaining a copy
* of this software and associated documentation files (the "Software"), to deal
* in the Software without restriction, including without limitation the rights
* to use, copy, modify, merge, publish, distribute, sublicense, and/or sell
* copies of the Software, and to permit persons to whom the Software is
* furnished to do so, subject to the following conditions:
*
* The above copyright notice and this permission notice shall be included in
* all copies or substantial portions of the Software.
*
* THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
* IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
* FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE
* AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
* LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
* OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN
* THE SOFTWARE.
*/

public class NCIReader {

    static void fromFile(String filename) throws Exception {
        CleanerProperties props = new CleanerProperties();
        ITagInfoProvider ti = new NCITeiTagProvider();
        props.setTreatUnknownTagsAsContent(false);
        props.setOmitHtmlEnvelope(true);
        System.err.println(props.getPruneTags());
        CleanerTransformations trans = new CleanerTransformations();
        TagTransformation t = new TagTransformation("catref", "catRef", false);
        HtmlCleaner cleaner = new HtmlCleaner(ti, props);
        props.setCleanerTransformations(trans);
        final SimpleXmlSerializer serialiser = new SimpleXmlSerializer(props);
        serialiser.setCreatingHtmlDom(false);
        TagNode tagnode = cleaner.clean(new File(filename), "UTF-16LE");
        serialiser.writeToFile(tagnode, filename + ".xml", "utf-8");
    }
}