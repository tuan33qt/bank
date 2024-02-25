package com.example.bank.service;

import com.example.bank.model.Account;

public interface AccountService {
    Account findByCustomerId(int customerId);
    Account save(Account theAccount);
    void deleteByCustomerId(int customerId);
}
