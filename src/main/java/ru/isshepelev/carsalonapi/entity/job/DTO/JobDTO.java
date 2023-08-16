package ru.isshepelev.carsalonapi.entity.job.DTO;

import lombok.Data;

import javax.validation.constraints.*;
import java.math.BigDecimal;

@Data
public class JobDTO {
    @NotBlank(message = "Title cannot be blank")
    @Pattern(regexp = "^[a-zA-Zа-яА-Я0-9]{1,20}$", message = "Invalid input format title")
    private String title;

    @NotNull(message = "Payment cannot be null")
    @DecimalMin(value = "0.01", message = "Payment must be greater than or equal to 0.01")
    @Digits(integer = 10, fraction = 2, message = "Invalid money format payment")
    private BigDecimal payment;
}
