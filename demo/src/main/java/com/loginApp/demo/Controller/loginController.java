package com.loginApp.demo.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
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

    @GetMapping("/users")
    public ResponseEntity<List<Users>> getData(){
       List<Users> data= userService.getData();
       return ResponseEntity.status(200).body(data);
    }

    @GetMapping("/user/{id}")
    public ResponseEntity<Users> getById(@PathVariable String id){
       Users user = userService.getDataById(id);
       if(user == null){
        return ResponseEntity.status(404).body(null);
       }else{
        return  ResponseEntity.status(200).body(user);
       }
    }


    @DeleteMapping("/users")
    public ResponseEntity<String> deleteById(){
       String user = userService.deleteAll();
       if(user.equals("All Users Deleted")){
        return ResponseEntity.status(200).body(user);
       }else{
        return ResponseEntity.status(404).body(null);
       }
    }

    @DeleteMapping("/user/{id}")
    public ResponseEntity<String> deleteById(@PathVariable String id){
       String user = userService.delete(id);
       if(user.equals("User Deleted Sucessfully")){
        return ResponseEntity.status(200).body(user);
       }else{
        return ResponseEntity.status(404).body(null);
       }
    }


    
}
