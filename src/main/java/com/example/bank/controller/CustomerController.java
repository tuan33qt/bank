package com.example.bank.controller;

import com.example.bank.model.Customer;
import com.example.bank.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api")
public class CustomerController {
    private CustomerService customerService;
    @Autowired
    public CustomerController(CustomerService customerService) {
        this.customerService = customerService;
    }
    @GetMapping("/mycustomer/{customerId}")
    public Customer getCustomer(@PathVariable int customerId) {
        Customer customer=customerService.findByCustomerId(customerId);
        if (customer != null) {
            return customer;
        }else {
            throw new RuntimeException("customer id not found - " +customerId);
        }
    }
    @DeleteMapping("/mycustomer/{customerId}")
    public String deleteCustomer(@PathVariable int customerId) {
        Customer thecustomer=customerService.findByCustomerId(customerId);
        if (thecustomer != null) {
            customerService.deleteCustomer(customerId);
            return "delete customer id -"+customerId;
        }else {
            throw new RuntimeException("customer id not found - " +customerId);
        }
    }
}
