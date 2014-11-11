/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.conventus.mongodb.dao;

import com.conventus.entity.IEntity;
import com.conventus.mongodb.converter.IObjectConverter;
import com.mongodb.BasicDBObjectBuilder;
import com.mongodb.DBCollection;
import com.mongodb.DBCursor;
import com.mongodb.DBObject;
import java.util.ArrayList;
import java.util.List;
import org.bson.types.ObjectId;

/**
 *
 * @author JuanAlejandro
 */
public class MongoDBGenericDAO<T> implements IMongoDBGenericDAO<T> 
{
    protected DBCollection col;
    protected IObjectConverter<T> converter;
    
    public MongoDBGenericDAO(IObjectConverter<T> conv) 
    {
        this.converter = conv;
    }
    
    public T create(T obj) 
    {
        DBObject doc = this.converter.toDBObject(obj);
        this.col.insert(doc);
        ObjectId id = (ObjectId) doc.get("_id");
        ((IEntity)obj).setId(id.toString());
        return obj;
    }
    
    public List<T> createAll(List<T> list)
    {
        List<DBObject> insertList = new ArrayList<DBObject>();
        
        for(T obj : list)
        {
            DBObject doc = this.converter.toDBObject(obj);
            insertList.add(doc);
        }
        
        this.col.insert(insertList);
        
        for(Integer i=0; i<list.size(); i++)
        {
            DBObject doc = insertList.get(i);
            T obj = list.get(i);
            ObjectId id = (ObjectId) doc.get("_id");
            ((IEntity)obj).setId(id.toString());
        }
        
        return list;
    }
    
    public void update(T obj) 
    {
        DBObject query = BasicDBObjectBuilder.start()
                .append("_id", new ObjectId(((IEntity)obj).getId())).get();
        this.col.update(query, this.converter.toDBObject(obj));
    }
    
    public List<T> readAll() 
    {
        List<T> data = new ArrayList<T>();
        DBCursor cursor = this.col.find();
        while (cursor.hasNext()) {
            DBObject doc = cursor.next();
            T obj = this.converter.toObject(doc);
            data.add(obj);
        }
        return data;
    }
 
    public void delete(T obj) 
    {
        DBObject query = BasicDBObjectBuilder.start()
                .append("_id", new ObjectId(((IEntity)obj).getId())).get();
        this.col.remove(query);
    }
 
    public T read(T obj) 
    {
        DBObject query = BasicDBObjectBuilder.start()
                .append("_id", new ObjectId(((IEntity)obj).getId())).get();
        DBObject data = this.col.findOne(query);
        return this.converter.toObject(data);
    }
}
