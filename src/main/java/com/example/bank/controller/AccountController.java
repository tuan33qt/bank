package com.example.bank.controller;

import com.example.bank.model.Account;
import com.example.bank.service.AccountService;
import com.example.bank.service.AccountServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api")
public class AccountController {
  private AccountService accountService;
  @Autowired
  public AccountController(AccountService accountService) {
        this.accountService = accountService;
  }
  @GetMapping("/myaccount/{customerId}")
  public Account getAccount(@PathVariable int customerId) {
      Account account=accountService.findByCustomerId(customerId);
      if (account!=null) {
          return account;
      } else {
          throw new RuntimeException("account id not found - " +customerId);
      }
  }
  @PostMapping("/myaccount")
  public Account addAccount(@RequestBody Account account) {
      account.setAccountNumber(0);
      Account theAccount=accountService.save(account);
      return theAccount;
  }
  @PutMapping("/myaccount")
  public Account updateAccount(@RequestBody Account account) {
      Account theAccount=accountService.save(account);
      return theAccount;
  }
  @DeleteMapping("/myaccount/{customerId}")
  public String deleteAccount(@PathVariable int customerId) {
      Account account=accountService.findByCustomerId(customerId);
      if (account!=null) {
          accountService.deleteByCustomerId(customerId);
          return "delete account -" +customerId;
      }else {
          throw new RuntimeException("account id not found - " + customerId);
      }

  }
}
