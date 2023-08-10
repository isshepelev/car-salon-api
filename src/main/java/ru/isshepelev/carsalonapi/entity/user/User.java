package ru.isshepelev.carsalonapi.entity.user;


import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;
import ru.isshepelev.carsalonapi.entity.job.Job;
import ru.isshepelev.carsalonapi.entity.сar.Car;

import java.math.BigDecimal;
import java.time.LocalDateTime;
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
    private BigDecimal wallet;
    private int carCount;

    private List<Car> carList = new ArrayList<>();

    @DBRef
    private Job job;

    @JsonIgnore
    private LocalDateTime startTime;
    @JsonIgnore
    private LocalDateTime endTime;
}
