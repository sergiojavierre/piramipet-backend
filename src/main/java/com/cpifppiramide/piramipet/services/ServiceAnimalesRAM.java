package com.cpifppiramide.piramipet.services;

import com.cpifppiramide.piramipet.domain.Animal;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class ServiceAnimalesRAM implements ServiceAnimales{

    private final List<Animal> animales;

    public ServiceAnimalesRAM(){
        this.animales = new ArrayList<>();
    }

    @Override
    public List<Animal> findAll() {
        return this.animales;
    }

    @Override
    public Animal save(Animal animal) {
        this.animales.add(animal);
        return animal;
    }
    @Override
    public List<Animal> findByFilter(
            @RequestParam(required = false, name = "color") String color,
            @RequestParam(required = false, name = "genero") String genero) {

        List<Animal> animalesFiltrados = this.animales.stream().filter(animal -> {
            if(color != null){
                if(genero != null)
                    return animal.getGenero().equals(genero) && animal.getColor().equals(color);
                return animal.getColor().equals(color);
            }
            if(genero != null){
                if(color != null)
                    return animal.getColor().equals(color) && animal.getGenero().equals(genero);
                return animal.getGenero().equals(genero);
            }

            return false;
        }).collect(Collectors.toList());
        return animalesFiltrados;
    }



}
