package com.fatcorp.workshop_mongo.services;

import com.fatcorp.workshop_mongo.domain.User;
import com.fatcorp.workshop_mongo.repositories.UserRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {

    private final UserRepository userRepository;

    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public List<User> findAll() {
        return userRepository.findAll();
    }
}
