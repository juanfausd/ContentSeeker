/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.conventus.webseeker;

import com.conventus.entity.Content;
import com.conventus.entity.Film;

/**
 *
 * @author JuanAlejandro
 */
public class YifyTorrentsSeeker extends GenericWebsiteSeeker<Film> {
    
    public YifyTorrentsSeeker() {
        this.minPage = 1;
        this.maxPage = 239;
        this.sourceName = "yify-torrent.org";
        this.searchPageUrlTemplate = "http://www.yify-torrent.org/latest-{page}.html";
        this.contentPageUrlTemplate = "http://www.yify-torrent.org/movie/{external-id}";
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
    
    public Film getContentFromHtml(String url, String html)
    {
        Film content = new Film();
        
        return content;
    }
}
