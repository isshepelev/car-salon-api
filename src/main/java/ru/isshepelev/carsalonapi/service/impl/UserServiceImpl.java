package ru.isshepelev.carsalonapi.service.impl;

import org.springframework.stereotype.Service;
import org.springframework.web.bind.MethodArgumentNotValidException;
import ru.isshepelev.carsalonapi.entity.job.Job;
import ru.isshepelev.carsalonapi.entity.сar.Car;
import ru.isshepelev.carsalonapi.entity.user.DTO.UserDTO;
import ru.isshepelev.carsalonapi.entity.user.User;
import ru.isshepelev.carsalonapi.entity.сar.Characteristics;
import ru.isshepelev.carsalonapi.entity.сar.DTO.CarSaleDto;
import ru.isshepelev.carsalonapi.entity.сar.Quality;
import ru.isshepelev.carsalonapi.repository.CarRepository;
import ru.isshepelev.carsalonapi.repository.JobRepository;
import ru.isshepelev.carsalonapi.repository.UserRepository;
import ru.isshepelev.carsalonapi.service.UserService;

import java.math.BigDecimal;
import java.util.List;
import java.util.Optional;

@Service
public class UserServiceImpl implements UserService {
    private final UserRepository userRepository;
    private final CarRepository carRepository;
    private final JobRepository jobRepository;

    public UserServiceImpl(UserRepository userRepository, CarRepository carRepository, JobRepository jobRepository) {
        this.userRepository = userRepository;
        this.carRepository = carRepository;
        this.jobRepository = jobRepository;
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


        user.setWallet(BigDecimal.valueOf(0));

        if (user.getCarList() == null) {
            user.setCarCount(0);
        } else {
            user.setCarCount(user.getCarList().size());
        }

        return userRepository.save(user);
    }

    @Override
    public void update(UserDTO userDTO, String userId) {
        Optional<User> userOptional = userRepository.findById(userId);
        if (userOptional.isPresent()) {
            User user = userOptional.get();
            user.setAge(userDTO.getAge());
            user.setName(userDTO.getName());
            user.setSurname(userDTO.getSurname());
            user.setBirthDate(userDTO.getBirthDate());
            userRepository.save(user);
        } else throw new RuntimeException("User not found");
    }

    @Override
    public void deleteUser(String userId) {
        Optional<User> userOptional = userRepository.findById(userId);
        if (userOptional.isPresent()) {
            userRepository.deleteById(userId);
        }else throw new RuntimeException("User not found");
    }

    @Override
    public void userBuyCar(String userId, String carId) {
        Optional<User> userOptional = userRepository.findById(userId);
        Optional<Car> carOptional = carRepository.findById(carId);
        if (userOptional.isPresent() && carOptional.isPresent()) {
            User user = userOptional.get();
            Car car = carOptional.get();

            if (user.getWallet().compareTo(car.getPrice()) >= 0) {

                user.getCarList().add(car);
                user.setWallet(user.getWallet().subtract(car.getPrice()));
                user.setCarCount(user.getCarCount() + 1);

                userRepository.save(user);
                carRepository.deleteById(carId);

            } else throw new RuntimeException("insufficient funds");

        } else throw new RuntimeException("user or car does not exist");
    }

    @Override
    public void userSaleCar(String userId, String carId, CarSaleDto carSaleDto) {
        Optional<User> userOptional = userRepository.findById(userId);
        if (userOptional.isPresent()) {
            User user = userOptional.get();
            for (int i = 0; i < user.getCarCount(); i++) {
                if (carId.equals(user.getCarList().get(i).getSerialNumber())) {
                    Car car = user.getCarList().get(i);

                    Car saleCar = new Car();
                    saleCar.setSerialNumber(car.getSerialNumber());
                    saleCar.setDateRelease(car.getDateRelease());
                    saleCar.setCompany(car.getCompany());
                    saleCar.setModel(car.getModel());
                    saleCar.setPrice(carSaleDto.getPrice());

                    Characteristics characteristics = car.getCharacteristics();
                    characteristics.setMileage(carSaleDto.getCharacteristics().getMileage());
                    characteristics.setQuality(Quality.USED);

                    saleCar.setCharacteristics(characteristics);

                    user.getCarList().remove(i);
                    user.setCarCount(user.getCarCount() - 1);
                    BigDecimal walletUser = user.getWallet();
                    user.setWallet(walletUser.add(carSaleDto.getPrice()));
                    carRepository.save(saleCar);
                    userRepository.save(user);
                    return;
                }
            } throw new RuntimeException("car not found for user");
        } else throw new RuntimeException("user not found");
    }

    @Override
    public void addWork(String user_id, String job_id) {
        Optional<User> userOptional = userRepository.findById(user_id);
        Optional<Job> jobOptional = jobRepository.findById(job_id);
        if (userOptional.isPresent() && jobOptional.isPresent()) {
            User user = userOptional.get();
            Job job = jobOptional.get();
            if (user.getJob() == null) {
                user.setJob(job);
                userRepository.save(user);
            } else throw new RuntimeException("user already has a job");
        } else throw new RuntimeException("job or user not found");
    }

    @Override
    public void deleteJobForUser(String user_id) {
        Optional<User> userOptional = userRepository.findById(user_id);
        if (userOptional.isPresent()) {
            User user = userOptional.get();
            Job job = user.getJob();
            if (job != null) {
                user.setJob(null);
                userRepository.save(user);
            } else throw new RuntimeException("user " + user.getName() + " " + user.getSurname() + " unemployed");
        }else throw new RuntimeException("user not found");
    }
}
