package com.cpifppiramide.piramipet.services;

import com.cpifppiramide.piramipet.domain.Animal;
import com.cpifppiramide.piramipet.domain.Persona;

import java.sql.Connection;
import java.util.List;

public class ServiceAnimalesMYSQL implements ServiceAnimales{

    private Connection connection;

    private ServiceAnimalesMYSQL serviceAnimalesMYSQL

    private ServiceAnimalesMYSQL() {

    }

    public static ServiceAnimalesMYSQL getInstance() {

        if ()

    }


    @Override
    public List<Animal> findAll() {
        return null;
    }

    @Override
    public void save(Animal animal) {

    }

    @Override
    public Animal findAnimal(Animal animal) {
        return null;
    }

    @Override
    public Animal findAnimalByDNI(String DNI) {
        return null;
    }

    @Override
    public Animal setDuenoToAnimal(Persona dueno) {
        return null;
    }

    @Override
    public Animal deleteAnimal(Animal animal) {
        return null;
    }


}
