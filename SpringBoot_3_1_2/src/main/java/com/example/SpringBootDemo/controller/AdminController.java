package com.example.SpringBootDemo.controller;

import com.example.SpringBootDemo.model.Role;
import com.example.SpringBootDemo.model.User;
import com.example.SpringBootDemo.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.context.SecurityContextHolder;
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

    @GetMapping
    public ModelAndView allUsers() {
        List<User> users = userService.listAll();
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("index");
        User user = (User) SecurityContextHolder.getContext()
                                                .getAuthentication()
                                                .getPrincipal();
        // здесь не было этой строчки userInRepo и обновление пользователя не отображалось даже при перезагрузке страницы
        User userInRepo = userService.findByEmail(user.getEmail());
        modelAndView.addObject("authUser", userInRepo);
        modelAndView.addObject("users", users);
        modelAndView.addObject("user", new User());
        modelAndView.addObject("roles", Role.values());
        return modelAndView;
    }
}
