package ru.isshepelev.carsalonapi.entity.job.DTO;

import lombok.Data;

import java.math.BigDecimal;

@Data
public class JobDTO {
    private String title;
    private BigDecimal payment;
}
