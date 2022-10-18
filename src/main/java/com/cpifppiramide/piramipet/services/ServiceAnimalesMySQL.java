package com.cpifppiramide.piramipet.services;

import com.cpifppiramide.piramipet.domain.Animal;
import com.cpifppiramide.piramipet.mysql.ConexionMYSQL;

import java.sql.Date;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

public class ServiceAnimalesMySQL implements ServiceAnimales<Animal> {
    @Override
    public List<Animal> findAll() {
        List<Animal> animales = new ArrayList<>();
        try{
            ResultSet rs = ConexionMYSQL.getInstance().createStatement().executeQuery("SELECT * FROM animales");
            while (rs.next()){
                animales.add(new Animal(rs.getString("DNI"),rs.getString("chip"),rs.getString("nombre"),rs.getString("genero"),rs.getString("color"),rs.getDate("fechaNacimiento")));
            }
            return animales;
        }catch (SQLException e){
            System.err.println(e.getMessage());
        }
        return animales;
    }

    @Override
    public Animal save(Animal animal) {
        try{
            Date date = new Date(animal.getFechaNacimiento().getTime());
            String values = "'"+animal.getDNI()+"',"+"'"+animal.getChip()+"',"+"'"+animal.getNombre()+"',"+"'"+animal.getGenero()+"',"+"'"+animal.getColor()+"','"+date.toLocalDate().format(DateTimeFormatter.ISO_DATE)+"'";
            String query = "INSERT INTO animales VALUES (" + values + ")";
            ConexionMYSQL.getInstance().createStatement().execute(query);
            return animal;
        }catch (SQLException e){
            System.err.println(e.getMessage());
        }
        return null;
    }

    @Override
    public List<Animal> findByFilter(String color, String genero) {
        List<Animal> animales = new ArrayList<>();
        try{
            if(color != null){
                if(genero != null){
                    String query = "SELECT * FROM animales WHERE color = " + "'" + color + "'" + "AND genero = " + "'" + genero + "'";
                    ResultSet rs = ConexionMYSQL.getInstance().createStatement().executeQuery(query);
                    while (rs.next()){
                        animales.add(new Animal(rs.getString("DNI"),rs.getString("chip"),rs.getString("nombre"),rs.getString("genero"),rs.getString("color"),rs.getDate("fechaNacimiento")));
                    }
                    return animales;
                }
                String query = "SELECT * FROM animales WHERE color = " + "'" + color + "'" ;
                ResultSet rs = ConexionMYSQL.getInstance().createStatement().executeQuery(query);
                while (rs.next()){
                    animales.add(new Animal(rs.getString("DNI"),rs.getString("chip"),rs.getString("nombre"),rs.getString("genero"),rs.getString("color"),rs.getDate("fechaNacimiento")));
                }
                return animales;

            }
            if(genero != null){
                String query = "SELECT * FROM animales WHERE genero = " + "'" + genero + "'" ;
                ResultSet rs = ConexionMYSQL.getInstance().createStatement().executeQuery(query);
                while (rs.next()){
                    animales.add(new Animal(rs.getString("DNI"),rs.getString("chip"),rs.getString("nombre"),rs.getString("genero"),rs.getString("color"),rs.getDate("fechaNacimiento")));
                }
                return animales;
            }

            return animales;
        }catch (SQLException e){
            System.err.println(e.getMessage());
        }
        return animales;
    }
}
