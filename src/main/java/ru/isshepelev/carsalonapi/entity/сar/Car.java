package ru.isshepelev.carsalonapi.entity.сar;

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import javax.validation.constraints.NotNull;
import java.math.BigDecimal;
import java.util.Date;

@Data
@Document
public class Car {
    @Id
    @NotNull
    private String serialNumber;

    @NotNull
    private Date dateRelease;

    @NotNull
    private String company;

    @NotNull
    private String model;

    @NotNull
    private BigDecimal price;

    @NotNull
    private Characteristics characteristics;
}
