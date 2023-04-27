package org.example.controller;

import org.example.model.Contact;
import org.example.repository.ContactRepo;
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
public class ContactsController {
    private static final String REDIRECT = "redirect:/contacts";
    private ContactRepo contactRepo;

    public ContactsController(ContactRepo contactRepo) {
        this.contactRepo = contactRepo;
    }

    @RequestMapping(value = "/contacts")
    public String contactService(Model model) {
        model.addAttribute("contactList", contactRepo.getAllContact());
        return "contacts";
    }

    @RequestMapping(value = "/contact/save", method = RequestMethod.POST)
    public String saveContact(Contact contact, Model model) {
        contactRepo.saveContact(contact);
        ;
        model.addAttribute("contactList", contactRepo.getAllContact());
        return REDIRECT;
    }

    @RequestMapping(value = "/contact/delete/{id}", method = RequestMethod.GET)
    public String deleteContact(@PathVariable("id") Long id, Model model) {
        contactRepo.deleteContact(id);
        model.addAttribute(contactRepo.getAllContact());
        return REDIRECT;
    }

    @RequestMapping(value = "/contact/edit/{id}", method = RequestMethod.GET)
    public String updateContact(@PathVariable("id") Long id, Model model) {
        Contact contact = contactRepo.getContactById(id);
        model.addAttribute("editContact", contact);
        return "edit";
    }

    @RequestMapping(value = "/contact/edit", method = RequestMethod.POST)
    public String updateContact(Contact contact) {
        contactRepo.editContact(contact);
        return REDIRECT;
    }
}
