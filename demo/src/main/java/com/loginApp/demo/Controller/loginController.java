package com.loginApp.demo.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.loginApp.demo.Model.Users;
import com.loginApp.demo.service.UserService;

@RestController
public class loginController {

    @Autowired
    private UserService userService;


    @PostMapping("/register")
    public ResponseEntity<String> register(@RequestBody Users users){
        userService.saveUser(users);
        return ResponseEntity.ok("Registered");
    }





}
