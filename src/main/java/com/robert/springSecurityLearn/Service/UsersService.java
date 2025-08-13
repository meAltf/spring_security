package com.robert.springSecurityLearn.Service;

import com.robert.springSecurityLearn.Model.Users;
import com.robert.springSecurityLearn.Repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Service;

@Service
public class UsersService {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private AuthenticationManager authManager;

    public void registerUser(Users newUser) {
        Users user = new Users();
        user.setId(newUser.getId());
        user.setUserName(newUser.getUserName());
        user.setPassword(newUser.getPassword());

        userRepository.save(user);
    }

    public String verifyUser(Users user) {
        Authentication authentication = authManager
                .authenticate(new UsernamePasswordAuthenticationToken(user.getUserName(), user.getPassword()));
        if (authentication.isAuthenticated()) return "Success!";
        return "Fail!";
    }
}
