package ru.isshepelev.carsalonapi.service;

import ru.isshepelev.carsalonapi.entity.car.Car;
import ru.isshepelev.carsalonapi.entity.car.DTO.CarDTO;

import java.util.List;

public interface CarService {
    List<Car> getAllCar();
    Car createCar(CarDTO carDTO);
    void update(CarDTO carDTO, String carId);
    void deleteCar(String carId);
}
