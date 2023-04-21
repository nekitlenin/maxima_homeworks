package org.example.dto;

import lombok.Data;

import javax.persistence.Embeddable;

/**
 * Project: hibernateSpring
 *
 * @author nikita
 * Email:  nekitlenin@gmail.com |
 * Create: 21.04.2023 19:38 |
 * Created with IntelliJ IDEA
 */
@Embeddable
@Data
public class Documents {
    private String numberPlate;
    private int vehiclePassport;
    private java.sql.Date dateOfCreateVehiclePassport;
    private int vehicleRegistration;
    private java.sql.Date dateOfCreateVehicleRegistration;
}
