package org.example.controller;

import lombok.RequiredArgsConstructor;
import org.example.model.User;
import org.example.repository.UserRepository;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * Project: springMvc
 *
 * @author nikita
 * Email:  nekitlenin@gmail.com |
 * Create: 07.05.2023 00:17 |
 * Created with IntelliJ IDEA
 */
@Controller
@RequiredArgsConstructor
public class UsersController {
    private final UserRepository userRepository;

    @RequestMapping(value = "/registration", method = RequestMethod.GET)
    public String registerPage(Model model) {
        model.addAttribute("user", new User());
        return "register";
    }

    @RequestMapping(value = "/registration", method = RequestMethod.POST)
    public String addUser(Model model, User user) {
        userRepository.saveUser(user);
        return "redirect:/login";
    }

    @RequestMapping(value = "/login", method = RequestMethod.GET)
    public String loginPage(Model model) {
        model.addAttribute("user", new User());
        return "logIn";
    }

    @RequestMapping(value = "/login", method = RequestMethod.POST)
    public String confirmUser(Model model, User user) {
        User checkUser = userRepository.getUserByEmail(user.getEmail());
        if (isCorrect(user, checkUser))
            return "redirect:/products";
        else
            return "fail";
    }

    private boolean isCorrect(User user, User checkUser) {
        return checkUser != null && checkUser.getPassword().equals(user.getPassword());
    }


    @RequestMapping(value = "/fail", method = RequestMethod.GET)
    public String failPage(Model model) {
        return "fail";
    }
}
