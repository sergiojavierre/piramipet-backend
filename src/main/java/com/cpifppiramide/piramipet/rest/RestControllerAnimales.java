package com.cpifppiramide.piramipet.rest;


import com.cpifppiramide.piramipet.domain.Animal;
import com.cpifppiramide.piramipet.services.animales.ServiceAnimales;
import com.cpifppiramide.piramipet.services.animales.ServiceAnimalesMySQL;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class RestControllerAnimales {

    private final ServiceAnimales serviceAnimales;

    public RestControllerAnimales(){
        this.serviceAnimales = new ServiceAnimalesMySQL();
    }

    @GetMapping("/animales")
    List<Animal> getAll(){
        return this.serviceAnimales.findAll();
    }

    @GetMapping("/todo")
    List<Animal> getTodo(){
        return this.serviceAnimales.findAllInfo();
    }

}
