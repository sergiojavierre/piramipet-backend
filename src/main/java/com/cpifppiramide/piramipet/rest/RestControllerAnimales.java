package com.cpifppiramide.piramipet.rest;


import com.cpifppiramide.piramipet.domain.Animal;
import com.cpifppiramide.piramipet.services.ServiceAnimales;
import com.cpifppiramide.piramipet.services.ServiceAnimalesMySQL;
import com.cpifppiramide.piramipet.services.ServiceAnimalesRAM;
import io.swagger.v3.oas.annotations.parameters.RequestBody;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class RestControllerAnimales {

    private final ServiceAnimales<Animal> serviceAnimales ;

    public RestControllerAnimales(){
        this.serviceAnimales = new ServiceAnimalesMySQL() ;
    }

    @GetMapping("/animales")
    List<Animal> getAll(){
        return this.serviceAnimales.findAll();
    }

    @PostMapping("/animales")
    Animal save(Animal animal){
        return this.serviceAnimales.save(animal);
    }
    @GetMapping("/animales/filter")
    List<Animal> findByFilter(
            @RequestParam(required = false,name = "color") String color,
            @RequestParam(required = false,name = "genero") String genero){
       return this.serviceAnimales.findByFilter(color,genero);
    }


}
