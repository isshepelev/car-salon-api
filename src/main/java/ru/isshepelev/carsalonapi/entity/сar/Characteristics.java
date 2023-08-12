package ru.isshepelev.carsalonapi.entity.сar;



import lombok.Data;

import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;


@Data
public class Characteristics {

    @NotNull
    private Quality quality;
    @NotNull
    private String color;
    @NotNull
    private TypeCar typeCar;

    @Min(value = 0, message = "Mileage should not be less than 0")
    @Max(value = 5000000, message = "Mileage should not be greater than 5000000")
    private Integer mileage;
}
