package com.example.bank.service;

import com.example.bank.model.Transactions;
import com.example.bank.repository.TransactionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TransactionServiceImpl implements TransactionService {
    TransactionRepository transactionRepository;
    @Autowired
    public TransactionServiceImpl(TransactionRepository transactionRepository) {
        this.transactionRepository = transactionRepository;
    }
    @Override
    public List<Transactions> findByCustomerId(int id) {
        List<Transactions> transactions=transactionRepository.findByCustomerIdOrderByTransactionDtDesc(id);
        return transactions;
    }
}
