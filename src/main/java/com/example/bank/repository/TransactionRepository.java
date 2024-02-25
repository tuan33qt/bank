package com.example.bank.repository;

import com.example.bank.model.Transactions;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface TransactionRepository extends CrudRepository<Transactions, Long> {
    List<Transactions> findByCustomerIdOrderByTransactionDtDesc(int id);
}
