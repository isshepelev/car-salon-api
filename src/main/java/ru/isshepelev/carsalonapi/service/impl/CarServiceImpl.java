package ru.isshepelev.carsalonapi.service.impl;

import org.springframework.stereotype.Service;
import ru.isshepelev.carsalonapi.entity.Car.Car;
import ru.isshepelev.carsalonapi.entity.Car.DTO.CarDTO;
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
    public  List<Car> getAllCar() {
        return carRepository.findAll();
    }
    @Override
    public Car createCar(CarDTO carDTO) {
        Car car = new Car();
        car.setDateRelease(new Date());
        car.setCompany(carDTO.getCompany());
        car.setModel(carDTO.getModel());
        car.setPrice(carDTO.getPrice());
        car.setCharacteristics(carDTO.getCharacteristics());
        return carRepository.save(car);
    }
    @Override
    public void update(CarDTO carDTO, String carId){
        Optional<Car> optionalCar = carRepository.findById(carId);
        if (optionalCar.isPresent()){
            Car car = optionalCar.get();
            car.setPrice(carDTO.getPrice());
            car.setCharacteristics(carDTO.getCharacteristics());
            car.setModel(carDTO.getModel());
            car.setCompany(carDTO.getCompany());
            carRepository.save(car);
        }
    }
    @Override
    public void deleteCar(String carId) {
        carRepository.deleteById(carId);
    }
}
