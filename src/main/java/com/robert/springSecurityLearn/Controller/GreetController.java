package com.robert.springSecurityLearn.Controller;

import com.sun.net.httpserver.HttpServer;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class GreetController {

    @GetMapping("/")
    public String Greet(HttpServletRequest httpServletRequest) {
        return "Hello from another world! " + httpServletRequest.getSession().getId();
    }

}
