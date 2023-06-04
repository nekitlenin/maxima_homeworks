package com.example.SpringBootDemo.controller;

import com.example.SpringBootDemo.model.Post;
import com.example.SpringBootDemo.model.Role;
import com.example.SpringBootDemo.model.User;
import com.example.SpringBootDemo.service.PostService;
import com.example.SpringBootDemo.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.parameters.P;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
@RequiredArgsConstructor
@RequestMapping("/index")
public class AdminController {

    private final UserService userService;
    private final PostService postService;

    @GetMapping
    public ModelAndView allUsers() {
        List<User> users = userService.listAll();
        List<Post> posts = postService.listAllPosts();
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("index");
        User user = (User) SecurityContextHolder.getContext()
                                                .getAuthentication()
                                                .getPrincipal();
        // здесь не было этой строчки userInRepo и обновление пользователя не отображалось даже при перезагрузке страницы
        User userInRepo = userService.findByEmail(user.getEmail());
        Post post = new Post();
        List<Post> userPosts = postService.getUserPosts(userInRepo.getId());
        System.out.println("*************admin*controller******************");
        System.out.println(userPosts);
//        System.out.println(userPosts.get(0).getUser());
        System.out.println("*************admin*controller******************");
        post.setUser(userInRepo);

        modelAndView.addObject("authUser", userInRepo);
        modelAndView.addObject("users", users);
        modelAndView.addObject("user", new User());
        modelAndView.addObject("roles", Role.values());

        modelAndView.addObject("posts", posts);
        modelAndView.addObject("userPosts", userPosts);
        modelAndView.addObject("post", post);
        return modelAndView;
    }
}
