package ru.isshepelev.carsalonapi.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;
import ru.isshepelev.carsalonapi.entity.Car;

@Repository
public interface CarRepository extends MongoRepository<Car,String> {}
