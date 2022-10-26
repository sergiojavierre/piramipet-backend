package com.cpifppiramide.piramipet.services.personas;

import com.cpifppiramide.piramipet.db.DBMySQLConnection;
import com.cpifppiramide.piramipet.domain.Animal;
import com.cpifppiramide.piramipet.domain.Persona;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class ServicePersonasMySQL implements ServicePersonas{
    @Override
    public void clear() {
        try {
            String sql = "delete from personas";
            DBMySQLConnection.getConnection().createStatement().execute(sql);
        }
        catch (SQLException e){
            System.err.println(e.getMessage());
        }
    }

    @Override
    public List<Persona> findAll() {
        List<Persona> personas = new ArrayList<>();
        try {
            String sql = "select * from personas";
            ResultSet rs = DBMySQLConnection.getConnection().
                    createStatement().executeQuery(sql);
            while (rs.next()){
                String dni = rs.getString("dni");
                String nombre = rs.getString("nombre");
                String fechaNacimiento = rs.getString("fechaNacimiento");
                String apellidos = rs.getString("apellidos");
                Persona persona = new Persona(dni,nombre,apellidos,fechaNacimiento);
                personas.add(persona);
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return personas;
    }

    @Override
    public Persona save(Persona persona) {
        try {
            String sql = "insert into personas (dni, nombre, apellidos, fechaNacimiento) values " +
                    "('" + persona.getDni() + "','" + persona.getNombre() + "','" + persona.getApellidos() + "','" + persona.getFechaNacimiento() + "')";
            DBMySQLConnection.getConnection().createStatement().execute(sql);
        }
        catch (SQLException e){
            System.err.println(e.getMessage());
        }
        return persona;
    }


    @Override
    public Animal adopta(Animal animal) {
        try {
            String sql = "update animales set propietario = '" + animal.getPersona().getDni() + "' where dni = '" + animal.getDNI() + "'";
            DBMySQLConnection.getConnection().createStatement().execute(sql);
        }
        catch (SQLException e){
            System.err.println(e.getMessage());
        }
        return animal;
    }
}
