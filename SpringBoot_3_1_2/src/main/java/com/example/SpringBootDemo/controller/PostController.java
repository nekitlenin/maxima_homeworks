package com.example.SpringBootDemo.controller;

import com.example.SpringBootDemo.model.Post;
import com.example.SpringBootDemo.model.User;
import com.example.SpringBootDemo.service.PostService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.context.SecurityContextHolder;
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
@RequestMapping(value = "/user/post")
public class PostController {

    private final PostService postService;

    @PostMapping(value = "/")
    public ResponseEntity<Post> createPost(@RequestBody Post post) {
        post.setDateCreate(LocalDate.now());
        postService.save(post);
        System.out.println(post);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }

    @GetMapping(value = "/")
    public ResponseEntity<List<Post>> getAllPost() {
        List<Post> posts = postService.listAllPosts();
        System.out.println("*********post*controller***************");
        System.out.println(posts);
//        System.out.println(posts.get(2).getUser());
        System.out.println("**********post*controller**************");
        return posts != null && !posts.isEmpty() ?
                new ResponseEntity<>(posts, HttpStatus.OK) :
                new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @GetMapping(value = "/{id}")
    public ResponseEntity<Post> getPost(@PathVariable(name = "id") Long id) {
        Post post = postService.get(id);
        return post != null ? new ResponseEntity<>(post, HttpStatus.OK) : new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @PutMapping(value = "/")
    public ResponseEntity<Post> updatePost(@RequestBody Post post) {
        post.setDateCreate(LocalDate.now());
        post.setUser(post.getUser());
        postService.save(post);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @DeleteMapping(value = "/{id}")
    public ResponseEntity<Post> deletePost(@PathVariable(name = "id") Long id) {
        postService.delete(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @GetMapping(value = "/profile/")
    public ResponseEntity<List<Post>> getAllPostByUserId() {
        User user = (User) SecurityContextHolder.getContext()
                .getAuthentication()
                .getPrincipal();
        List<Post> posts = postService.getUserPosts(user.getId());
        System.out.println(posts);
        return posts != null && !posts.isEmpty() ?
                new ResponseEntity<>(posts, HttpStatus.OK) :
                new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @PutMapping(value = "/profile")
    public ResponseEntity<Post> updatePostByUser(@RequestBody Post post) {
        post.setDateCreate(LocalDate.now());
        post.setUser(post.getUser());
        postService.save(post);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @GetMapping(value = "/profile/{id}")
    public ResponseEntity<Post> getPostProfile(@PathVariable(name = "id") Long id) {
        Post post = postService.get(id);
        return post != null ? new ResponseEntity<>(post, HttpStatus.OK) : new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }
}
