package com.robert.springSecurityLearn.Controller;

import com.robert.springSecurityLearn.Model.Users;
import com.robert.springSecurityLearn.Service.UsersService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RequestMapping("/user")
@RestController
public class UserController {

    @Autowired
    private UsersService usersService;

    @PostMapping("/register")
    public ResponseEntity<Users> registerUser(@RequestBody Users newUser) {
        usersService.registerUser(newUser);
        return new ResponseEntity<>(newUser, HttpStatus.CREATED);
    }
}
