package com.example.bank.service;

import com.example.bank.model.Account;
import com.example.bank.repository.AccountRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestParam;
@Service
public class AccountServiceImpl implements AccountService{
    private AccountRepository accountRepository;
    @Autowired

    public AccountServiceImpl(AccountRepository accountRepository) {
        this.accountRepository = accountRepository;
    }
    @Override
    public Account findByCustomerId(int customerId ) {
        Account account=accountRepository.findByCustomerId(customerId);
        if (account!=null) {
            return account;
        }else {
            throw new RuntimeException("Did not find account id - " +customerId);
        }
    }

    @Override
    @Transactional
    public Account save(Account theAccount) {
        return accountRepository.save(theAccount);
    }
    @Override
    @Transactional
    public void deleteByCustomerId(int customerId) {
        accountRepository.deleteAccountByCustomerId(customerId);
    }
}
