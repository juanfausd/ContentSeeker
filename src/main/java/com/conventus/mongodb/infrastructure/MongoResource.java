/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.conventus.mongodb.infrastructure;

import com.mongodb.MongoClient;
import com.mongodb.ServerAddress;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.net.UnknownHostException;
import java.util.Arrays;
import java.util.Properties;

/**
 *
 * @author JuanAlejandro
 */
public enum MongoResource {
    INSTANCE;
    private MongoClient mongoClient;
    private Properties properties;
    
    private MongoResource() {
        
        try
        { 
//            if (properties == null) 
//            {
//                try
//                {
//                    properties = loadProperties(); 
//                } 
//                catch (IOException e) 
//                {
//                    e.printStackTrace(); 
//                } 
//            }

            if (mongoClient == null)
                mongoClient = createClient(); 
        } 
        catch (Exception e) 
        {
            e.printStackTrace();
        }
    }
    
    private static Properties loadProperties() throws IOException 
    {
        Properties properties = new Properties();
        InputStream inputStream = MongoResource.class.getResourceAsStream("/mongodb.properties");
        
        if (inputStream == null)
        {
            throw new FileNotFoundException("not loaded!");
        }
        
        properties.load(inputStream);
        return properties;
    }
    
    private MongoClient createClient()
    {
        try
        {
            String host = "localhost";//properties.getProperty("host");
            Integer primaryPort = 27017;//Integer.valueOf(properties.getProperty("primary-port"));
            
            return new MongoClient(host , primaryPort);
        }
        catch (UnknownHostException uh) 
        {
            uh.printStackTrace(); 
        }
        
        return null;
    }
    
    public MongoClient getClient()
    {
        return mongoClient;
    }
}
