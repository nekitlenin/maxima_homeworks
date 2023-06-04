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

    @PostMapping()
    public ResponseEntity<Post> createPost(@RequestBody Post post) {
        User user = (User) SecurityContextHolder.getContext()
                .getAuthentication()
                .getPrincipal();
        post.setUser(user);
        post.setDateCreate(LocalDate.now());
        postService.save(post);
        System.out.println("*************createpost*controller***************");
        System.out.println(post);
        System.out.println("*************createpost*controller***************");
        return new ResponseEntity<>(HttpStatus.CREATED);
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
        System.out.println("*****update postcontroller***");
        postService.save(post);
        System.out.println("*****update postcontroller***");
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @DeleteMapping(value = "/{id}")
    public ResponseEntity<Post> deletePost(@PathVariable(name = "id") Long id) {
        postService.delete(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @PostMapping(value = "/profile/")
    public ResponseEntity<Post> createMyPost(@RequestBody Post post) {
        post.setDateCreate(LocalDate.now());
        postService.save(post);
        System.out.println(post);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }

    @GetMapping(value = "/profile/")
    public ResponseEntity<List<Post>> getAllMyPost() {
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
    public ResponseEntity<Post> updateMyPost(@RequestBody Post post) {
        Post editPost = postService.get(post.getId());
        editPost.setDateCreate(LocalDate.now());
        editPost.setTitle(post.getTitle());
        editPost.setText(post.getText());
        System.out.println("*********updateMyPost*********");
        System.out.println(editPost);
        System.out.println("*********updateMyPost*********");
        postService.save(editPost);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @GetMapping(value = "/profile/{id}")
    public ResponseEntity<Post> getMyPost(@PathVariable(name = "id") Long id) {
        Post post = postService.get(id);
        return post != null ? new ResponseEntity<>(post, HttpStatus.OK) : new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @DeleteMapping(value = "/profile/{id}")
    public ResponseEntity<Post> deleteMyPost(@PathVariable(name = "id") Long id) {
        postService.delete(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }
}
