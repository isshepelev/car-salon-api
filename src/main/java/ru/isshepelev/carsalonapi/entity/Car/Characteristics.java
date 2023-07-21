package ru.isshepelev.carsalonapi.entity.Car;

import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.Data;

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
