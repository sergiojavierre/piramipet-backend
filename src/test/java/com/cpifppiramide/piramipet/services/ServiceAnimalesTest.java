package com.cpifppiramide.piramipet.services;

import com.cpifppiramide.piramipet.domain.Animal;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Date;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest
public class ServiceAnimalesTest {

    final ServiceAnimales service;

    public ServiceAnimalesTest(){
        this.service = new ServiceAnimalesRAM();
    }


    @Test
    public void saveAndfindAll(){
        Animal animal = new Animal("1", "abc", "Sergio", "Macho", "Marrón", new Date());
        service.save(animal);
        List<Animal> animalesAlmacenados = service.findAll();
        assertEquals(animal.getDNI(),animalesAlmacenados.get(0).getDNI());
    }

    @Test
    public void saveAndfindByFilter(){
        service.save(new Animal("2", "def", "Akira", "Hembra", "Blanco", new Date()));
        service.save(new Animal("3", "ghi", "Freya", "Hembra", "Blanco", new Date()));
        service.save(new Animal("3", "jkl", "Sira", "Hembra", "Marrón", new Date()));
        List<Animal> animalesFiltrados = service.findByFilter("Blanco","Hembra");
        assertEquals(2,animalesFiltrados.size());
    }

    @Test
    public void saveAndfindByColor(){
        service.save(new Animal("2", "def", "Akira", "Hembra", "Blanco", new Date()));
        service.save(new Animal("3", "ghi", "Freya", "Hembra", "Blanco", new Date()));
        service.save(new Animal("3", "jkl", "Sira", "Hembra", "Marrón", new Date()));
        List<Animal> animalesFiltrados = service.findByFilter("Blanco",null);
        assertEquals(2,animalesFiltrados.size());
    }

    @Test
    public void saveAndfindByGenero(){
        service.save(new Animal("2", "def", "Akira", "Hembra", "Blanco", new Date()));
        service.save(new Animal("3", "ghi", "Freya", "Hembra", "Blanco", new Date()));
        service.save(new Animal("3", "jkl", "Sira", "Hembra", "Marrón", new Date()));
        List<Animal> animalesFiltrados = service.findByFilter(null,"Hembra");
        assertEquals(3,animalesFiltrados.size());
    }
}
