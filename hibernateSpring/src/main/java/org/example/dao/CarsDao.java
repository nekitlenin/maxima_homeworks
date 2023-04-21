package org.example.dao;

import org.example.entity.Car;

import java.util.List;

/**
 * Project: hibernateSpring
 *
 * @author nikita
 * Email:  nekitlenin@gmail.com |
 * Create: 13.04.2023 04:00 |
 * Created with IntelliJ IDEA
 */
public interface CarsDao {

    Car selectCarById(long id);

    List<Car> getListOfCarCarsTable();
}
