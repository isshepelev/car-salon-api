package ru.isshepelev.carsalonapi.service;

import ru.isshepelev.carsalonapi.entity.сar.Car;
import ru.isshepelev.carsalonapi.entity.сar.DTO.CarDTO;

import java.util.List;

public interface CarService {
    List<Car> getAllCar();

    Car createCar(CarDTO carDTO);

    void update(CarDTO carDTO, String carId);

    void deleteCar(String carId);
}
