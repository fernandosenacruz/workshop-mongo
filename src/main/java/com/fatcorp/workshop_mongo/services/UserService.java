package com.fatcorp.workshop_mongo.services;

import com.fatcorp.workshop_mongo.domain.User;
import com.fatcorp.workshop_mongo.repositories.UserRepository;
import com.fatcorp.workshop_mongo.services.exception.NotFoundException;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserService {

    private final UserRepository userRepository;

    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public List<User> findAll() {
        return userRepository.findByIsActive(true);
    }

    public User findById(String id) {
        User user = userRepository.findByIdAndIsActive(id, true);
        if (user == null) {throw  new NotFoundException("User not found");}
        return user;
    }

    public User insert(User user) {
        return userRepository.save(user);
    }

    private User updateData(User newUser, User user) {
        user.setName(newUser.getName() != null ? newUser.getName() : user.getName());
        user.setEmail(newUser.getEmail() != null ? newUser.getEmail() : user.getEmail());
        return user;
    }

    public void update(User user) {
        User dbUser = userRepository.findByIdAndIsActive(user.getId(), true);
        if (dbUser == null) { throw new NotFoundException("User not found");}
        userRepository.save(updateData(user, dbUser));
    }

    public void activeOrInactive(String id) {
        Optional<User> dbUser = userRepository.findById(id);
        dbUser.get().setIsActive(!dbUser.get().getIsActive());
        userRepository.save(dbUser.get());
    }

    public void delete(String id) {
        Optional<User> user = userRepository.findById(id);
        if (user.get() == null) {throw  new NotFoundException("User not found");}
        userRepository.delete(user.get());
    }
}
