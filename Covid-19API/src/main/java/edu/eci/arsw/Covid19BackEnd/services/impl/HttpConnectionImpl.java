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
import edu.eci.arsw.Covid19BackEnd.model.Province;
import edu.eci.arsw.Covid19BackEnd.services.ConexionService;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.json.JSONArray;
import org.json.JSONObject;
import org.springframework.stereotype.Service;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.reflect.TypeToken;
/**
 *
 * @author david
 */
@Service("HttpConnectionImpl")
public class HttpConnectionImpl implements ConexionService{
    /*
    @Override
    public String GetCasesByCountry(String name) {
        HttpResponse<String> response= null;
        try {
             response = Unirest
                    .get("https://covid-19-coronavirus-statistics.p.rapidapi.com/v1/stats?country="+name)
                    .header("x-rapidapi-host", "covid-19-coronavirus-statistics.p.rapidapi.com")
                    .header("x-rapidapi-key", "34f05cff54msh30ba6f36c91c183p166499jsn555917ef62b8")
                    .asJson();
        } catch (UnirestException ex) {
            Logger.getLogger(HttpConnectionImpl.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        
        return response.getBody();
       
    }
    */

    @Override
    public List<Province> GetAllCases() {
        Gson gson = new GsonBuilder().create();
        List<Province> res = null;
         HttpResponse<JsonNode> response= null;
        try {
             response = Unirest
                    .get("https://covid-19-coronavirus-statistics.p.rapidapi.com/v1/stats")
                    .header("x-rapidapi-host", "covid-19-coronavirus-statistics.p.rapidapi.com")
                    .header("x-rapidapi-key", "34f05cff54msh30ba6f36c91c183p166499jsn555917ef62b8")
                    .asJson();
        } catch (UnirestException ex) {
            Logger.getLogger(HttpConnectionImpl.class.getName()).log(Level.SEVERE, null, ex);
        }
        JSONArray estadisticas = response.getBody().getObject().getJSONObject("data").getJSONArray("covid19Stats");
        //System.out.println("heyeyeyye");
        
        res = gson.fromJson(estadisticas.toString(),new TypeToken<List<Province>>(){}.getType());
        return res ;
    }

}
