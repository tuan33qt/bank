package com.example.bank.service;

import com.example.bank.model.Contact;

public interface ContactService {
    Contact findByContactId(int id);
    Contact saveContact(Contact theContact);
    void deleteContact(int id);
}
