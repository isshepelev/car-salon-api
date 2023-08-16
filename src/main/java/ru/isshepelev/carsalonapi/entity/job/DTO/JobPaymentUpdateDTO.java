package ru.isshepelev.carsalonapi.entity.job.DTO;

import lombok.Data;

import javax.validation.constraints.DecimalMin;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Pattern;
import java.math.BigDecimal;

@Data
public class JobPaymentUpdateDTO {
    @NotBlank(message = "Payment cannot be blank")
    @DecimalMin(value = "0.01", message = "Payment must be greater than or equal to 0.01")
    @Pattern(regexp = "^(?!0\\.01)\\d+(\\.\\d{2})?$", message = "Invalid money format payment")
    private BigDecimal payment;
}
