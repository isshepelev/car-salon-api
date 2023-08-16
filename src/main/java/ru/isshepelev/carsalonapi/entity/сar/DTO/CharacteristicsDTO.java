package ru.isshepelev.carsalonapi.entity.сar.DTO;

import lombok.Data;

import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;

@Data
public class CharacteristicsDTO {

    @Min(value = 0, message = "Mileage must be greater than or equal to 0")
    @Max(value = 2000000, message = "Mileage should be less than 2000000")
    @NotNull(message = "Mileage must not be null")
    private Integer mileage;
}
