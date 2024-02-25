package com.example.bank.repository;

import com.example.bank.model.Contact;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ContactRepository extends CrudRepository<Contact, Long> {
    Contact findByContactId(int id);
    void deleteByContactId(int id);
}
