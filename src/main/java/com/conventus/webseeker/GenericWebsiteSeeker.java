/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.conventus.webseeker;

import com.conventus.entity.Content;
import com.conventus.helpers.HttpHelper;
import java.util.ArrayList;
import java.util.List;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

/**
 *
 * @author JuanAlejandro
 */
public abstract class GenericWebsiteSeeker {
    
    protected Integer minPage;
    protected Integer maxPage;
    protected String sourceName;
    protected String searchPageUrlTemplate;
    protected String contentPageUrlTemplate;
    
    public abstract String getSearchPageUrl(String identifier);
    public abstract String getContentPageUrl(String externalId);
    public abstract String getContentPageUrlPattern();
    public abstract Content getContentFromHtml(String url, String html);
    
    public List<Content> searchContent() throws Exception
    {
        List<Content> result = new ArrayList<Content>();
        String contentPageUrlPattern = this.getContentPageUrlPattern();
        
        for(Integer i = this.minPage; i <= this.maxPage; i++)
        {
            try
            {
                String html = HttpHelper.sendGet(this.getSearchPageUrl(i.toString()));
                Document doc = Jsoup.parse(html);
                Elements links = doc.select(String.format("a[href*={0}]", contentPageUrlPattern));
                
                for (Element link : links)
                {
                    String href = link.attr("href");
                    String contentHtml = HttpHelper.sendGet(href);
                    result.add(this.getContentFromHtml(href, contentHtml));
                }
            }
            catch(Exception ex)
            {
                throw ex;
            }
        }
        
        // TODO: Complete this logic
        
        return result;
    }
}
