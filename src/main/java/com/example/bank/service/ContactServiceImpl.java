package com.example.bank.service;

import com.example.bank.model.Contact;
import com.example.bank.repository.ContactRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ContactServiceImpl implements ContactService{
    private ContactRepository contactRepository;
    @Autowired
    public ContactServiceImpl(ContactRepository contactRepository) {
        this.contactRepository = contactRepository;
    }
    @Override
    public Contact findByContactId(int id) {
        Contact contact=contactRepository.findByContactId(id);
        if (contact != null) {
            return contact;
        }else {
            throw new RuntimeException("Did not find contact " );
        }
    }

    @Override
    @Transactional
    public Contact saveContact(Contact theContact) {
        return contactRepository.save(theContact);
    }

    @Override
    @Transactional
    public void deleteContact(int id) {
        contactRepository.deleteByContactId(id);
    }
}
