package com.example.bank.service;

import com.example.bank.model.Customer;
import com.example.bank.repository.CustomerRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CustomerServiceImp implements CustomerService{
    CustomerRepository customerRepository;
    @Autowired
    public CustomerServiceImp(CustomerRepository customerRepository) {
        this.customerRepository = customerRepository;
    }

    @Override
    public Customer findByCustomerId(int customerId) {
        Customer customer=customerRepository.findByCustomerId(customerId);
        return customer;
    }

    @Override
    @Transactional
    public void deleteCustomer(int customerId) {
        customerRepository.deleteByCustomerId(customerId);
    }
}
