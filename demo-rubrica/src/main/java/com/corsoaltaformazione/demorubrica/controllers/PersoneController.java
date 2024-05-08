// Package declaration for the controller classes
package com.corsoaltaformazione.demorubrica.controllers;

// Import statements for necessary classes
import java.util.List;

import com.corsoaltaformazione.demorubrica.models.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import com.corsoaltaformazione.demorubrica.models.Persona;
import com.corsoaltaformazione.demorubrica.services.RubricaService;

// Request mapping for the "/rubrica" endpoint and defining a RestController
@RequestMapping("/rubrica")
@RestController
public class PersoneController {

    // Autowiring the RubricaService to access its methods
    @Autowired
    RubricaService rubricaService;

    // GET mapping to retrieve all personas
    @GetMapping("")
    public @ResponseBody List<Persona> getAll(){
        // Calling the findAll() method of the RubricaService to retrieve all personas
        return rubricaService.findAll();
    }

    // GET mapping to retrieve a specific persona by id
    @GetMapping("/{email}")
    public Persona getById(@PathVariable String email){
        // Calling the getPersona() method of the RubricaService to retrieve a persona by email
        return rubricaService.getPersona(email);
    }

    // POST mapping to save a new persona
    @PostMapping("")
    public @ResponseBody Persona save(@RequestBody Persona persona){
        // Calling the addPersona() method of the RubricaService to save a new persona
        rubricaService.addPersona(persona);
        return persona;
    }

    // DELETE mapping to delete a persona by email
    @DeleteMapping("/{email}")
    public ResponseEntity<Boolean> delete(@PathVariable String email){
        // Calling the deletePersona() method of the RubricaService to delete a persona by email
        rubricaService.deletePersona(email);
        return new ResponseEntity<>(true, HttpStatus.OK);
    }

    // PUT mapping to update a persona's tags
    @PutMapping("/{email}")
    public ResponseEntity<Boolean> update(@RequestBody TagRequest sag){
        // Retrieving the persona by email using the getPersona() method of the RubricaService
        Persona persona = rubricaService.getPersona(sag.getEmail());
        // Adding tags to the persona using the addTag() method of the RubricaService
        rubricaService.addTag(sag.getEmail(), persona, sag.getTags());
        return new ResponseEntity<>(true, HttpStatus.OK);
    }

}