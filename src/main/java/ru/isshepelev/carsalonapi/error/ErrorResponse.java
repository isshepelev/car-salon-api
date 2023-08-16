package ru.isshepelev.carsalonapi.error;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class ErrorResponse {
    private String error;
    private int status;
    private String timestamp;
}
