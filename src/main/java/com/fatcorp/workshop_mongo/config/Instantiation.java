package com.fatcorp.workshop_mongo.config;

import com.fatcorp.workshop_mongo.domain.Post;
import com.fatcorp.workshop_mongo.domain.User;
import com.fatcorp.workshop_mongo.dto.AuthorDTO;
import com.fatcorp.workshop_mongo.dto.CommentDTO;
import com.fatcorp.workshop_mongo.repositories.PostRepository;
import com.fatcorp.workshop_mongo.repositories.UserRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;

import java.text.SimpleDateFormat;
import java.util.List;
import java.util.TimeZone;

import static java.util.Arrays.asList;

@Configuration
public class Instantiation implements CommandLineRunner {
    private final UserRepository userRepository;
    private final PostRepository postRepository;

    public Instantiation(UserRepository userRepository, PostRepository postRepository) {
        this.userRepository = userRepository;
        this.postRepository = postRepository;
    }

    @Override
    public void run(String... args) throws Exception {
        userRepository.deleteAll();
        postRepository.deleteAll();

        User user01 = new User(null, "Ximira", "ximira@gmail.com", true);
        User user02 = new User(null, "Xibil", "xibil@gmail.com", true);

        userRepository.saveAll(asList(user01, user02));

        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        sdf.setTimeZone(TimeZone.getTimeZone("GMT"));

        Post post1 = new Post(
                null,
                "Teste",
                "Este é apenas um teste",
                sdf.parse("2024-08-01 12:00:00"),
                sdf.parse("2024-08-01 12:00:00"),
                new AuthorDTO(user01)
        );
        Post post2 = new Post(
                null,
                "Teste 02",
                "Este é apenas um outro teste",
                sdf.parse("2024-08-02 11:00:00"),
                sdf.parse("2024-08-02 11:00:00"),
                new AuthorDTO(user02)
        );

        CommentDTO comment1 = new CommentDTO(
                "comentário de teste",
                new AuthorDTO(user01),
                sdf.parse("2024-08-01 18:10:00")
        );
        CommentDTO comment2 = new CommentDTO(
                "comentário de teste",
                new AuthorDTO(user01),
                sdf.parse("2024-08-04 10:10:00")
        );

        post1.getComments().addAll(asList(comment1, comment2));

        postRepository.saveAll(asList(post1, post2));

        user01.setPosts(asList(post1, post2));
        user02.setPosts(List.of(post2));
        userRepository.saveAll(asList(user01, user02));
    }
}
