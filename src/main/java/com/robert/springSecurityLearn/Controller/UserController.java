package com.robert.springSecurityLearn.Controller;

import com.robert.springSecurityLearn.Model.Users;
import com.robert.springSecurityLearn.Service.UsersService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RequestMapping("/user")
@RestController
public class UserController {

    @Autowired
    private UsersService usersService;

    private final BCryptPasswordEncoder encoder = new BCryptPasswordEncoder(13);

    @PostMapping("/register")
    public ResponseEntity<Users> registerUser(@RequestBody Users newUser) {

        newUser.setPassword(encoder.encode(newUser.getPassword()));
        usersService.registerUser(newUser);
        return new ResponseEntity<>(newUser, HttpStatus.CREATED);
    }

    @PostMapping("/login")
    public String login(@RequestBody Users user) {

        return usersService.verifyUser(user);
    }
}
