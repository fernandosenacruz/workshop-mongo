package com.fatcorp.workshop_mongo.services;

import com.fatcorp.workshop_mongo.domain.Post;
import com.fatcorp.workshop_mongo.repositories.PostRepository;
import com.fatcorp.workshop_mongo.services.exception.NotFoundException;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class PostService {

    private final PostRepository postRepository;

    public PostService(PostRepository postRepository) {
        this.postRepository = postRepository;
    }

    public Post findById(String id) {
        return postRepository.findById(id)
                .orElseThrow(() -> new NotFoundException("Post not found"));
    }

    public List<Post> findByTitle(String title) {
        List<Post> posts = postRepository.findByTitleContainingIgnoreCase(title);
        if (posts.isEmpty()) throw new NotFoundException("Any post not found");
        return posts;
    }
}
