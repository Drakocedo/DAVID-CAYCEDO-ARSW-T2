/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.eci.arsw.Covid19BackEnd.controllers;

import edu.eci.arsw.Covid19BackEnd.services.impl.CovidServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author david
 */
@RestController
@RequestMapping(value = "/covidfinder")
public class CovidController {
    @Autowired
    @Qualifier("CovidServicesImpl")
    CovidServiceImpl cs;
    
/*
    @RequestMapping(path = "/{name}", method = RequestMethod.GET)
    public ResponseEntity<?> getCasesByCountry(@PathVariable(name = "name") String nombre) {
        try {
           
            return new ResponseEntity<>(cs.GetCasesByCountry(nombre),HttpStatus.ACCEPTED);

        } catch (Exception ex) {
            return new ResponseEntity<>("400 bad request", HttpStatus.NOT_FOUND);
        }
    }
 */   
    @RequestMapping( method = RequestMethod.GET)
    public ResponseEntity<?> getAllCases() {
        
        try {
           
            return new ResponseEntity<>(cs.GetAllCases(),HttpStatus.ACCEPTED);

        } catch (Exception ex) {
            return new ResponseEntity<>("400 bad request", HttpStatus.NOT_FOUND);
        }
    }
}
