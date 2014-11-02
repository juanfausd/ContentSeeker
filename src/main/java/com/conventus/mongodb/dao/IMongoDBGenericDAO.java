/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.conventus.mongodb.dao;

import com.conventus.mongodb.converter.IObjectConverter;

/**
 *
 * @author JuanAlejandro
 */
public interface IMongoDBGenericDAO<T> {
    
    public T create(T obj);
    public void update(T obj);
}
