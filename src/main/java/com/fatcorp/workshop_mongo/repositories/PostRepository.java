package com.fatcorp.workshop_mongo.repositories;

import com.fatcorp.workshop_mongo.domain.Post;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PostRepository extends MongoRepository<Post, String> {
    // using query methods
    List<Post> findByTitleContainingIgnoreCase(String title);

    // using @Query
    @Query("{ 'body': { $regex:  ?0 , $options: 'i' } }")
    List<Post> findByBody(String body);
}
