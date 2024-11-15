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

    // Register user
    @PostMapping("/register")
    public ResponseEntity<String> register(@RequestBody Users user) {
        // Save user data, with password encoding handled in the service
        String res= userService.saveUser(user);
        if(res.equals("user already exist")){
            return ResponseEntity.status(400).body(res);
        }
        return ResponseEntity.status(200).body(res);
    }
}
