package ru.isshepelev.carsalonapi.entity;

import jakarta.validation.constraints.NotNull;
import lombok.Data;

@Data
public class Characteristics {
    @NotNull
    private String model;
    @NotNull
    private String color;
    @NotNull
    private TypeCar typeCar;
}
