package org.example.entity;

import lombok.Data;
import org.example.dto.Documents;
import org.example.dto.Person;

import javax.persistence.*;

/**
 * Project: hibernateSpring
 *
 * @author nikita
 * Email:  nekitlenin@gmail.com |
 * Create: 18.04.2023 23:21 |
 * Created with IntelliJ IDEA
 */
@Entity
@Data
public class Car {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String brand;
    private String model;
    private int serial;
    private java.sql.Date dateOfCreate;

    @Embedded
    private Person person;

    @Embedded
    private Documents documents;

}
