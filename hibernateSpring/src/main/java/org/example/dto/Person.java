package org.example.dto;

import lombok.Data;

import javax.persistence.Embeddable;

/**
 * Project: hibernateSpring
 *
 * @author nikita
 * Email:  nekitlenin@gmail.com |
 * Create: 21.04.2023 17:40 |
 * Created with IntelliJ IDEA
 */
@Embeddable
@Data
public class Person {
    private String firstName;
    private String lastName;
    private java.sql.Date dateOfBirth;
}
