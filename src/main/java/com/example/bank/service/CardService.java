package com.example.bank.service;

import com.example.bank.model.Card;

import java.util.List;

public interface CardService {
    List<Card> findByCustomerId(int customerId);
    Card findByCardId(int cardId);
    Card saveCard(Card theCard);
    void  deleteCard(int customerId);
}
