package com.cpifppiramide.piramipet.services;

import com.cpifppiramide.piramipet.domain.Animal;
import com.cpifppiramide.piramipet.services.animales.ServiceAnimales;
import com.cpifppiramide.piramipet.services.animales.ServiceAnimalesMySQL;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest
@TestInstance(TestInstance.Lifecycle.PER_CLASS)
public class ServiceAnimalesTest {

    final ServiceAnimales service;

    public ServiceAnimalesTest(){
        this.service = new ServiceAnimalesMySQL();
    }

    @BeforeAll
    public void preloadTests(){
        Animal animal = new Animal("123","abc","perrito", "macho", "castaño", "2021-01-12");
        this.service.save(animal);
    }

    @AfterAll
    public void clear(){
        this.service.clear();
    }

    @Test
    public void saveAndfindAll(){
        List<Animal> animalesAlmacenados = service.findAll();
        assertEquals(1,animalesAlmacenados.size());
    }

}
