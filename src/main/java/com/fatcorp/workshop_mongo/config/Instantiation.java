package com.fatcorp.workshop_mongo.config;

import com.fatcorp.workshop_mongo.domain.User;
import com.fatcorp.workshop_mongo.repositories.UserRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;

import java.util.Arrays;

@Configuration
public class Instantiation implements CommandLineRunner {
    private final UserRepository userRepository;

    public Instantiation(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public void run(String... args) throws Exception {
        userRepository.deleteAll();

        User user01 = new User(null, "Ximira", "ximira@gmail.com", true);
        User user02 = new User(null, "Xibil", "xibil@gmail.com", true);

        userRepository.saveAll(Arrays.asList(user01, user02));
    }
}
