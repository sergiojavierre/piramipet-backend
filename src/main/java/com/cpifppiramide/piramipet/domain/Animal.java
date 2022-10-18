package com.cpifppiramide.piramipet.domain;

import org.springframework.format.annotation.DateTimeFormat;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Date;

public class Animal {

    private final String DNI, chip, nombre, genero, color;
    private final Date fechaNacimiento;

    public Animal(String DNI, String chip, String nombre, String genero, String color, Date fechaNacimiento) {
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

    public Date getFechaNacimiento() {
        return fechaNacimiento;
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
                '}';
    }
}
