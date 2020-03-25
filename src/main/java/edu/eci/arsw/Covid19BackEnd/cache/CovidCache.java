/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.eci.arsw.Covid19BackEnd.cache;

import com.mashape.unirest.http.JsonNode;

/**
 *
 * @author david
 */
public interface CovidCache {
   
	/**
	 * 
	 * @param name nombre a guardar
	 * @param json objeto en el que se guardara
	 */
    public boolean isSave(String name);
    public void save (String name, JsonNode json);
    public String load(String name);

}
