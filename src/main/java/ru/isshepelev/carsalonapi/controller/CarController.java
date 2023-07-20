package ru.isshepelev.carsalonapi.controller;

import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ru.isshepelev.carsalonapi.entity.Car;
import ru.isshepelev.carsalonapi.entity.DTO.CarDTO;
import ru.isshepelev.carsalonapi.service.CarService;

import java.util.List;

@RestController
@RequestMapping("/cars")
public class CarController {
    private final CarService carService;

    public CarController(CarService carService) {
        this.carService = carService;
    }

    @GetMapping("")
    public ResponseEntity<List<Car>> allCars(){
        return ResponseEntity.ok(carService.getAllCar());
    }

    @PostMapping("/create")
    public ResponseEntity<Car> create(@Valid @RequestBody CarDTO carDTO){
        return ResponseEntity.ok(carService.createCar(carDTO));
    }
}
