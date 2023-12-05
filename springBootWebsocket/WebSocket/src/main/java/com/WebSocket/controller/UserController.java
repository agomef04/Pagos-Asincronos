package com.WebSocket.controller;


import com.WebSocket.model.BankAccount;
import com.WebSocket.model.User;
import com.WebSocket.service.BankAccountService;
import com.WebSocket.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping("/users")
public class UserController {

    @Autowired
    private UserService userService;

    @Autowired
    private BankAccountService bankAccountService;


    @RequestMapping("/newUser")
    public ResponseEntity<?> createUser(@RequestBody User user) {
        // comprobar si existe usuario
        //System.out.println("METODO POST USUARIO -> " + user);
        if(userService.userExists(user)) {
            return ResponseEntity.badRequest().body("El usuario ya existe");
        }

        User createdUser = userService.createUser(user);
        bankAccountService.create(createdUser);

        return new ResponseEntity<>(createdUser, HttpStatus.OK);
    }


    @RequestMapping("/login")
    @GetMapping
    public ResponseEntity<?> loginUser(@RequestParam  String email, @RequestParam String password) {
        //System.out.println("Email ->" + email + ", Password -> " + password.toString() );
        User userLogin = userService.loginUser(email,password);
        if(userLogin == null) {
            return ResponseEntity.badRequest().body("El usuario no existe");
        }

        return new ResponseEntity<>(userLogin, HttpStatus.OK);
    }



}
