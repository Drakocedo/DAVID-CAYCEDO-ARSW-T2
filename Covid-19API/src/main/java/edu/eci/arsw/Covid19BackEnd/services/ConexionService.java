/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.eci.arsw.Covid19BackEnd.services;

import java.io.IOException;

/**
 *
 * @author david
 */
public interface ConexionService {
    
    public String CovidByCountry(String name) throws IOException; 
}
