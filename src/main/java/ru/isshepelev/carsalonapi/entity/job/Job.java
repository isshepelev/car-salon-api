package ru.isshepelev.carsalonapi.entity.job;


import lombok.Data;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;
import ru.isshepelev.carsalonapi.entity.user.User;

import java.math.BigDecimal;

@Data
@Document
public class Job {
    private String id;
    private String title;
    private BigDecimal payment;

    @DBRef
    private User user;
}
