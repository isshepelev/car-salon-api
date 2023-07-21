package ru.isshepelev.carsalonapi.service;

import org.springframework.http.ResponseEntity;
import ru.isshepelev.carsalonapi.entity.Car.Car;
import ru.isshepelev.carsalonapi.entity.Car.DTO.CarDTO;

import java.util.List;

public interface CarService {
    List<Car> getAllCar();
    Car createCar(CarDTO carDTO);
    void update(CarDTO carDTO, String carId);
    void deleteCar(String carId);
}
