package com.example.bank.repository;

import com.example.bank.model.Customer;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CustomerRepository extends CrudRepository<Customer, Long> {
    Customer findByCustomerId(int customerId);
    List<Customer> findByEmail(String email);
    void deleteByCustomerId(int customerId);
}
