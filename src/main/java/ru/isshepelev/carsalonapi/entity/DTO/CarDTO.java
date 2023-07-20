package ru.isshepelev.carsalonapi.entity.DTO;

import lombok.Data;
import org.springframework.data.annotation.Id;
import ru.isshepelev.carsalonapi.entity.Characteristics;
import ru.isshepelev.carsalonapi.entity.Quality;

import java.util.Date;
@Data
public class CarDTO {
    private Quality quality;
    private String company;

    private Characteristics characteristics;
}
