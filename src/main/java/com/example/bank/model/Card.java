package com.example.bank.model;

import jakarta.persistence.*;

import java.util.Date;

@Entity
@Table(name = "cards")
public class Card {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name= "card_id")
    private int cardId;
    private String cardNumber;
    private int customerId;
    private String cardType;
    private int total_limit;
    private int amountUsed;
    private int availableAmount;
    private Date create_dt;

    public Card() {

    }

    public Card(String cardNumber, int customerId, String cardType, int total_limit, int amountUsed, int availableAmount, Date create_dt) {
        this.cardNumber = cardNumber;
        this.customerId = customerId;
        this.cardType = cardType;
        this.total_limit = total_limit;
        this.amountUsed = amountUsed;
        this.availableAmount = availableAmount;
        this.create_dt = create_dt;
    }

    public int getCardId() {
        return cardId;
    }

    public void setCardId(int cardId) {
        this.cardId = cardId;
    }

    public String getCardNumber() {
        return cardNumber;
    }

    public void setCardNumber(String cardNumber) {
        this.cardNumber = cardNumber;
    }

    public int getCustomerId() {
        return customerId;
    }

    public void setCustomerId(int customerId) {
        this.customerId = customerId;
    }

    public String getCardType() {
        return cardType;
    }

    public void setCardType(String cardType) {
        this.cardType = cardType;
    }

    public int getTotal() {
        return total_limit;
    }

    public void setTotal(int    total) {
        this.total_limit = total;
    }

    public int getAmountUsed() {
        return amountUsed;
    }

    public void setAmountUsed(int amountUsed) {
        this.amountUsed = amountUsed;
    }

    public int getAvailableAmount() {
        return availableAmount;
    }

    public void setAvailableAmount(int availableAmount) {
        this.availableAmount = availableAmount;
    }

    public Date getCreate_dt() {
        return create_dt;
    }

    public void setCreate_dt(Date create_dt) {
        this.create_dt = create_dt;
    }
}
