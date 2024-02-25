package com.example.bank.controller;

import com.example.bank.model.Transactions;
import com.example.bank.service.TransactionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api")
public class TracsactionController {
    private TransactionService transactionService;
    @Autowired
    public TracsactionController(TransactionService transactionService) {
        this.transactionService = transactionService;
    }
    @GetMapping("/mytransaction/{id}")
    public List<Transactions> getTransactions(@PathVariable int id) {
        List<Transactions> transactions=transactionService.findByCustomerId(id);
        if (transactions != null) {
            return transactions;
        }else {
            throw new RuntimeException("transaction is not found -" +id);
        }
    }
}
