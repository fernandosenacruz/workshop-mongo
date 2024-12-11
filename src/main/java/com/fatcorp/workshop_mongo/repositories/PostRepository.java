package com.fatcorp.workshop_mongo.repositories;

import com.fatcorp.workshop_mongo.domain.Post;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Date;
import java.util.List;

@Repository
public interface PostRepository extends MongoRepository<Post, String> {
    // using query methods
    List<Post> findByTitleContainingIgnoreCase(String title);

    // using @Query
    @Query("{ 'body': { $regex:  ?0 , $options: 'i' } }")
    List<Post> findByBody(String body);

    @Query("{ " +
            "$and: [" +
                "{ createdAt: { $gte:  ?1 } }," +
                "{ createdAt: { $lte:  ?2 } }," +
                "{ $or: [" +
                    "{ 'title': { $regex:  ?0 , $options: 'i' } }," +
                    "{ 'body': { $regex:  ?0 , $options: 'i' } }," +
                    "{ 'comments.content': { $regex:  ?0 , $options: 'i' } }" +
                    "]" +
                "} " +
            "] " +
    "}")
    List<Post> fullSearch(String text, Date minDate, Date maxDate);

}
