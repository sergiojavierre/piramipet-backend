package com.cpifppiramide.piramipet.rest;


import com.cpifppiramide.piramipet.domain.Animal;
import com.cpifppiramide.piramipet.services.ServiceAnimales;
import com.cpifppiramide.piramipet.services.ServiceAnimalesRAM;
import io.swagger.v3.oas.annotations.parameters.RequestBody;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class RestControllerAnimales {

    private final ServiceAnimales serviceAnimales;

    public RestControllerAnimales(){
        this.serviceAnimales = new ServiceAnimalesRAM();
    }

    @GetMapping("/animales")
    List<Animal> getAll(){
        return this.serviceAnimales.findAll();
    }


}
