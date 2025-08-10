package com.robert.springSecurityLearn;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class SpringSecurityLearnApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringSecurityLearnApplication.class, args);
	}

}


// CSRF : Cross Site Request Forgery
// GET : this method allow without token generating, bcz it's default but POST, PUT, DELETE etc.
// these all required username password along with token then only it can give access.
