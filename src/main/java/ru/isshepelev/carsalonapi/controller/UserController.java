package ru.isshepelev.carsalonapi.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ru.isshepelev.carsalonapi.entity.user.DTO.UserDTO;
import ru.isshepelev.carsalonapi.entity.user.User;
import ru.isshepelev.carsalonapi.service.UserService;
import ru.isshepelev.carsalonapi.service.impl.UserServiceImpl;

import java.util.List;

@RestController
@RequestMapping("/users")
public class UserController {
    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping("")
    public ResponseEntity<List<User>> allUsers(){
        return ResponseEntity.ok(userService.getAllUser());
    }

    @PostMapping("/create")
    public ResponseEntity<User> createUser(@RequestBody UserDTO userDTO){
        return ResponseEntity.ok(userService.createUser(userDTO));
    }

    @PutMapping("/update/{user_id}")
    public ResponseEntity<Void> update(@RequestBody UserDTO userDTO,
                                       @PathVariable String user_id){
        userService.update(userDTO,user_id);
        return ResponseEntity.noContent().build();
    }

    @DeleteMapping("/delete/{user_id}")
    public ResponseEntity<Void> delete(@PathVariable String user_id){
        userService.deleteUser(user_id);
        return ResponseEntity.noContent().build();
    }


    @PostMapping("/buy-car/{user_id}/{car_id}")
    public ResponseEntity<Void> userBuyCar(@PathVariable String user_id,
                                           @PathVariable String car_id){
        userService.userBuyCar(user_id,car_id);
        return ResponseEntity.noContent().build();
    }

}
