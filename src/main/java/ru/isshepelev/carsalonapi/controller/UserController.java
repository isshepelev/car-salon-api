package ru.isshepelev.carsalonapi.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ru.isshepelev.carsalonapi.entity.user.DTO.UserDTO;
import ru.isshepelev.carsalonapi.entity.user.User;
import ru.isshepelev.carsalonapi.entity.сar.DTO.CarSaleDto;
import ru.isshepelev.carsalonapi.service.UserService;
import ru.isshepelev.carsalonapi.service.impl.UserServiceImpl;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/users")
public class UserController {
    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping("")
    public ResponseEntity<List<User>> allUsers() {
        return ResponseEntity.ok(userService.getAllUser());
    }

    @PostMapping("/create")
    public ResponseEntity<User> createUser(@RequestBody @Valid UserDTO userDTO) {
        return ResponseEntity.ok(userService.createUser(userDTO));
    }

    @PutMapping("/update/{user_id}")
    public ResponseEntity<String> update(@RequestBody @Valid UserDTO userDTO,
                                       @PathVariable String user_id) {
        userService.update(userDTO, user_id);
        return ResponseEntity.ok("successfully");
    }

    @DeleteMapping("/delete/{user_id}")
    public ResponseEntity<String> delete(@PathVariable String user_id) {
        userService.deleteUser(user_id);
        return ResponseEntity.ok("successfully");
    }


    @PostMapping("/buy-car/{user_id}/{car_id}")
    public ResponseEntity<String> userBuyCar(@PathVariable String user_id,
                                           @PathVariable String car_id) {
        userService.userBuyCar(user_id, car_id);
        return ResponseEntity.ok("successfully");
    }


    @PostMapping("/sale-car/{user_id}/{car_id}")
    public ResponseEntity<String> userSaleCar(@PathVariable String user_id,
                                            @PathVariable String car_id,
                                            @RequestBody @Valid CarSaleDto carSaleDto){
        userService.userSaleCar(user_id,car_id,carSaleDto);
        return ResponseEntity.ok("successfully");
    }

    @PostMapping("/add-work/{user_id}/{job_id}")
    public ResponseEntity<String> addJobToUser(@PathVariable String user_id,
                                             @PathVariable String job_id) {
        userService.addWork(user_id, job_id);
        return ResponseEntity.ok("successfully");
    }

    @PostMapping("/delete-work/{user_id}")
    public ResponseEntity<String> deleteJobToUser(@PathVariable String user_id) {
        userService.deleteJobForUser(user_id);
        return ResponseEntity.ok("successfully");
    }

}
