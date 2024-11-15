package com.loginApp.demo.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.loginApp.demo.Model.Users;
import com.loginApp.demo.Respository.UserRespository;


@Service
public class UserService {


    @Autowired
    private UserRespository repo;

    public Users saveUser(Users users) {
        users.setPassword(new BCryptPasswordEncoder().encode(users.getPassword()));
       return repo.save(users);
    }

    public Optional<Users> findByUsername(String username) {
        return repo.findByUsername(username);
    }
    

}
