package com.fatcorp.workshop_mongo.repositories;

import com.fatcorp.workshop_mongo.domain.User;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface UserRepository extends MongoRepository<User, String> {
    List<User> findByIsActive(Boolean isActive);
    List<User> findAll();
    User findByIdAndIsActive(String id, Boolean isActive);
    Optional<User> findById(String id);
}
