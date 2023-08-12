package ru.isshepelev.carsalonapi.entity.сar.DTO;

import lombok.Data;
import ru.isshepelev.carsalonapi.entity.сar.Characteristics;

import javax.validation.constraints.NotNull;
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
