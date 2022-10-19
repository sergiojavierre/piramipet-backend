package com.cpifppiramide.piramipet.domain;

import java.time.LocalDate;

public class Persona {

    private final String DNI, correo, cod_postal, nombre, apellidos;
    private final LocalDate fecha_nac;

    public Persona(String DNI, String correo, String cod_postal, String nombre, String apellidos, LocalDate fecha_nac) {
        this.DNI = DNI;
        this.correo = correo;
        this.cod_postal = cod_postal;
        this.nombre = nombre;
        this.apellidos = apellidos;
        this.fecha_nac = fecha_nac;
    }

    public String getDNI() {
        return DNI;
    }

    public String getCorreo() {
        return correo;
    }

    public String getCod_postal() {
        return cod_postal;
    }

    public String getNombre() {
        return nombre;
    }

    public String getApellidos() {
        return apellidos;
    }

    public LocalDate getFecha_nac() {
        return fecha_nac;
    }

    @Override
    public String toString() {
        return "Persona{" +
                "DNI='" + DNI + '\'' +
                ", correo='" + correo + '\'' +
                ", cod_postal='" + cod_postal + '\'' +
                ", nombre='" + nombre + '\'' +
                ", apellidos='" + apellidos + '\'' +
                ", fecha_nac=" + fecha_nac +
                '}';
    }
}
