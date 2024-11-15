package com.loginApp.demo.Repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.loginApp.demo.Model.Users;

@Repository
public interface UsersRepository extends MongoRepository<Users, String> {
    Users findByUsername(String user);
}
