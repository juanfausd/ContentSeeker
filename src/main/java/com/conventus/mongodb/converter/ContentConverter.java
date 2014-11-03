/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.conventus.mongodb.converter;

import com.conventus.entity.Content;
import com.mongodb.BasicDBObjectBuilder;
import com.mongodb.DBObject;
import org.bson.types.ObjectId;

/**
 *
 * @author JuanAlejandro
 */
public class ContentConverter implements IObjectConverter<Content> {
    
    public DBObject toDBObject(Content content) {
 
        BasicDBObjectBuilder builder = BasicDBObjectBuilder.start()
                .append("name", content.getName())
                .append("source", content.getSource())
                .append("file", content.getFile());
        
        if (content.getId() != null)
            builder = builder.append("_id", new ObjectId(content.getId()));
        
        return builder.get();
    }
    
    public Content toObject(DBObject doc) {
        Content content = new Content();
        content.setName((String) doc.get("name"));
        content.setSource((String) doc.get("source"));
        content.setFile((byte[]) doc.get("file"));
        ObjectId id = (ObjectId) doc.get("_id");
        content.setId(id.toString());
        
        return content;
    }
}
