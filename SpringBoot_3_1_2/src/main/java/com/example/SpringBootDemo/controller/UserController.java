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
import java.util.Comparator;
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
public class UserController {

    private final PostService postService;

    /**
     * Добавление поста (юзер)
     */
    @PostMapping()
    public ResponseEntity<Post> createMyPost(@RequestBody Post post) {
        User user = (User) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        post.setUser(user);
        post.setDateCreate(LocalDate.now());
        postService.save(post);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }

    /**
     * Все посты ползователя (юзер)
     */
    @GetMapping()
    public ResponseEntity<List<Post>> getAllMyPost() {
        User user = (User) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        List<Post> posts = postService.getUserPosts(user.getId());
        return posts != null && !posts.isEmpty() ?
                new ResponseEntity<>(posts, HttpStatus.OK) :
                new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    /**
     * Изменение поста (юзер)
     */
    @PutMapping()
    public ResponseEntity<Post> updateMyPost(@RequestBody Post post) {
        Post editPost = postService.get(post.getId());
        editPost.setDateCreate(LocalDate.now());
        editPost.setTitle(post.getTitle());
        editPost.setText(post.getText());
        postService.save(editPost);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    /**
     * Данные в форму изменения поста (юзер)
     */
    @GetMapping("/{postId}")
    public ResponseEntity<Post> getMyPost(@PathVariable(name = "postId") Long id) {
        Post post = postService.get(id);
        return post != null ?
                new ResponseEntity<>(post, HttpStatus.OK) :
                new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    /**
     * Удаление поста (юзер)
     */
    @DeleteMapping("/{postId}")
    public ResponseEntity<Post> deleteMyPost(@PathVariable(name = "postId") Long id) {
        postService.delete(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @GetMapping("/all")
    public ResponseEntity<List<Post>> getAllPost() {
        List<Post> posts = postService.listAllPosts();

        posts.sort(Comparator.comparing(Post::getDateCreate).reversed());
        return posts != null && !posts.isEmpty() ?
                new ResponseEntity<>(posts, HttpStatus.OK) :
                new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }
}
