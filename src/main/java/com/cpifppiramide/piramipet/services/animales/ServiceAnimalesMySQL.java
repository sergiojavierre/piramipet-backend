package com.cpifppiramide.piramipet.services.animales;

import com.cpifppiramide.piramipet.db.DBMySQLConnection;
import com.cpifppiramide.piramipet.domain.Animal;
import com.cpifppiramide.piramipet.domain.Persona;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class ServiceAnimalesMySQL implements ServiceAnimales{

    @Override
    public void clear() {
        try{
            DBMySQLConnection.getConnection().createStatement().execute("delete from animales");
        }
        catch (SQLException e){
            System.err.println(e.getMessage());
        }
    }

    @Override
    public List<Animal> findAll() {
        List<Animal> animales = new ArrayList<>();
        try {
            ResultSet rs = DBMySQLConnection.getConnection().
                    createStatement().executeQuery("select * from animales");
            while (rs.next()){
                String dni = rs.getString("dni");
                String nombre = rs.getString("nombre");
                String fechaNacimiento = rs.getString("fechaNacimiento");
                String chip = rs.getString("chip");
                String genero = rs.getString("genero");
                String color = rs.getString("color");
                Animal animal = new Animal(dni,chip,nombre,genero,color,fechaNacimiento);
                animales.add(animal);
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return animales;
    }

    @Override
    public List<Animal> findAllInfo() {
        List<Animal> animales = new ArrayList<>();
        try {
            String sql = "" +
                    "select " +
                    "a.*, a.dni as dniAnimal, a.nombre as nombreAnimal, a.fechaNacimiento as fechaNacimientoAnimal, " +
                    "p.*, p.dni as dniPersona, p.nombre as NombrePersona, p.fechaNacimiento as fechaNacimientoPersona " +
                    "from animales a " +
                    "join personas p on p.dni = a.propietario";
            ResultSet rs = DBMySQLConnection.getConnection().
                    createStatement().executeQuery(sql);
            while (rs.next()){
                //objeto animal
                String dniAnimal = rs.getString("dniAnimal");
                String nombreAnimal = rs.getString("nombreAnimal");
                String fechaNacimientoAnimal = rs.getString("fechaNacimientoAnimal");
                String chip = rs.getString("chip");
                String genero = rs.getString("genero");
                String color = rs.getString("color");
                Animal animal = new Animal(dniAnimal,chip,nombreAnimal,genero,color,fechaNacimientoAnimal);
                //...
                //objeto persona
                String dniPersona = rs.getString("dniPersona");
                String nombrePersona = rs.getString("nombrePersona");
                String fechaNacimientoPersona = rs.getString("fechaNacimientoPersona");
                String apellidos = rs.getString("apellidos");
                Persona persona = new Persona(dniPersona,nombrePersona,apellidos,fechaNacimientoPersona);
                animal.setPersona(persona);
                animales.add(animal);
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return animales;
    }

    @Override
    public void save(Animal animal) {
        try {
            String sql = "insert into animales (dni, chip, genero, fechaNacimiento, nombre, color) values " +
                    "('" + animal.getDNI() + "','" + animal.getChip() + "','" + animal.getGenero() + "'," +
                    "'" + animal.getFechaNacimiento() + "','" + animal.getNombre() + "','" + animal.getColor() + "')";
            DBMySQLConnection.getConnection().createStatement().execute(sql);
        }
        catch (SQLException e){
            System.err.println(e.getMessage());
        }
    }

}
