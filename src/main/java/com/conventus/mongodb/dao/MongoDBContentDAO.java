/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.conventus.mongodb.dao;

import com.conventus.entity.Content;
import com.conventus.mongodb.converter.ContentConverter;
import com.mongodb.BasicDBObjectBuilder;
import com.mongodb.DBCollection;
import com.mongodb.DBCursor;
import com.mongodb.DBObject;
import com.mongodb.MongoClient;
import java.util.ArrayList;
import java.util.List;
import org.bson.types.ObjectId;

/**
 *
 * @author JuanAlejandro
 */
public class MongoDBContentDAO extends MongoDBGenericDAO<Content> {
    
    public MongoDBContentDAO(MongoClient mongo) {
        super(new ContentConverter());
        this.col = mongo.getDB("contentseeker").getCollection("content");
    }
}
