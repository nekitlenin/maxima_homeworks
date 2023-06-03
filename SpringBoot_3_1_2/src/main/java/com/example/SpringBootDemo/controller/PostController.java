package com.example.SpringBootDemo.controller;

import com.example.SpringBootDemo.model.Post;
import com.example.SpringBootDemo.service.PostService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.List;

/**
 * Project: SpringBoot_3_1_2
 *
 * @author nikita
 * Email:  nekitlenin@gmail.com |
 * Create: 03.06.2023 17:57 |
 * Created with IntelliJ IDEA
 */
@RestController
@RequiredArgsConstructor
@RequestMapping(value = "/rest/post")
public class PostController {

    private final PostService postService;

    @PostMapping(value = "/")
    public ResponseEntity<Post> create(@RequestBody Post post) {
        post.setDateCreate(LocalDate.now());
        postService.save(post);
        System.out.println(post);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }

    @GetMapping(value = "/")
    public ResponseEntity<List<Post>> getAll() {
        List<Post> posts = postService.listAllPosts();
        return posts != null && !posts.isEmpty() ? new ResponseEntity<>(posts, HttpStatus.OK) : new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @GetMapping(value = "/{id}")
    public ResponseEntity<Post> getPost(@PathVariable(name = "id") int id) {
        Post post = postService.get((long) id);
        return post != null ? new ResponseEntity<>(post, HttpStatus.OK) : new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @PutMapping(value = "/")
    public ResponseEntity<Post> updatePost(@RequestBody Post post) {
        post.setDateCreate(LocalDate.now());
        postService.save(post);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @DeleteMapping(value = "/{id}")
    public ResponseEntity<Post> deletePost(@PathVariable(name = "id") int id) {
        postService.delete((long) id);
        return new ResponseEntity<>(HttpStatus.OK);
    }
}