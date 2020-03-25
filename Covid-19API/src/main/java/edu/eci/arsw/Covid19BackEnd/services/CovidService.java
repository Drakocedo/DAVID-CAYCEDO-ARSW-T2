/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.eci.arsw.Covid19BackEnd.services;

import com.mashape.unirest.http.JsonNode;
import edu.eci.arsw.Covid19BackEnd.model.Country;
import edu.eci.arsw.Covid19BackEnd.model.Province;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import org.json.JSONArray;

/**
 *
 * @author david
 */
public interface CovidService {
    /*public String GetCasesByCountry(String name) ; */
    
    public List<Country> GetAllCases() ; 
}
