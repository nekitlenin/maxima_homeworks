package com.example.SpringBootDemo.controller;

import com.example.SpringBootDemo.model.Post;
import com.example.SpringBootDemo.model.Role;
import com.example.SpringBootDemo.model.User;
import com.example.SpringBootDemo.service.PostService;
import com.example.SpringBootDemo.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import java.util.Comparator;
import java.util.List;

@Controller
@RequiredArgsConstructor
@RequestMapping("/index")
public class MainController {

    private final UserService userService;
    private final PostService postService;

    /**
     * Основная страница
     */
    @GetMapping()
    public ModelAndView allUsers() {
        Post post = new Post();
        List<Post> postList = postService.listAllPosts();
        ModelAndView modelAndView = new ModelAndView();
        User user = (User) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        User authUser = userService.get(user.getId());

        postList.sort(Comparator.comparing(Post::getDateCreate).reversed());
        modelAndView.setViewName("index");
        List<Post> userPosts = postService.getUserPosts(authUser.getId());
        post.setUser(authUser);

        modelAndView.addObject("authUser", authUser);
        modelAndView.addObject("roles", Role.values());

        modelAndView.addObject("postList", postList);
        modelAndView.addObject("userPosts", userPosts);
        return modelAndView;
    }
}
