/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.conventus.mongodb.dao;

import com.conventus.entity.Film;
import com.conventus.mongodb.converter.FilmConverter;
import com.conventus.mongodb.infrastructure.MongoResource;

/**
 *
 * @author JuanAlejandro
 */
public class MongoDBFilmDAO extends MongoDBGenericDAO<Film> {
    
    public MongoDBFilmDAO() {
        super(new FilmConverter());
        MongoResource resource = MongoResource.INSTANCE;
        this.col = resource.getClient().getDB("contentseeker").getCollection("contentfilm");
    }
}
