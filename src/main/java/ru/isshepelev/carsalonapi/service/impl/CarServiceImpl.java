package ru.isshepelev.carsalonapi.service.impl;

import org.springframework.stereotype.Service;
import ru.isshepelev.carsalonapi.entity.сar.Car;
import ru.isshepelev.carsalonapi.entity.сar.DTO.CarDTO;
import ru.isshepelev.carsalonapi.repository.CarRepository;
import ru.isshepelev.carsalonapi.service.CarService;

import java.util.Date;
import java.util.List;
import java.util.Optional;

@Service
public class CarServiceImpl implements CarService {
    private final CarRepository carRepository;


    public CarServiceImpl(CarRepository carRepository) {
        this.carRepository = carRepository;
    }

    @Override
    public List<Car> getAllCar() {
        return carRepository.findAll();
    }

    @Override
    public Car createCar(CarDTO carDTO) {
        Car car = new Car();
        car.setDateRelease(new Date());
        car.setCompany(carDTO.getCompany());
        car.setModel(carDTO.getModel());
        car.setPrice(carDTO.getPrice());
        if (carDTO.getCharacteristics().getMileage() <= 1000000 && carDTO.getCharacteristics().getMileage() >= 0) {
            car.setCharacteristics(carDTO.getCharacteristics());
            return carRepository.save(car);
        } else {
            throw new IllegalArgumentException("mileage does not match");
        }
    }

    @Override
    public void update(CarDTO carDTO, String carId) {
        Optional<Car> optionalCar = carRepository.findById(carId);
        if (optionalCar.isPresent()) {
            Car car = optionalCar.get();
            car.setPrice(carDTO.getPrice());
            car.setModel(carDTO.getModel());
            car.setCompany(carDTO.getCompany());
            if (carDTO.getCharacteristics().getMileage() <= 1000000 && carDTO.getCharacteristics().getMileage() >= 0) {
                car.setCharacteristics(carDTO.getCharacteristics());
                carRepository.save(car);
            } else {
                throw new IllegalArgumentException("mileage does not match");
            }
        }
    }

    @Override
    public void deleteCar(String carId) {
        carRepository.deleteById(carId);
    }
}
