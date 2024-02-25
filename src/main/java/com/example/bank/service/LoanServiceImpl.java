package com.example.bank.service;

import com.example.bank.model.Loans;
import com.example.bank.repository.LoansRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class LoanServiceImpl implements LoansService {
    LoansRepository loansRepository;
    @Autowired
    public LoanServiceImpl(LoansRepository loansRepository) {
        this.loansRepository = loansRepository;
    }
    @Override
    public List<Loans> findByCustomerId(int customerId) {
        List<Loans> loans=loansRepository.findByCustomerId(customerId);
        if(loans != null) {
            return loans;
        }else {
            throw new RuntimeException("Did not find loan " );
        }
    }

    @Override
    public Loans findByLoanNumber(int number) {
        Loans theLoan=loansRepository.findByLoanNumber(number);
        return theLoan;
    }

    @Override
    @Transactional
    public Loans saveLoan(Loans loans) {
        return loansRepository.save(loans);
    }

    @Override
    @Transactional
    public void deleteLoans(int number) {
        loansRepository.deleteLoansByLoanNumber(number);
    }
}
