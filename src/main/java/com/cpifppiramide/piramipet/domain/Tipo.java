package com.cpifppiramide.piramipet.domain;

public class Tipo {
    private final String animal_dni, nombre, raza;
    private final Double tamano;

    public Tipo(String animal_dni, String nombre, String raza, Double tamano) {
        this.animal_dni = animal_dni;
        this.nombre = nombre;
        this.raza = raza;
        this.tamano = tamano;
    }

    public String getAnimal_dni() {
        return animal_dni;
    }

    public String getNombre() {
        return nombre;
    }

    public String getRaza() {
        return raza;
    }

    public Double getTamano() {
        return tamano;
    }

    @Override
    public String toString() {
        return "Tipo{" +
                "animal_dni='" + animal_dni + '\'' +
                ", nombre='" + nombre + '\'' +
                ", raza='" + raza + '\'' +
                ", tamano=" + tamano +
                '}';
    }
}
