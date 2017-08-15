package ie.tcd.slscs.itut.NCIReader;

import org.htmlcleaner.*;

import java.util.HashMap;

public class NCITeiTagProvider extends HashMap<String, TagInfo> implements ITagInfoProvider {

    public NCITeiTagProvider() {
        TagInfo tagInfo;

        tagInfo = new TagInfo("address", ContentType.all, BelongsTo.BODY, false, false, false, CloseTag.required, Display.block);
        this.put("address", tagInfo);

        tagInfo = new TagInfo("addrline", ContentType.all, BelongsTo.BODY, false, false, false, CloseTag.required, Display.block);
        this.put("addrline", tagInfo);

        tagInfo = new TagInfo("author", ContentType.all, BelongsTo.BODY, false, false, false, CloseTag.required, Display.block);
        this.put("author", tagInfo);

        tagInfo = new TagInfo("availability", ContentType.all, BelongsTo.BODY, false, false, false, CloseTag.required, Display.block);
        this.put("availability", tagInfo);

        tagInfo = new TagInfo("biblStruct", ContentType.all, BelongsTo.BODY, false, false, false, CloseTag.required, Display.block);
        this.put("biblStruct", tagInfo);

        tagInfo = new TagInfo("body", ContentType.all, BelongsTo.BODY, false, false, false, CloseTag.required, Display.block);
        this.put("body", tagInfo);

        tagInfo = new TagInfo("byline", ContentType.all, BelongsTo.BODY, false, false, false, CloseTag.required, Display.block);
        this.put("byline", tagInfo);

        tagInfo = new TagInfo("caption", ContentType.all, BelongsTo.BODY, false, false, false, CloseTag.required, Display.block);
        this.put("caption", tagInfo);

        tagInfo = new TagInfo("catref", ContentType.none, BelongsTo.BODY, false, false, false, CloseTag.optional, Display.inline);
        tagInfo.setName("catRef");
        this.put("catref", tagInfo);
        this.put("catRef", tagInfo);

        tagInfo = new TagInfo("creation", ContentType.all, BelongsTo.BODY, false, false, false, CloseTag.required, Display.block);
        this.put("creation", tagInfo);

        tagInfo = new TagInfo("Date", ContentType.all, BelongsTo.BODY, false, false, false, CloseTag.required, Display.block);
        this.put("Date", tagInfo);

        tagInfo = new TagInfo("distributor", ContentType.all, BelongsTo.BODY, false, false, false, CloseTag.required, Display.block);
        this.put("distributor", tagInfo);

        tagInfo = new TagInfo("div1", ContentType.all, BelongsTo.BODY, false, false, false, CloseTag.required, Display.block);
        this.put("div1", tagInfo);

        tagInfo = new TagInfo("extent", ContentType.all, BelongsTo.BODY, false, false, false, CloseTag.required, Display.block);
        this.put("extent", tagInfo);

        tagInfo = new TagInfo("fileDesc", ContentType.all, BelongsTo.BODY, false, false, false, CloseTag.required, Display.block);
        this.put("fileDesc", tagInfo);

        tagInfo = new TagInfo("foreign", ContentType.all, BelongsTo.BODY, false, false, false, CloseTag.required, Display.block);
        this.put("foreign", tagInfo);

        tagInfo = new TagInfo("group", ContentType.all, BelongsTo.BODY, false, false, false, CloseTag.required, Display.block);
        this.put("group", tagInfo);

        tagInfo = new TagInfo("head", ContentType.all, BelongsTo.BODY, false, false, false, CloseTag.required, Display.block);
        this.put("head", tagInfo);

        tagInfo = new TagInfo("hi", ContentType.all, BelongsTo.BODY, false, false, false, CloseTag.required, Display.block);
        this.put("hi", tagInfo);

        tagInfo = new TagInfo("idno", ContentType.all, BelongsTo.BODY, false, false, false, CloseTag.required, Display.block);
        this.put("idno", tagInfo);

        tagInfo = new TagInfo("imprint", ContentType.all, BelongsTo.BODY, false, false, false, CloseTag.required, Display.block);
        this.put("imprint", tagInfo);

        tagInfo = new TagInfo("monogr", ContentType.all, BelongsTo.BODY, false, false, false, CloseTag.required, Display.block);
        this.put("monogr", tagInfo);

        tagInfo = new TagInfo("p", ContentType.all, BelongsTo.BODY, false, false, false, CloseTag.optional, Display.block);
        this.put("p", tagInfo);

        tagInfo = new TagInfo("profileDesc", ContentType.all, BelongsTo.BODY, false, false, false, CloseTag.required, Display.block);
        this.put("profileDesc", tagInfo);

        tagInfo = new TagInfo("publicationStmt", ContentType.all, BelongsTo.BODY, false, false, false, CloseTag.required, Display.block);
        this.put("publicationStmt", tagInfo);

        tagInfo = new TagInfo("publisher", ContentType.all, BelongsTo.BODY, false, false, false, CloseTag.required, Display.block);
        this.put("publisher", tagInfo);

        tagInfo = new TagInfo("pubPlace", ContentType.all, BelongsTo.BODY, false, false, false, CloseTag.required, Display.block);
        this.put("pubPlace", tagInfo);

        tagInfo = new TagInfo("quote", ContentType.all, BelongsTo.BODY, false, false, false, CloseTag.required, Display.block);
        this.put("quote", tagInfo);

        tagInfo = new TagInfo("s", ContentType.all, BelongsTo.BODY, false, false, false, CloseTag.required, Display.block);
        this.put("s", tagInfo);

        tagInfo = new TagInfo("sourceDesc", ContentType.all, BelongsTo.BODY, false, false, false, CloseTag.required, Display.block);
        this.put("sourceDesc", tagInfo);

        tagInfo = new TagInfo("tei.2", ContentType.all, BelongsTo.BODY, false, false, false, CloseTag.required, Display.block);
        this.put("tei.2", tagInfo);

        tagInfo = new TagInfo("teiHeader", ContentType.all, BelongsTo.BODY, false, false, false, CloseTag.required, Display.block);
        this.put("teiHeader", tagInfo);

        tagInfo = new TagInfo("text", ContentType.all, BelongsTo.BODY, false, false, false, CloseTag.required, Display.block);
        this.put("text", tagInfo);

        tagInfo = new TagInfo("textClass", ContentType.all, BelongsTo.BODY, false, false, false, CloseTag.required, Display.block);
        this.put("textClass", tagInfo);

        tagInfo = new TagInfo("title", ContentType.text, BelongsTo.BODY, false, false, false, CloseTag.required, Display.block);
        this.put("title", tagInfo);

        tagInfo = new TagInfo("titleStmt", ContentType.all, BelongsTo.BODY, false, false, false, CloseTag.required, Display.block);
        this.put("titleStmt", tagInfo);

        tagInfo = new TagInfo("w", ContentType.all, BelongsTo.BODY, false, false, false, CloseTag.required, Display.block);
        this.put("w", tagInfo);
    }
    public TagInfo getTagInfo(String tagName) {
        return get(tagName);
    }

    /**
     * Removes tag info with specified name.
     * @param tagName Name of the tag to be removed from the tag provider.
     */
    public void removeTagInfo(String tagName) {
        if (tagName != null) {
            remove(tagName);
        }
    }

    /**
     * Sets new tag info.
     * @param tagInfo tag info to be added to the provider.
     */
    public void addTagInfo(TagInfo tagInfo) {
        if (tagInfo != null) {
            put(tagInfo.getName(), tagInfo);
        }
    }
}
