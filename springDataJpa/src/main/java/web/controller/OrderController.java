package web.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import web.model.Order;
import web.service.OrderServiceEntity;

/**
 * Project: springDataJpa
 *
 * @author nikita
 * Email:  nekitlenin@gmail.com |
 * Create: 18.05.2023 03:31 |
 * Created with IntelliJ IDEA
 */
@Controller
@RequiredArgsConstructor
public class OrderController {

    private final OrderServiceEntity orderService;

    @PostMapping("/orders")
    public String addOrder(@RequestParam Order order) {
        return ResponseEntity.ok(orderService.saveOrder(order)).toString();
    }
}
