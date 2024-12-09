package com.fatcorp.workshop_mongo.resources;

import com.fatcorp.workshop_mongo.domain.User;
import com.fatcorp.workshop_mongo.services.UserService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(value = "/users")
public class UserResources {
    private final UserService userService;

    public UserResources(UserService userService) {
        this.userService = userService;
    }

    @GetMapping
    public ResponseEntity<List<User>> getUsers() {
        List<User> users = userService.findAll();

        return ResponseEntity.ok().body(users);
    }
}
