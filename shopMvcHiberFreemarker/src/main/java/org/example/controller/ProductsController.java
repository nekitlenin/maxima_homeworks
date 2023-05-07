package org.example.controller;

import lombok.RequiredArgsConstructor;
import org.example.model.Product;
import org.example.repository.ProductRepository;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
/**
 * Project: springMvc
 *
 * @author nikita
 * Email:  nekitlenin@gmail.com |
 * Create: 23.04.2023 00:23 |
 * Created with IntelliJ IDEA
 */
@Controller
@RequiredArgsConstructor
public class ProductsController {
    private static final String REDIRECT = "redirect:/products";
    private final ProductRepository productRepository;


    @RequestMapping(value = "/products", method = RequestMethod.GET)
    public String init(Model model) {
        model.addAttribute("productList", productRepository.getAllProducts());
        return "index";
    }

    @RequestMapping(value = "/products", method = RequestMethod.POST)
    public String addProduct(Model model, Product product) {
        productRepository.saveProduct(product);
        model.addAttribute("productList", productRepository.getAllProducts());
        return REDIRECT;
    }

    @RequestMapping(value = "/products/update", method = RequestMethod.POST)
    public String updateProduct(Model model, Product product) {
        productRepository.updateProduct(product);
        model.addAttribute("productList", productRepository.getAllProducts());
        return REDIRECT;
    }

    @RequestMapping(value = "/products/update/{id}", method = RequestMethod.GET)
    public String updateProduct(Model model, @PathVariable("id") Long id) {
        model.addAttribute("product", productRepository.getProductById(id));
        return "update";
    }

    @RequestMapping(value = "/products/delete/{id}", method = RequestMethod.GET)
    public String deleteProduct(Model model, @PathVariable("id") Long id) {
        productRepository.deleteProductById(id);
        model.addAttribute("productList", productRepository.getAllProducts());
        return REDIRECT;
    }
//    @RequestMapping(value = "/contacts")
//    public String contactService(Model model) {
//        model.addAttribute("contactList", contactRepo.getAllContact());
//        return "contacts";
//    }
//
//    @RequestMapping(value = "/contact/save", method = RequestMethod.POST)
//    public String saveContact(Product contact, Model model) {
//        contactRepo.saveContact(contact);
//        ;
//        model.addAttribute("contactList", contactRepo.getAllContact());
//        return REDIRECT;
//    }
//
//    @RequestMapping(value = "/contact/delete/{id}", method = RequestMethod.GET)
//    public String deleteContact(@PathVariable("id") Long id, Model model) {
//        contactRepo.deleteContact(id);
//        model.addAttribute(contactRepo.getAllContact());
//        return REDIRECT;
//    }
//
//    @RequestMapping(value = "/contact/edit/{id}", method = RequestMethod.GET)
//    public String updateContact(@PathVariable("id") Long id, Model model) {
//        Product contact = contactRepo.getContactById(id);
//        model.addAttribute("editContact", contact);
//        return "edit";
//    }
//
//    @RequestMapping(value = "/contact/edit", method = RequestMethod.POST)
//    public String updateContact(Product contact) {
//        contactRepo.editContact(contact);
//        return REDIRECT;
//    }
}
