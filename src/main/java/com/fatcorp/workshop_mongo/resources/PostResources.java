package com.fatcorp.workshop_mongo.resources;

import com.fatcorp.workshop_mongo.domain.Post;
import com.fatcorp.workshop_mongo.services.PostService;
import com.fatcorp.workshop_mongo.utils.URL;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/posts")
public class PostResources {
    private final PostService postService;

    public PostResources(PostService postService) {
        this.postService = postService;
    }

    @GetMapping(value = "/{id}")
    public ResponseEntity<Post> getPost(@PathVariable String id) {
        Post post = postService.findById(id);
        return ResponseEntity.ok().body(post);
    }

    @GetMapping(value = "/title")
    public ResponseEntity<List<Post>> getPostByTitle(
            @RequestParam(value = "text", defaultValue = "")
            String text
    ) {
        text = URL.decodeParam(text);
        List<Post> posts = postService.findByTitle(text);
        return ResponseEntity.ok().body(posts);
    }

    @GetMapping(value = "/body")
    public ResponseEntity<List<Post>> getPostByBody(
            @RequestParam(value = "text", defaultValue = "")
            String text
    ) {
        text = URL.decodeParam(text);
        List<Post> posts = postService.findByBody(text);
        return ResponseEntity.ok().body(posts);
    }
}

