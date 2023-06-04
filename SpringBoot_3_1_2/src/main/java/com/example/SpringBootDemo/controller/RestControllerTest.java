package com.example.SpringBootDemo.controller;

import com.example.SpringBootDemo.model.Post;
import com.example.SpringBootDemo.model.User;
import com.example.SpringBootDemo.service.PostService;
import com.example.SpringBootDemo.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping(value = "/rest/admin")
public class RestControllerTest {

    private final UserService userService;

    @PostMapping(value = "/")
    public ResponseEntity<User> create(@RequestBody User user) {
        userService.save(user);
        System.out.println("*****create restcontroller***");
        System.out.println(user);
        System.out.println("*****create restcontroller***");
        return new ResponseEntity<>(HttpStatus.CREATED);
    }

    @GetMapping(value = "/")
    public ResponseEntity<List<User>> getAll() {
        List<User> users = userService.listAll();
        return users != null && !users.isEmpty() ?
                new ResponseEntity<>(users, HttpStatus.OK) :
                new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @GetMapping(value = "/{id}")
    public ResponseEntity<User> getUser(@PathVariable(name = "id") Long id) {
        User user = userService.get(id);
        System.out.println(user);
        return user != null ?
                new ResponseEntity<>(user, HttpStatus.OK) :
                new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @PutMapping(value = "/")
    public ResponseEntity<User> updateUser(@RequestBody User user) {
        System.out.println("*****update restcontroller***");
        userService.save(user);
        System.out.println("*****update restcontroller***");
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @DeleteMapping(value = "/{id}")
    public ResponseEntity<User> deleteUser(@PathVariable(name = "id") Long id) {
        userService.delete(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }
}
