package com.cpifppiramide.piramipet.services;

import com.cpifppiramide.piramipet.domain.Animal;

import java.util.ArrayList;
import java.util.List;

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
    public void save(Animal animal) {
        this.animales.add(animal);
    }
}
