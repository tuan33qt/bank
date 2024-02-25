package com.example.bank.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

import java.util.Date;

@Entity
@Table(name = "account_transactions")
public class Transactions {
    @Id
    @Column(name = "transaction_id")
    private String transaction_id;
    private long account_number;
    @Column(name = "customer_id")
    private int customerId;
    @Column(name = "transaction_dt")
    private Date transactionDt;
    private String transaction_summary;
    private String transaction_type;
    private int transaction_amt;
    private int closing_balance;
    private Date create_dt;

    public Transactions() {

    }

    public Transactions(long account_number, int customerId, Date transactionDt, String transaction_summary, String transaction_type, int transaction_amt, int closing_balance, Date create_dt) {
        this.account_number = account_number;
        this.customerId = customerId;
        this.transactionDt = transactionDt;
        this.transaction_summary = transaction_summary;
        this.transaction_type = transaction_type;
        this.transaction_amt = transaction_amt;
        this.closing_balance = closing_balance;
        this.create_dt = create_dt;
    }

    public String getTransaction_id() {
        return transaction_id;
    }

    public void setTransaction_id(String transaction_id) {
        this.transaction_id = transaction_id;
    }

    public long getAccount_number() {
        return account_number;
    }

    public void setAccount_number(long account_number) {
        this.account_number = account_number;
    }

    public int getCustomer_id() {
        return customerId;
    }

    public void setCustomer_id(int customerId) {
        this.customerId = customerId;
    }

    public Date getTransaction_dt() {
        return transactionDt;
    }

    public void setTransaction_dt(Date transactionDt) {
        this.transactionDt = transactionDt;
    }

    public String getTransaction_summary() {
        return transaction_summary;
    }

    public void setTransaction_summary(String transaction_summary) {
        this.transaction_summary = transaction_summary;
    }

    public String getTransaction_type() {
        return transaction_type;
    }

    public void setTransaction_type(String transaction_type) {
        this.transaction_type = transaction_type;
    }

    public int getTransaction_amt() {
        return transaction_amt;
    }

    public void setTransaction_amt(int transaction_amt) {
        this.transaction_amt = transaction_amt;
    }

    public int getClosing_balance() {
        return closing_balance;
    }

    public void setClosing_balance(int closing_balance) {
        this.closing_balance = closing_balance;
    }

    public Date getCreate_dt() {
        return create_dt;
    }

    public void setCreate_dt(Date create_dt) {
        this.create_dt = create_dt;
    }
}
