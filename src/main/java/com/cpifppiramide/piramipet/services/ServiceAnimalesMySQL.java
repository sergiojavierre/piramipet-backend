package com.cpifppiramide.piramipet.services;

import com.cpifppiramide.piramipet.db.DBMySQLConnection;
import com.cpifppiramide.piramipet.domain.Animal;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class ServiceAnimalesMySQL implements ServiceAnimales{
    @Override
    public List<Animal> findAll() {
        List<Animal> animales = new ArrayList<>();
        try {
            ResultSet rs = DBMySQLConnection.getConnection().
                    createStatement().executeQuery("select * from animales");
            System.out.println(rs);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return animales;
    }

    @Override
    public void save(Animal animal) {

    }
}
