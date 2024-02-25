package com.example.bank.service;

import com.example.bank.model.Loans;

import java.util.List;

public interface LoansService {
    List<Loans> findByCustomerId(int customerId);
    Loans findByLoanNumber(int number);
    Loans saveLoan(Loans loans);
    void deleteLoans(int number);
}
