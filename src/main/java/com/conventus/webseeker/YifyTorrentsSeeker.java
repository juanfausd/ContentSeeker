/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.conventus.webseeker;

import com.conventus.entity.Content;

/**
 *
 * @author JuanAlejandro
 */
public class YifyTorrentsSeeker extends GenericWebsiteSeeker {
    
    public YifyTorrentsSeeker() {
        this.minPage = 1;
        this.maxPage = 239;
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
    
    public Content getContentFromUrl(String url)
    {
        Content content = new Content();
        
        // TODO: Complete
        
        return content;
    }
}
