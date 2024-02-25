package com.example.bank.repository;

import com.example.bank.model.Loans;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface LoansRepository extends CrudRepository<Loans, Long> {
    List<Loans> findByCustomerId(int customerId);
    Loans findByLoanNumber(int number);
    void deleteLoansByLoanNumber(int number);
}
