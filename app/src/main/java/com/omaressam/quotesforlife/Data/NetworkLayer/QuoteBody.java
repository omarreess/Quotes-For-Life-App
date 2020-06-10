
package com.omaressam.quotesforlife.Data.NetworkLayer;

import java.util.List;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class QuoteBody {

    @SerializedName("id")
    @Expose
    private Integer id;
    @SerializedName("language_code")
    @Expose
    private String languageCode;
    @SerializedName("content")
    @Expose
    private String content;
    @SerializedName("url")
    @Expose
    private String url;
    @SerializedName("originator")
    @Expose
    private OriginatorQuoteBody originatorQuoteBody;
    @SerializedName("tags")
    @Expose
    private List<String> tags = null;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getLanguageCode() {
        return languageCode;
    }

    public void setLanguageCode(String languageCode) {
        this.languageCode = languageCode;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public OriginatorQuoteBody getOriginatorQuoteBody() {
        return originatorQuoteBody;
    }

    public void setOriginatorQuoteBody(OriginatorQuoteBody originatorQuoteBody) {
        this.originatorQuoteBody = originatorQuoteBody;
    }

    public List<String> getTags() {
        return tags;
    }

    public void setTags(List<String> tags) {
        this.tags = tags;
    }

}
