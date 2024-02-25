package com.example.bank.repository;

import com.example.bank.model.Account;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AccountRepository extends CrudRepository<Account, Long> {
    Account findByCustomerId(int customerId);
    void deleteAccountByCustomerId(int customerId);
}
