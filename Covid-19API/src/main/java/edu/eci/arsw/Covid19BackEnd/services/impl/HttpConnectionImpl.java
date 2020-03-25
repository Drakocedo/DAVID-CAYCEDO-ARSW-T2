/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.eci.arsw.Covid19BackEnd.services.impl;



import com.mashape.unirest.http.HttpResponse;
import com.mashape.unirest.http.JsonNode;
import com.mashape.unirest.http.Unirest;
import com.mashape.unirest.http.exceptions.UnirestException;
import edu.eci.arsw.Covid19BackEnd.services.ConexionService;
import java.io.InputStreamReader;
import java.io.BufferedReader;
import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.springframework.stereotype.Service;

/**
 *
 * @author david
 */
@Service("HttpConnectionImpl")
public class HttpConnectionImpl implements ConexionService{
    @Override
    public String GetCasesByCountry(String name) {
        HttpResponse<String> response= null;
        try {
             response = Unirest
                    .get("https://covid-19-coronavirus-statistics.p.rapidapi.com/v1/stats?country="+name)
                    .header("x-rapidapi-host", "covid-19-coronavirus-statistics.p.rapidapi.com")
                    .header("x-rapidapi-key", "34f05cff54msh30ba6f36c91c183p166499jsn555917ef62b8")
                    .asString();
        } catch (UnirestException ex) {
            Logger.getLogger(HttpConnectionImpl.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        
        return response.getBody();
       
    }
    

    @Override
    public String GetAllCases() {
         HttpResponse<String> response= null;
        try {
             response = Unirest
                    .get("https://covid-19-coronavirus-statistics.p.rapidapi.com/v1/stats")
                    .header("x-rapidapi-host", "covid-19-coronavirus-statistics.p.rapidapi.com")
                    .header("x-rapidapi-key", "34f05cff54msh30ba6f36c91c183p166499jsn555917ef62b8")
                    .asString();
        } catch (UnirestException ex) {
            Logger.getLogger(HttpConnectionImpl.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        
        return response.getBody();
    }
}
