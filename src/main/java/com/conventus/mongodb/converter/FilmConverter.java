/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.conventus.mongodb.converter;

import com.conventus.entity.Film;
import com.mongodb.BasicDBObjectBuilder;
import com.mongodb.DBObject;
import org.bson.types.ObjectId;

/**
 *
 * @author JuanAlejandro
 */
public class FilmConverter implements IObjectConverter<Film> {
    
    public DBObject toDBObject(Film film) {
 
        BasicDBObjectBuilder builder = BasicDBObjectBuilder.start()
                .append("name", film.getName())
                .append("source", film.getSource())
                .append("file", film.getFile())
                .append("title", film.getTitle())
                .append("genre", film.getGenre())
                .append("size", film.getSize())
                .append("quality", film.getQuality())
                .append("resolution", film.getResolution())
                .append("frameRate", film.getFrameRate())
                .append("language", film.getLanguage())
                .append("duration", film.getDuration())
                .append("imdbRating", film.getImdbRating())
                .append("mpr", film.getMpr())
                .append("peersSeeds", film.getPeersSeeds());
        
        if (film.getId() != null)
            builder = builder.append("_id", new ObjectId(film.getId()));
        
        return builder.get();
    }
    
    public Film toObject(DBObject doc) {
        Film content = new Film();
        content.setName((String) doc.get("name"));
        content.setSource((String) doc.get("source"));
        content.setFile((byte[]) doc.get("file"));
        content.setTitle((String) doc.get("title"));
        content.setGenre((String) doc.get("genre"));
        content.setSize((String) doc.get("size"));
        content.setQuality((String) doc.get("quality"));
        content.setResolution((String) doc.get("resolution"));
        content.setFrameRate((String) doc.get("frameRate"));
        content.setLanguage((String) doc.get("language"));
        content.setDuration((String) doc.get("duration"));
        content.setImdbRating((String) doc.get("imdbRating"));
        content.setMpr((String) doc.get("mpr"));
        content.setPeersSeeds((String) doc.get("peersSeeds"));
        ObjectId id = (ObjectId) doc.get("_id");
        content.setId(id.toString());
        
        return content;
    }
}
