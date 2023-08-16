package ru.isshepelev.carsalonapi.entity.сar.DTO;

import lombok.Data;

import javax.validation.Valid;
import javax.validation.constraints.DecimalMin;
import javax.validation.constraints.NotNull;
import java.math.BigDecimal;

@Data
public class CarSaleDto {
    @DecimalMin(value = "0", inclusive = false, message = "Price should be greater than 0")
    private BigDecimal price;

    @NotNull(message = "Characteristics must be filled")
    @Valid
    private CharacteristicsDTO characteristics;
}
