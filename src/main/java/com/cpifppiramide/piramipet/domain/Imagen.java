package com.cpifppiramide.piramipet.domain;

public class Imagen {

    private final String nombre_origen, nombre_editado, animal_DNI;

    public Imagen(String nombre_origen, String nombre_editado, String animal_dni) {
        this.nombre_origen = nombre_origen;
        this.nombre_editado = nombre_editado;
        animal_DNI = animal_dni;
    }
}
