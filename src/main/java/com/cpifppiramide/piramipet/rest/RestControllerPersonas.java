package com.cpifppiramide.piramipet.rest;


import com.cpifppiramide.piramipet.domain.Animal;
import com.cpifppiramide.piramipet.domain.Persona;
import com.cpifppiramide.piramipet.services.personas.ServicePersonas;
import com.cpifppiramide.piramipet.services.personas.ServicePersonasMySQL;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class RestControllerPersonas {

    private final ServicePersonas servicePersonas;

    public RestControllerPersonas(){
        this.servicePersonas = new ServicePersonasMySQL();
    }

    @PostMapping(path = "/personas",  consumes = MediaType.APPLICATION_JSON_VALUE)
    Persona registra(@RequestBody Persona persona){
        return this.servicePersonas.save(persona);
    }

    @PutMapping(path = "/personas/adopta", consumes = MediaType.APPLICATION_JSON_VALUE)
    Animal adopta(@RequestBody Animal animal){
        return this.servicePersonas.adopta(animal);
    }

}
