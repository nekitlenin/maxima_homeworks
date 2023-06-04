package com.example.SpringBootDemo.controller;

import com.example.SpringBootDemo.model.Post;
import com.example.SpringBootDemo.model.User;
import com.example.SpringBootDemo.service.PostService;
import com.example.SpringBootDemo.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.*;

import java.util.Comparator;
import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping(value = "/admin")
public class AdminController {

    private final UserService userService;
    private final PostService postService;

    /**
     * Создание пользователя (админ)
     */
    @PostMapping()
    public ResponseEntity<User> create(@RequestBody User user) {
        userService.save(user);
        System.out.println(user);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }

    /**
     * Все пользователи (админ)
     */
    @GetMapping()
    public ResponseEntity<List<User>> getAll() {
        List<User> users = userService.listAll();
        return users != null && !users.isEmpty() ?
                new ResponseEntity<>(users, HttpStatus.OK) :
                new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    /**
     * Данные пользователя (админ) 4 раза вызывает?
     */
    @GetMapping("/{userId}")
    public ResponseEntity<User> getUser(@PathVariable(name = "userId") Long id) {
        User user = userService.get(id);
        return user != null ?
                new ResponseEntity<>(user, HttpStatus.OK) :
                new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    /**
     * Обновление пользователя (админ)
     */
    @PutMapping("/")
    public ResponseEntity<User> updateUser(@RequestBody User user) {
        userService.save(user);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    /**
     * Удаление пользователя (админ)
     */
    @DeleteMapping("/{userId}")
    public ResponseEntity<User> deleteUser(@PathVariable(name = "userId") Long id) {
        for (Post post : postService.getUserPosts(id))
            postService.delete(post.getId());
        userService.delete(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    /**
     * Все посты пользователей (админ)
     */
    @GetMapping("/post")
    public ResponseEntity<List<Post>> getAllPost() {
        List<Post> posts = postService.listAllPosts();
        User user = (User) SecurityContextHolder.getContext().getAuthentication().getPrincipal();

        boolean isAdmin = user.getAuthorities().stream()
                .anyMatch(role -> role.getAuthority().equals("ROLE_ADMIN"));
        if (!isAdmin)
            posts = null;
        else
            posts.sort(Comparator.comparing(Post::getDateCreate).reversed());
        return posts != null && !posts.isEmpty() ?
                new ResponseEntity<>(posts, HttpStatus.OK) :
                new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    /**
     * Пост пользотеля при удалении (админ)
     */
    @GetMapping("/post/{postId}")
    public ResponseEntity<Post> getPost(@PathVariable(name = "postId") Long id) {
        Post post = postService.get(id);
        return post != null ? new ResponseEntity<>(post, HttpStatus.OK) : new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    /**
     * Удаление поста пользователя (админ)
     */
    @DeleteMapping("/post/{postId}")
    public ResponseEntity<Post> deletePost(@PathVariable(name = "postId") Long id) {
        postService.delete(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }
}
