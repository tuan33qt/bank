package com.example.bank.service;

import com.example.bank.model.Customer;

public interface CustomerService {
    Customer findByCustomerId(int customerId);
    void deleteCustomer(int customerId);
}
