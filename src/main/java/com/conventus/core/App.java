package com.conventus.core;

import com.conventus.mongodb.dao.MongoDBContentDAO;
import com.conventus.mongodb.infrastructure.MongoResource;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
        MongoDBContentDAO dao = new MongoDBContentDAO();
        dao.readAll();
    }
}
