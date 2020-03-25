/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.eci.arsw.Covid19BackEnd.services;

import com.mashape.unirest.http.JsonNode;

/**
 *
 * @author david
 */
public interface CovidService {
    public String GetCasesByCountry(String name) ; 
    
    public String GetAllCases() ; 
}
