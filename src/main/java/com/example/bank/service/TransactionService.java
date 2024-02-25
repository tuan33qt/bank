package com.example.bank.service;

import com.example.bank.model.Transactions;

import java.util.List;

public interface TransactionService {
    List<Transactions> findByCustomerId(int id);
}
