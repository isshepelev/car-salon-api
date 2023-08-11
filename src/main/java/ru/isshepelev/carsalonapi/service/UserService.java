package ru.isshepelev.carsalonapi.service;

import ru.isshepelev.carsalonapi.entity.user.DTO.UserDTO;
import ru.isshepelev.carsalonapi.entity.user.User;
import ru.isshepelev.carsalonapi.entity.сar.DTO.CarSaleDto;

import java.util.List;

public interface UserService {
    List<User> getAllUser();

    User createUser(UserDTO userDto);

    void update(UserDTO userDTO, String userId);

    void deleteUser(String userId);

    void userBuyCar(String userId, String carId);
    void userSaleCar(String userId, String carId, CarSaleDto carSaleDto);

    void addWork(String user_id, String job_id);

    void deleteJobForUser(String user_id);

}
