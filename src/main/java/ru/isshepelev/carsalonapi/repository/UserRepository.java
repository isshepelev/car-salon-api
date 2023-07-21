package ru.isshepelev.carsalonapi.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;
import ru.isshepelev.carsalonapi.entity.user.User;

@Repository
public interface UserRepository extends MongoRepository<User, String> {}
