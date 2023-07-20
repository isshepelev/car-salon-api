package ru.isshepelev.carsalonapi.entity;

import jakarta.validation.constraints.NotNull;
import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

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
    private Quality quality;

    @NotNull
    private String company;

    @NotNull
    private Characteristics characteristics;
}
