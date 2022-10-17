package com.cpifppiramide.piramipet.services;

import com.cpifppiramide.piramipet.domain.Animal;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

public interface ServiceAnimales {

    public List<Animal> findAll();
    public Animal save(Animal animal);
    public List<Animal> findByFilter(String color,String genero);
}
