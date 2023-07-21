package ru.isshepelev.carsalonapi.entity.user.DTO;

import lombok.Data;

import java.util.Date;

@Data
public class UserDTO {
    private String name;
    private String surname;
    private int age;
    private Date birthDate;
    private String job;
}
