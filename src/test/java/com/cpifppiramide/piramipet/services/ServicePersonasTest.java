package com.cpifppiramide.piramipet.services;
import com.cpifppiramide.piramipet.domain.Animal;
import com.cpifppiramide.piramipet.domain.Persona;
import com.cpifppiramide.piramipet.services.animales.ServiceAnimales;
import com.cpifppiramide.piramipet.services.animales.ServiceAnimalesMySQL;
import com.cpifppiramide.piramipet.services.personas.ServicePersonas;
import com.cpifppiramide.piramipet.services.personas.ServicePersonasMySQL;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest
@TestInstance(TestInstance.Lifecycle.PER_CLASS)
public class ServicePersonasTest {

    final ServiceAnimales serviceAnimales;
    final ServicePersonas servicePersonas;

    public ServicePersonasTest(){
        this.serviceAnimales = new ServiceAnimalesMySQL();
        this.servicePersonas = new ServicePersonasMySQL();
    }

    @BeforeAll
    public void preloadTests(){
        Animal animal = new Animal("123","abc","perrito", "macho", "castaño", "2021-01-12");
        this.serviceAnimales.save(animal);
        Persona persona = new Persona("123","sergio","javierre","1991-01-01");
        this.servicePersonas.save(persona);
    }

    @AfterAll
    public void clear(){
        this.serviceAnimales.clear();
        this.servicePersonas.clear();
    }

    @Test
    public void adopta(){
        List<Persona> personas = this.servicePersonas.findAll();
        List<Animal> animales = this.serviceAnimales.findAll();
        Persona persona = personas.get(0);
        Animal animal = animales.get(0);
        animal.setPersona(persona);
        this.servicePersonas.adopta(animal);
        List<Animal> animalesAllInfo = this.serviceAnimales.findAllInfo();
        Animal adoptado = animalesAllInfo.get(0);
        assertEquals(adoptado.getPersona().getDni(), persona.getDni());
    }



}
