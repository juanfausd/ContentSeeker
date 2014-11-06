/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.conventus.webseeker;

import com.conventus.entity.Content;
import com.conventus.entity.Film;
import com.conventus.helpers.FileHelper;
import java.io.IOException;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;

/**
 *
 * @author JuanAlejandro
 */
public class YtsSeeker extends GenericWebsiteSeeker {
    
    public YtsSeeker() {
        this.minPage = 1;
        this.maxPage = 239;
        this.sourceName = "yts.re";
        this.searchPageUrlTemplate = "https://yts.re/browse-movie/0/All/All/0/latest/{page}";
        this.contentPageUrlTemplate = "https://yts.re/movie/{external-id}";
    }
    
    public String getSearchPageUrl(String identifier)
    {
        return this.searchPageUrlTemplate.replace("{page}", identifier);
    }
    
    public String getContentPageUrl(String externalId)
    {
        return this.contentPageUrlTemplate.replace("{external-id}", externalId);
    }
    
    public String getContentPageUrlPattern()
    {
        return this.contentPageUrlTemplate.replace("{external-id}", "");
    }
    
    public Content getContentFromHtml(String url, String html) throws IOException
    {
        Film content = new Film();
        
        Document doc = Jsoup.parse(html);
        
        Element movieInfo = doc.select("div.movie-info").first();
        
        // Content class properties
        content.setName(movieInfo.select("h1").first().val());
        content.setSource("");
        String torrentUrl = movieInfo.select("a[href$=.torrent]").first().val();
        content.setFile(FileHelper.getFileFromUrl(torrentUrl));
        content.setExternalId(url.replace(this.getContentPageUrlPattern(), ""));
        // Film class properties
        
        return content;
    }
}
