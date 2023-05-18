package web.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import web.model.Order;
import web.model.User;
import web.service.OrderServiceEntity;
import web.service.UserServiceEntity;

import java.util.List;

/**
 * Project: springDataJpa
 *
 * @author nikita
 * Email:  nekitlenin@gmail.com |
 * Create: 11.05.2023 11:29 |
 * Created with IntelliJ IDEA
 */
@Controller
@RequiredArgsConstructor
public class UserController {

    private final OrderServiceEntity orderService;
    private final UserServiceEntity userService;

    @GetMapping("/registration")
    public String registerPage(Model model) {
        model.addAttribute("user", new User());
        return "register";
    }

    @PostMapping("/registration")
    public String addUser(User user) {
        userService.saveUser(user);
        return "redirect:/login";
    }

    @GetMapping("/login")
    public String loginPage(Model model) {
        model.addAttribute("user", new User());
        return "logIn";
    }

    @PostMapping("/login")
    public String confirmUser(User user) {
        User checkUser = userService.getUserByEmailAndPassword(user.getEmail(), user.getPassword());
        if (checkUser != null)
            return "redirect:/user/" + checkUser.getId();
        else
            return "";
    }

    @GetMapping("/user/{userId}")
    public String userProfile(@PathVariable("userId") Long userId, Model model) {
        User user = userService.getUserById(userId);

        List<Order> userOrdersList = orderService.findByUserId(userId);
        model.addAttribute("user", user);
        model.addAttribute("orderList", userOrdersList);
        return "profile";
    }
}
