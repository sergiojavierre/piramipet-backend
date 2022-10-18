package com.cpifppiramide.piramipet.domain;

import java.util.Date;

public class Animal {

    private final String DNI, chip, nombre, genero, color;
    private final Date fechaNacimiento;
    private Persona dueno;

    public Animal(String DNI, String chip, String nombre, String genero, String color, Date fechaNacimiento) {
        this.DNI = DNI;
        this.chip = chip;
        this.nombre = nombre;
        this.genero = genero;
        this.color = color;
        this.fechaNacimiento = fechaNacimiento;
        this.dueno = dueno;
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

    public Date getFechaNacimiento() {
        return fechaNacimiento;
    }

    public void setDueno(Persona dueno) {
        this.dueno = dueno;
    }

    @Override
    public String toString() {
        return "Animal{" +
                "DNI='" + DNI + '\'' +
                ", chip='" + chip + '\'' +
                ", nombre='" + nombre + '\'' +
                ", genero='" + genero + '\'' +
                ", color='" + color + '\'' +
                ", fechaNacimiento=" + fechaNacimiento +
                ", dueno=" + dueno +
                '}';
    }
}
