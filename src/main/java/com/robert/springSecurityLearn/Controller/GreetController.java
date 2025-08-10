package com.robert.springSecurityLearn.Controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class GreetController {

    @GetMapping("/")
    public String Greet() {
        return "Hello from another world!";
    }

}
