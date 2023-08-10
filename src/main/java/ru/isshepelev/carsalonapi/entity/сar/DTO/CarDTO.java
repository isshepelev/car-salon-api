package ru.isshepelev.carsalonapi.entity.сar.DTO;

import jakarta.validation.constraints.NotNull;
import lombok.Data;
import ru.isshepelev.carsalonapi.entity.сar.Characteristics;

import java.math.BigDecimal;

@Data
public class CarDTO {
    @NotNull
    private String company;

    @NotNull
    private String model;

    @NotNull
    private BigDecimal price;

    @NotNull
    private Characteristics characteristics;
}
