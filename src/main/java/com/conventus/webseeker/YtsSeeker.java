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
import java.util.logging.Level;
import java.util.logging.Logger;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;

/**
 *
 * @author JuanAlejandro
 */
public class YtsSeeker extends GenericWebsiteSeeker<Film> {
    
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
    
    public Film getContentFromHtml(String url, String html)
    {
        Film content = new Film();
        
        Document doc = Jsoup.parse(html);
        
        Element movieInfo = doc.select("div.movie-info").first();
        
        // Content class properties
        content.setName(movieInfo.select("h1").first().text());
        content.setSource(this.sourceName);
        String torrentUrl = movieInfo.select("a[href$=.torrent]").first().attr("href");
        try {
            content.setFile(FileHelper.getFileFromUrl(torrentUrl));
        } catch (IOException ex) {
            Logger.getLogger(YtsSeeker.class.getName()).log(Level.SEVERE, null, String.format("%s: %s", url, ex.getMessage()));
        }
        content.setExternalId(url.replace(this.getContentPageUrlPattern(), ""));
        // Film class properties
        // Genre
        String genre = movieInfo.select("b").select(":contains(Genre)").parents().first().text().replace("Genre:", "").trim();
        content.setGenre(genre);
        // Size
        String size = movieInfo.select("b").select(":contains(Size)").parents().first().text().replace("Size:", "").trim();
        content.setSize(size);
        // Quality
        String quality = movieInfo.select("b").select(":contains(Quality)").parents().first().text().replace("Quality:", "").trim();
        content.setQuality(quality);
        // Resolution
        String resolution = movieInfo.select("b").select(":contains(Resolution)").parents().first().text().replace("Resolution:", "").trim();
        content.setQuality(resolution);
        // Frame Rate
        String frameRate = movieInfo.select("b").select(":contains(Frame Rate)").parents().first().text().replace("Frame Rate:", "").trim();
        content.setFrameRate(frameRate);
        // Language
        String language = movieInfo.select("b").select(":contains(Language)").parents().first().text().replace("Language:", "").trim();
        content.setLanguage(language);
        // Run Time
        String runTime = movieInfo.select("b").select(":contains(Run Time)").parents().first().text().replace("Run Time:", "").trim();
        content.setDuration(runTime);
        // IMDB Rating
        String imdbRating = movieInfo.select("b").select(":contains(IMDB Rating)").parents().first().text().replace("IMDB Rating:", "").trim();
        content.setImdbRating(imdbRating);
        // MPR
        String mpr = movieInfo.select("b").select(":contains(MPR:)").parents().first().text().replace("MPR:", "").trim();
        content.setMpr(mpr);
        
        return content;
    }
}
