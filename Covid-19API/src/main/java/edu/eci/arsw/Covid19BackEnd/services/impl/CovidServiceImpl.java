/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.eci.arsw.Covid19BackEnd.services.impl;

import com.mashape.unirest.http.JsonNode;
import edu.eci.arsw.Covid19BackEnd.services.ConexionService;
import edu.eci.arsw.Covid19BackEnd.services.CovidService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

/**
 *
 * @author david
 */
@Service("CovidServicesImpl")
public class CovidServiceImpl implements CovidService{
    
    
    @Autowired
    @Qualifier("HttpConnectionImpl")
    HttpConnectionImpl hcs;
    @Override
    public String GetCasesByCountry(String name){
        return hcs.GetCasesByCountry(name);
    }
    
    @Override
    public String GetAllCases(){
        return hcs.GetAllCases();
    }
}
