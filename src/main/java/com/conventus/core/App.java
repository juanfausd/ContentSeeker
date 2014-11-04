package com.conventus.core;

import com.conventus.mongodb.dao.MongoDBContentDAO;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
        Integer minPage = 1;
        Integer maxPage = 239;
        String searchPageUrlTemplate = "https://yts.re/browse-movie/0/All/All/0/latest/{page}";
        String contentPageUrlTemplate = "https://yts.re/movie/{external-id}";
        
        List<String> externalIds = new List<String>();
        
        MongoDBContentDAO dao = new MongoDBContentDAO();
        dao.readAll();
    }
}
