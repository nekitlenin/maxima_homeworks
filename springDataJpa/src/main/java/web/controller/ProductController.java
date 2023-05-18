package web.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import web.model.Product;
import web.service.ProductServiceEntity;

/**
 * Project: springDataJpa
 *
 * @author nikita
 * Email:  nekitlenin@gmail.com |
 * Create: 18.05.2023 00:47 |
 * Created with IntelliJ IDEA
 */
@Controller
@RequiredArgsConstructor
public class ProductController {
    private static final String REDIRECT = "redirect:/products";
    private final ProductServiceEntity productService;


    @GetMapping("/products")
    public String getAllProducts(Model model) {
        model.addAttribute("productList", productService.findAll());
        return "index";
    }

    @PostMapping("/products")
    public String addProduct(Model model, Product product) {
        productService.saveProduct(product);
        model.addAttribute("productList", productService.findAll());
        return REDIRECT;
    }

    // ************************************************************************ //

    @PostMapping("/products/update")
    public String updateProduct(Model model, Product product) {
        productService.updateProduct(product);
        model.addAttribute("productList", productService.findAll());
        return REDIRECT;
    }

    @GetMapping("/products/update/{id}")
    public String updateProduct(Model model, @PathVariable("id") Long id) {
        model.addAttribute("product", productService.getProductById(id));
        return "update";
    }

    @GetMapping("/products/delete/{id}")
    public String deleteProduct(Model model, @PathVariable("id") Long id) {
        productService.deleteById(id);
        model.addAttribute("productList", productService.findAll());
        return REDIRECT;
    }
}
