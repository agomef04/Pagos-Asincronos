package com.WebSocket.controller;


import com.WebSocket.model.User;
import com.WebSocket.repository.UserRepository;
import com.WebSocket.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;



import java.util.List;


@RestController
@RequestMapping("api/users")
public class UserController {

    @Autowired
    private UserService userService;

    private final UserRepository userRepository;

    public UserController(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @PostMapping
    public ResponseEntity<User> createUser(@RequestBody User user) {
        // Lógica para crear el usuario y guardar en la base de datos
        System.out.println("usuario postman -> " + user.getEmail());
        User savedUser = userRepository.save(user);
        return ResponseEntity.ok(savedUser);
    }



}
