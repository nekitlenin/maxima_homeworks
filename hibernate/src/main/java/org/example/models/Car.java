package org.example.models;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.sql.Date;

/**
 * Project: hibernate
 *
 * @author nikita
 * Email:  nekitlenin@gmail.com |
 * Create: 13.04.2023 02:54 |
 * Created with IntelliJ IDEA
 */
@Entity
@Table(name = "cars")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Car {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column
    private String brand;

    @Column
    private String model;

    @Column(name = "number_plate")
    private String numberPlate;

    @Column(name = "date_of_create")
    private java.sql.Date dateOfCreate;

    public Car(String brand, String model, String numberPlate, Date dateOfCreate) {
        this.brand = brand;
        this.model = model;
        this.numberPlate = numberPlate;
        this.dateOfCreate = dateOfCreate;
    }
}
