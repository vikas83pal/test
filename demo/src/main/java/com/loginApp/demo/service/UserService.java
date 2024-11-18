package com.loginApp.demo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.loginApp.demo.Model.Users;
import com.loginApp.demo.Repository.UsersRepository;

@Service
public class UserService {

    @Autowired
    private PasswordEncoder passwordEncoder; // Make sure PasswordEncoder is injected

    @Autowired
    private UsersRepository usersRepository;

    public String saveUser(Users user) {

        if (usersRepository.findByUsername(user.getUsername()) != null) {
            return "User Already Exist";
        }

        // Encrypt the password before saving it
        user.setPassword(passwordEncoder.encode(user.getPassword()));
        usersRepository.save(user);
        return "User Registered Successfully";
    }

    public List<Users> getData() {
        return usersRepository.findAll();

    }

    public Users getDataById(String id) {
        return usersRepository.findById(id).orElse(null);

    }

    public String delete(String id) {
        if (usersRepository.existsById(id)) {
            usersRepository.deleteById(id);
            return "User Deleted Sucessfully";
        }
        return "User Not Found";

    }

    public String deleteAll() {
        try {
            usersRepository.deleteAll();
            return "All Users Deleted";
        } catch (Exception e) {
            return "Error Deleting All Users";
        }
    }

    public String authenticateUser(Users user) {
        Users existingUser = usersRepository.findByUsername(user.getUsername());
        if (existingUser == null) {

            return "Invalid Credentials";
        }
        if (passwordEncoder.matches(user.getPassword(), existingUser.getPassword())) {
            return "Logged in";
        }
        return "Invalid Credentials";
    }

}
