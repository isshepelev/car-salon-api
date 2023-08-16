package ru.isshepelev.carsalonapi.entity.user.DTO;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;
import org.springframework.format.annotation.DateTimeFormat;
import ru.isshepelev.carsalonapi.entity.job.Job;

import javax.validation.constraints.*;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Date;

@Data
public class UserDTO {
    @Pattern(regexp = "^[a-zA-Zа-яА-Я]+$", message = "Name can only contain letters")
    @NotNull(message = "Name cannot be empty")
    private String name;

    @Pattern(regexp = "^[a-zA-Zа-яА-Я]+$", message = "Surname can only contain letters")
    @NotNull(message = "surname cannot be empty")
    private String surname;

    @Min(value = 1, message = "Age must be at least 1 year old")
    @Max(value = 99, message = "Age cannot exceed 99 years")
    @Digits(integer = 2, fraction = 0, message = "Age must be a number with at most 2 digits")
    private int age;

    @DateTimeFormat(pattern = "MM/dd/yyyy")
    @NotNull(message = "BirthDate cannot be empty")
    @JsonFormat(pattern = "MM/dd/yyyy")
    private Date birthDate;
}
