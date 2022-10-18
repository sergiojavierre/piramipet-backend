package com.cpifppiramide.piramipet.services;

import com.cpifppiramide.piramipet.domain.Animal;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

public interface ServiceAnimales <T>{

    public List<T> findAll();
    public T save(Animal animal);
    public List<T> findByFilter(String color,String genero);
}
