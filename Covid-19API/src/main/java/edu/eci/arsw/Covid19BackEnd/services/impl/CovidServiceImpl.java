/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.eci.arsw.Covid19BackEnd.services.impl;

import com.mashape.unirest.http.JsonNode;
import edu.eci.arsw.Covid19BackEnd.model.Country;
import edu.eci.arsw.Covid19BackEnd.model.Province;
import edu.eci.arsw.Covid19BackEnd.services.ConexionService;
import edu.eci.arsw.Covid19BackEnd.services.CovidService;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import org.json.JSONArray;
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
    /*
    @Override
    public Str GetCasesByCountry(String name){
        return hcs.GetCasesByCountry(name);
    }
    */
    @Override
    public List<Country> GetAllCases(){
        List<Province> provincias = hcs.GetAllCases();
        HashMap<String, ArrayList<Integer>> countries = new HashMap<String, ArrayList<Integer>>();
        for (Province pro:provincias){
            if (countries.containsKey(pro.getCountry())){
                ArrayList<Integer> aux = new ArrayList<Integer>();
                ArrayList<Integer> temporal = countries.get(pro.getCountry());
                countries.remove(pro.getCountry());
                aux.add(temporal.get(0)+pro.getDeaths());aux.add(temporal.get(1)+pro.getConfirmed());aux.add(temporal.get(2)+pro.getRecovered());
                countries.put(pro.getCountry(),aux); 
            }
            else{
                ArrayList<Integer> temporal = new ArrayList<Integer>();
                temporal.add(pro.getDeaths());temporal.add(pro.getConfirmed());temporal.add(pro.getRecovered());
                countries.put(pro.getCountry(),temporal);
            }
            
        }
        List<Country> objetos = new ArrayList<Country>();
        for (HashMap.Entry<String, ArrayList<Integer>> entry : countries.entrySet()) {
            objetos.add(new Country(entry.getKey(),entry.getValue().get(0),entry.getValue().get(1),entry.getValue().get(2)));
        }

        return objetos;
    }
}

                        
                        
                        
                        

        
        