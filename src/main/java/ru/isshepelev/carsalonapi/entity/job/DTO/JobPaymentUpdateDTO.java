package ru.isshepelev.carsalonapi.entity.job.DTO;

import lombok.Data;

import javax.validation.constraints.*;
import java.math.BigDecimal;

@Data
public class JobPaymentUpdateDTO {
    @NotNull(message = "Payment cannot be null")
    @DecimalMin(value = "0.01", message = "Payment must be greater than or equal to 0.01")
    @Digits(integer = 10, fraction = 2, message = "Invalid money format payment")
    private BigDecimal payment;
}
