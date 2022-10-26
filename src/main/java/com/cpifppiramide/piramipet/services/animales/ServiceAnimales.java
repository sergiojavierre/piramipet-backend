package com.cpifppiramide.piramipet.services.animales;

import com.cpifppiramide.piramipet.domain.Animal;
import com.cpifppiramide.piramipet.domain.Persona;

import java.util.List;

public interface ServiceAnimales {

    public void clear();
    public List<Animal> findAll();
    public List<Animal> findAllInfo();
    public void save(Animal animal);

}
