package com.cpifppiramide.piramipet.services;

import com.cpifppiramide.piramipet.domain.Animal;
import com.cpifppiramide.piramipet.domain.Persona;

import java.util.List;

public interface ServiceAnimales {

    List<Animal> findAll();
    void save(Animal animal);
    Animal findAnimal(Animal animal);
    Animal findAnimalByDNI(String DNI);
    Animal setDuenoToAnimal (Persona dueno);
    Animal deleteAnimal (Animal animal);

}
