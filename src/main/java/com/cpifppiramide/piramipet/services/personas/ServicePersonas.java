package com.cpifppiramide.piramipet.services.personas;

import com.cpifppiramide.piramipet.domain.Animal;
import com.cpifppiramide.piramipet.domain.Persona;

import java.util.List;

public interface ServicePersonas {

    public void clear();

    public List<Persona> findAll();
    public Persona save(Persona persona);
    public Animal adopta(Animal animal);

}
