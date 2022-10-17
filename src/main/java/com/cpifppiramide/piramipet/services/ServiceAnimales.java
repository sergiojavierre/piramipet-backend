package com.cpifppiramide.piramipet.services;

import com.cpifppiramide.piramipet.domain.Animal;

import java.util.List;

public interface ServiceAnimales {

    public List<Animal> findAll();
    public void save(Animal animal);

}
