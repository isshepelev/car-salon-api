package ru.isshepelev.carsalonapi.service;

import ru.isshepelev.carsalonapi.entity.user.DTO.UserDTO;
import ru.isshepelev.carsalonapi.entity.user.User;

import java.util.List;

public interface UserService {
    List<User> getAllUser();
    User createUser(UserDTO userDto);
    void update(UserDTO userDTO, String userId);
    void deleteUser(String userId);
    void userBuyCar(String userId, String carId);

}
