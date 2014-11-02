/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.conventus.entity;

/**
 * This class represents a content retrieved from a
 * specific source.
 * 
 * @author JuanAlejandro
 */
public class Content implements IEntity {
    
    private String id;
    
    private String name;
    
    private String source;
    
    private byte[] file;
    
    public String getId() {
        return id;
    }
    
    public void setId(String id) {
        this.id = id;
    }
    
    public String getName() {
        return name;
    }
    
    public void setName(String name) {
        this.name = name;
    }
    
    public String getSource() {
        return source;
    }
    
    public void setSource(String source) {
        this.source = source;
    }
    
    public byte[] getFile() {
        return file;
    }
    
    public void setFile(byte[] file) {
        this.file = file;
    }
}
