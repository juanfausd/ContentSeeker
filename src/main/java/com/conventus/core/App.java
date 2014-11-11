package com.conventus.core;

import com.conventus.entity.Content;
import com.conventus.entity.Film;
import com.conventus.mongodb.dao.MongoDBContentDAO;
import com.conventus.mongodb.dao.MongoDBFilmDAO;
import com.conventus.webseeker.YtsSeeker;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
        YtsSeeker seeker = new YtsSeeker();
        
        try
        {
            List<Content> content = seeker.searchContent();
            MongoDBFilmDAO dao = new MongoDBFilmDAO();
            dao.createAll(content);
        }
        catch(Exception ex)
        {
            Logger.getLogger(YtsSeeker.class.getName()).log(Level.SEVERE, null, ex.getMessage());
        }
    }
}
