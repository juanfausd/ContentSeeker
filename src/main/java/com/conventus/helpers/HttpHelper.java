/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.conventus.helpers;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

/**
 *
 * @author JuanAlejandro
 */
public class HttpHelper {
    
    public static String sendGet(String url) throws Exception
    {
        URL obj = new URL(url);
	HttpURLConnection connection = (HttpURLConnection) obj.openConnection();
        
        // optional default is GET
	connection.setRequestMethod("GET");
        
        //add request header
	connection.setRequestProperty("User-Agent", "Mozilla/5.0");
        
        BufferedReader in = new BufferedReader(new InputStreamReader(connection.getInputStream()));
	String inputLine;
	StringBuilder response = new StringBuilder();
 
	while ((inputLine = in.readLine()) != null)
        {
            response.append(inputLine);
	}
        
	in.close();
        
        return response.toString();
    }
}
