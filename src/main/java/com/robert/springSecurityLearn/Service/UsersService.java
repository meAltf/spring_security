package com.robert.springSecurityLearn.Service;

import com.robert.springSecurityLearn.Model.Users;
import com.robert.springSecurityLearn.Repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UsersService {

    @Autowired
    private UserRepository userRepository;

    public void registerUser(Users newUser) {
        Users user = new Users();
        user.setId(newUser.getId());
        user.setUserName(newUser.getUserName());
        user.setPassword(newUser.getPassword());

        userRepository.save(user);
    }
}
