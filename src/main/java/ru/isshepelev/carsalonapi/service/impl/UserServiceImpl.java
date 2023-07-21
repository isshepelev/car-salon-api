package ru.isshepelev.carsalonapi.service.impl;

import org.springframework.stereotype.Service;
import ru.isshepelev.carsalonapi.entity.Car.Car;
import ru.isshepelev.carsalonapi.entity.user.DTO.UserDTO;
import ru.isshepelev.carsalonapi.entity.user.User;
import ru.isshepelev.carsalonapi.repository.CarRepository;
import ru.isshepelev.carsalonapi.repository.UserRepository;
import ru.isshepelev.carsalonapi.service.UserService;

import java.math.BigDecimal;
import java.util.List;
import java.util.Optional;

@Service
public class UserServiceImpl implements UserService {
    private final UserRepository userRepository;
    private final CarRepository carRepository;

    public UserServiceImpl(UserRepository userRepository, CarRepository carRepository) {
        this.userRepository = userRepository;
        this.carRepository = carRepository;
    }

    @Override
    public List<User> getAllUser() {
        return userRepository.findAll();
    }

    @Override
    public User createUser(UserDTO userDto) {
        User user = new User();
        user.setAge(userDto.getAge());
        user.setName(userDto.getName());
        user.setSurname(userDto.getSurname());
        user.setBirthDate(userDto.getBirthDate());
        user.setJob(userDto.getJob());


        user.setWallet(BigDecimal.valueOf(0));

        if (user.getCarList() == null){
            user.setCarCount(0);
        }else {user.setCarCount(user.getCarList().size());}

        return userRepository.save(user);
    }

    @Override
    public void update(UserDTO userDTO, String userId) {
        Optional<User> userOptional = userRepository.findById(userId);
        if (userOptional.isPresent()){
            User user = userOptional.get();
            user.setAge(userDTO.getAge());
            user.setName(userDTO.getName());
            user.setSurname(userDTO.getSurname());
            user.setBirthDate(userDTO.getBirthDate());
            user.setJob(userDTO.getJob());
            userRepository.save(user);
        }
    }

    @Override
    public void deleteUser(String userId) {
        userRepository.deleteById(userId);
    }

    @Override
    public void userBuyCar(String userId, String carId) {
        Optional<User> userOptional = userRepository.findById(userId);
        Optional<Car> carOptional = carRepository.findById(carId);
        if (userOptional.isPresent() && carOptional.isPresent()){
            User user = userOptional.get();
            Car car = carOptional.get();

            if (user.getWallet().compareTo(car.getPrice()) >=0 ){

                user.getCarList().add(car);
                user.setWallet(user.getWallet().subtract(car.getPrice()));
                user.setCarCount(user.getCarCount() + 1);

                userRepository.save(user);
                carRepository.deleteById(carId);

            }else throw new RuntimeException("insufficient funds");

        }else  throw new RuntimeException("user or machine does not exist");
    }
}
