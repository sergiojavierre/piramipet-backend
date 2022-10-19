package com.cpifppiramide.piramipet.services;

import com.cpifppiramide.piramipet.domain.Animal;
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
        assertEquals(1,animalesAlmacenados.size());
    }

    @Test
    public void delete() {
        Animal animal = new Animal("2", "abcde", "Alba", "Hembra", "Marrón", new Date());
        service.save(animal);
        service.delete("Alba");
        List<Animal> animalesAlmacenados = service.findAll();
        assertEquals(0, animalesAlmacenados.size());
    }

}
