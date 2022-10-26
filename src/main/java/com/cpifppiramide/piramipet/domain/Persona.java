package com.cpifppiramide.piramipet.domain;

public class Persona {

    private final String dni, nombre, apellidos, fechaNacimiento;

    public Persona(String dni, String nombre, String apellidos, String fechaNacimiento) {
        this.dni = dni;
        this.nombre = nombre;
        this.apellidos = apellidos;
        this.fechaNacimiento = fechaNacimiento;
    }

    public String getDni() {
        return dni;
    }

    public String getNombre() {
        return nombre;
    }

    public String getApellidos() {
        return apellidos;
    }

    public String getFechaNacimiento() {
        return fechaNacimiento;
    }
}
