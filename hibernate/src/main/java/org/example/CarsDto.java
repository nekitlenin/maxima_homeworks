package org.example;

import lombok.AllArgsConstructor;
import lombok.Data;

/**
 * Project: hibernate
 *
 * @author nikita
 * Email:  nekitlenin@gmail.com |
 * Create: 11.04.2023 02:29 |
 * Created with IntelliJ IDEA
 */
@Data
@AllArgsConstructor
public class CarsDto {
    private int id;
    private String brand;
    private String model;
    private String numberPlate;
    private java.sql.Date dateOfCreate;
}
