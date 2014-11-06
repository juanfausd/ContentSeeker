/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.conventus.entity;

/**
 *
 * @author JuanAlejandro
 */
public class Film extends Content {
    
    private String title;
    
    private String genre;
    
    private String size;
    
    private String quality;
    
    private String resolution;
    
    private String frameRate;
    
    private String language;
    
    private String duration;
    
    private String imdbRating;
    
    private String mpr;
    
    private String peersSeeds;

    /**
     * @return the title
     */
    public String getTitle() {
        return title;
    }

    /**
     * @param title the title to set
     */
    public void setTitle(String title) {
        this.title = title;
    }

    /**
     * @return the genre
     */
    public String getGenre() {
        return genre;
    }

    /**
     * @param genre the genre to set
     */
    public void setGenre(String genre) {
        this.genre = genre;
    }

    /**
     * @return the size
     */
    public String getSize() {
        return size;
    }

    /**
     * @param size the size to set
     */
    public void setSize(String size) {
        this.size = size;
    }

    /**
     * @return the quality
     */
    public String getQuality() {
        return quality;
    }

    /**
     * @param quality the quality to set
     */
    public void setQuality(String quality) {
        this.quality = quality;
    }

    /**
     * @return the resolution
     */
    public String getResolution() {
        return resolution;
    }

    /**
     * @param resolution the resolution to set
     */
    public void setResolution(String resolution) {
        this.resolution = resolution;
    }

    /**
     * @return the frameRate
     */
    public String getFrameRate() {
        return frameRate;
    }

    /**
     * @param frameRate the frameRate to set
     */
    public void setFrameRate(String frameRate) {
        this.frameRate = frameRate;
    }

    /**
     * @return the language
     */
    public String getLanguage() {
        return language;
    }

    /**
     * @param language the language to set
     */
    public void setLanguage(String language) {
        this.language = language;
    }

    /**
     * @return the duration
     */
    public String getDuration() {
        return duration;
    }

    /**
     * @param duration the duration to set
     */
    public void setDuration(String duration) {
        this.duration = duration;
    }

    /**
     * @return the imdbRating
     */
    public String getImdbRating() {
        return imdbRating;
    }

    /**
     * @param imdbRating the imdbRating to set
     */
    public void setImdbRating(String imdbRating) {
        this.imdbRating = imdbRating;
    }

    /**
     * @return the mpr
     */
    public String getMpr() {
        return mpr;
    }

    /**
     * @param mpr the mpr to set
     */
    public void setMpr(String mpr) {
        this.mpr = mpr;
    }

    /**
     * @return the peersSeeds
     */
    public String getPeersSeeds() {
        return peersSeeds;
    }

    /**
     * @param peersSeeds the peersSeeds to set
     */
    public void setPeersSeeds(String peersSeeds) {
        this.peersSeeds = peersSeeds;
    }
}
