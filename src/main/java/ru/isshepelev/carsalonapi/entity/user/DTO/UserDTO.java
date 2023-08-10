package ru.isshepelev.carsalonapi.entity.user.DTO;

import lombok.Data;
import ru.isshepelev.carsalonapi.entity.job.Job;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Date;

@Data
public class UserDTO {
    private String name;
    private String surname;
    private int age;
    private Date birthDate;
//    private Job job;
}
