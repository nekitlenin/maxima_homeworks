package ru.maxima.firstspringbootapp.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import ru.maxima.firstspringbootapp.service.UserService;

@Controller
@RequiredArgsConstructor
public class UserController {
  public final UserService userService;

  @GetMapping(value = "/user")
  public String userPage(Model model) {
    model.addAttribute("users",userService.findAll());
    return "userInfo";
  }
}
