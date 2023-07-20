package ru.isshepelev.carsalonapi.service;

import org.springframework.stereotype.Service;
import ru.isshepelev.carsalonapi.entity.Car;
import ru.isshepelev.carsalonapi.entity.DTO.CarDTO;
import ru.isshepelev.carsalonapi.repository.CarRepository;

import java.util.Date;
import java.util.List;

@Service
public class CarService {
    private final CarRepository carRepository;

    public CarService(CarRepository carRepository) {
        this.carRepository = carRepository;
    }

    public List<Car> getAllCar() {
        return carRepository.findAll();
    }

    public Car createCar(CarDTO carDTO) {
        Car car = new Car();
        car.setDateRelease(new Date());
        car.setCompany(carDTO.getCompany());
        car.setQuality(carDTO.getQuality());
        car.setCharacteristics(carDTO.getCharacteristics());
        return carRepository.save(car);
    }
}
