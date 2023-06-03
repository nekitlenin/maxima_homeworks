package com.example.SpringBootDemo.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@RequiredArgsConstructor
@Controller
public class DeffController {

    @GetMapping("/")
    public String home(@RequestParam(name = "name", required = false, defaultValue = "World") String name, Model model) {
        model.addAttribute("name", name);
        return "redirect:/login";
    }

    @GetMapping(value = "/login")
    public String getLoginPage() {
        return "login";
    }
}
