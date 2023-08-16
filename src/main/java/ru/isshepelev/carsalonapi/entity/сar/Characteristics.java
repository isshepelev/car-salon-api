package ru.isshepelev.carsalonapi.entity.сar;



import lombok.Data;

import javax.validation.constraints.*;


@Data
public class Characteristics {
    @NotNull(message = "Quality must not be null")
    private Quality quality;

    @Pattern(regexp = "[a-zA-Zа-яА-Я]+", message = "Color should contain only letters")
    @NotBlank(message = "Color must not be blank")
    private String color;

    @NotNull(message = "TypeCar must not be null")
    private TypeCar typeCar;

    @Min(value = 0, message = "Mileage must be greater than or equal to 0")
    @Max(value = 2000000, message = "Mileage should be less than 2000000")
    @NotNull(message = "Mileage must not be null")
    private Integer mileage;
}
