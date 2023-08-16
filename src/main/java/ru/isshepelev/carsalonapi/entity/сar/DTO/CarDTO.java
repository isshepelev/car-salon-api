package ru.isshepelev.carsalonapi.entity.сar.DTO;

import lombok.Data;
import ru.isshepelev.carsalonapi.entity.сar.Characteristics;

import javax.validation.Valid;
import javax.validation.constraints.DecimalMin;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import java.math.BigDecimal;

@Data
public class CarDTO {
    @Pattern(regexp = "[a-zA-Zа-яА-Я0-9]+", message = "Company should contain only letters and digits")
    @NotBlank(message = "company must be filled")
    private String company;

    @NotBlank(message = "model must be filled")
    @Pattern(regexp = "[a-zA-Zа-яА-Я0-9]+", message = "Model should contain only letters and digits")
    private String model;

    @DecimalMin(value = "-1", inclusive = false, message = "Price should be greater than 0")
    private BigDecimal price;

    @NotNull(message = "characteristics must be filled")
    @Valid
    private Characteristics characteristics;
}
