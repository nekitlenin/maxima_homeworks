package org.example.repository;

import org.example.model.Contact;
import org.springframework.stereotype.Component;

import java.util.Collection;
import java.util.HashMap;

/**
 * Project: springMvc
 *
 * @author nikita
 * Email:  nekitlenin@gmail.com |
 * Create: 23.04.2023 11:20 |
 * Created with IntelliJ IDEA
 */
@Component
public class ContactRepo {
    private HashMap<Long, Contact> contactRepo;

    public ContactRepo() {
        HashMap<Long, Contact> map = new HashMap<>();
        map.put(1l, Contact.builder()
                .id(1L)
                .firstName("Nikita")
                .lastName("Lyonin")
                .email("nekitlenin@gmail.com")
                .phoneNumber("+79196234807")
                .build());
        map.put(2l, Contact.builder()
                .id(2L)
                .firstName("AAA")
                .lastName("BBB")
                .email("CCC")
                .phoneNumber("DDD")
                .build());
        map.put(3l, Contact.builder()
                .id(3L)
                .firstName("agdd")
                .lastName("выфпркц")
                .email("екукегг")
                .phoneNumber("ввыааывфа")
                .build());
        this.contactRepo = map;
    }

    public Contact getContactById(Long id) {
        return contactRepo.get(id);
    }

    public Collection<Contact> getAllContact() {
        return contactRepo.values();
    }

    public void saveContact(Contact contact) {
        contactRepo.put(contact.getId(), contact);
    }

    public void deleteContact(Long id) {
        contactRepo.remove(id);
    }

    public void editContact(Contact contact) {
        contactRepo.put(contact.getId(), contact);
    }
}
