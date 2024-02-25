package com.example.bank.controller;

import com.example.bank.model.Contact;
import com.example.bank.service.ContactService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Date;

@RestController
@RequestMapping("/api")
public class ContactController {
    private ContactService contactService;
    @Autowired
    public ContactController(ContactService contactService) {
        this.contactService = contactService;
    }
    @GetMapping("/mycontact/{id}")
    public Contact getContact(@PathVariable int id) {
        Contact contact=contactService.findByContactId(id);
        if (contact != null) {
            return contact;
        }else {
            throw new RuntimeException("contact id not found - " +id);
        }
    }
    @PostMapping("/mycontact")
    public Contact addContact(@RequestBody Contact contact) {
        contact.setCreate_dt(new Date(System.currentTimeMillis()));/* đặt giá trị bằng time hiện tại */
        Contact theContact=contactService.saveContact(contact);
        return theContact;
    }
    @PutMapping("/mycontact")
    public Contact updateContact(@RequestBody Contact contact) {
        Contact theContact=contactService.saveContact(contact);
        return theContact;
    }
    @DeleteMapping("/mycontact/{id}")
    public String deleteContact(@PathVariable int id) {
        Contact contact=contactService.findByContactId(id);
        if (contact != null) {
            contactService.deleteContact(id);
            return "delete ContactId - " +id;
        }else {
            throw new RuntimeException("Contact id not found - " + id);
        }
    }
}
