/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.conventus.mongodb.converter;

import com.mongodb.DBObject;

/**
 *
 * @author JuanAlejandro
 */
public interface IObjectConverter<T> {
    
    // Converts T object to MongoDB DBObject.
    // Take special note of converting id String to ObjectId.
    public DBObject toDBObject(T obj);
    
    // Converts MongoDB DBObject to T object.
    // Take special note of converting ObjectId to String.
    public T toObject(DBObject doc);
}
