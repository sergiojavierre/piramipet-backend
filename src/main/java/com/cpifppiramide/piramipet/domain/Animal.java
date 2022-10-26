package com.cpifppiramide.piramipet.domain;

import java.util.Date;

public class Animal {

    private final String DNI, chip, nombre, genero, color, fechaNacimiento;
    private Persona persona;

    public Animal(String DNI, String chip, String nombre, String genero, String color, String fechaNacimiento) {
        this.DNI = DNI;
        this.chip = chip;
        this.nombre = nombre;
        this.genero = genero;
        this.color = color;
        this.fechaNacimiento = fechaNacimiento;
    }

    public String getDNI() {
        return DNI;
    }

    public String getChip() {
        return chip;
    }

    public String getNombre() {
        return nombre;
    }

    public String getGenero() {
        return genero;
    }

    public String getColor() {
        return color;
    }

    public String getFechaNacimiento() {
        return fechaNacimiento;
    }

    public Persona getPersona() {
        return persona;
    }

    public void setPersona(Persona persona) {
        this.persona = persona;
    }
}
