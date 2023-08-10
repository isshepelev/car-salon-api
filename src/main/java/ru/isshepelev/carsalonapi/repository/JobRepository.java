package ru.isshepelev.carsalonapi.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import ru.isshepelev.carsalonapi.entity.job.Job;

import java.util.Optional;

public interface JobRepository extends MongoRepository<Job, String> {
    Optional<Job> findByTitle(String title);
}
