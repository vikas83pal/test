package com.loginApp.demo.Model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@Document(collection = "logindata")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Users {

    @Id
    private String id;
    private String username;
    private String password;
    private String role;

}
