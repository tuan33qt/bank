package com.example.bank.controller;

import com.example.bank.model.Loans;
import com.example.bank.service.LoansService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
import java.util.List;

@RestController
@RequestMapping("/api")
public class LoansController {
    private LoansService loansService;
    @Autowired
    public LoansController(LoansService loansService) {
        this.loansService = loansService;
    }
    @GetMapping("/myloan/{customerId}")
    public List<Loans> getLoans(@PathVariable int customerId) {
        List<Loans> loans=loansService.findByCustomerId(customerId);
        if (loans != null) {
            return loans;
        }else {
            throw new RuntimeException("loans id not found - " +customerId);
        }
    }
    @PostMapping("/myloan")
    public Loans addLoan(@RequestBody Loans loans) {
        loans.setCreate_dt(new Date(System.currentTimeMillis()));
        Loans theLoans=loansService.saveLoan(loans);
        return theLoans;
    }
    @PutMapping("/myloan")
    public Loans updateLoan(@RequestBody Loans loans) {
        Loans theLoans=loansService.saveLoan(loans);
        return theLoans;
    }
    @DeleteMapping("/myloan/{number}")
    public String deleteLoan(@PathVariable int number) {
        Loans loans=loansService.findByLoanNumber(number);
        if (loans != null) {
            loansService.deleteLoans(number);
            return "delete Loan number - " +number;
        }else {
            throw new RuntimeException("loan id not found - " + number);
        }
    }
}
