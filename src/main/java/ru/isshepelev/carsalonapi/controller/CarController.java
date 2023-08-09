package ru.isshepelev.carsalonapi.controller;

import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ru.isshepelev.carsalonapi.entity.car.Car;
import ru.isshepelev.carsalonapi.entity.car.DTO.CarDTO;
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
    @PutMapping("/update/{car_id}")
    public ResponseEntity<Void> updateCar(@RequestBody CarDTO carDTO,
                      @PathVariable String car_id){
        carService.update(carDTO,car_id);
        return ResponseEntity.noContent().build();
    }

    @DeleteMapping("/delete/{car_id}")
    public ResponseEntity<Void> delete(@PathVariable String car_id){
        carService.deleteCar(car_id);
        return ResponseEntity.noContent().build();
    }
}
