package ru.isshepelev.carsalonapi.entity.user;


import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import ru.isshepelev.carsalonapi.entity.Car.Car;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Document
@Data
public class User {
    @Id
    private String personalId;

    private String name;
    private String surname;
    private int age;
    private Date birthDate;
    private String job;
    private BigDecimal wallet;
    private int carCount;

    private List<Car> carList = new ArrayList<>();
}
