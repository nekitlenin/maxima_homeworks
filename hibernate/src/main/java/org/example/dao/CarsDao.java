package org.example.dao;

import org.example.models.Car;

import java.util.List;

/**
 * Project: hibernate
 *
 * @author nikita
 * Email:  nekitlenin@gmail.com |
 * Create: 13.04.2023 04:00 |
 * Created with IntelliJ IDEA
 */
public interface CarsDao {

    void addCar(String brand, String model, String numberPlate, java.sql.Date dateOfCreate);

    Car selectCarById(long id);

    List<Car> getListOfCarCarsTable();
}
