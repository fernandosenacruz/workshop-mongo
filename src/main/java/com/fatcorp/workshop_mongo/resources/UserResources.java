package com.fatcorp.workshop_mongo.resources;

import com.fatcorp.workshop_mongo.domain.User;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping(value = "/users")
public class UserResources {

    @GetMapping
    public ResponseEntity<List<User>> getUsers() {
        List<User> users = new ArrayList<User>();

        User test01 = new User("1", "Ximira", "ximira@gmail.com");

        users.add(test01);

        return ResponseEntity.ok().body(users);
    }
}
