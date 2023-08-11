package ru.isshepelev.carsalonapi.entity.сar.DTO;

import lombok.Data;

import java.math.BigDecimal;

@Data
public class CarSaleDto {
    private BigDecimal price;
    private CharacteristicsDTO Characteristics;
}
