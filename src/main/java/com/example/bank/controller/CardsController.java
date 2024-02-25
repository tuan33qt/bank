package com.example.bank.controller;

import com.example.bank.model.Card;
import com.example.bank.service.CardService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
import java.util.List;

@RestController
@RequestMapping("/api")
public class CardsController {
    private CardService cardService;
    @Autowired
    public CardsController(CardService cardService) {
        this.cardService = cardService;
    }
    @GetMapping("/mycard/{customerId}")
    public List<Card> getCard(@PathVariable int customerId) {
        List<Card> cards=cardService.findByCustomerId(customerId);
        if (cards != null ) {
            return cards;
        }else {
            throw new RuntimeException("card id not found - " +customerId);
        }
    }
    @PostMapping("/mycard")
    public Card addCard(@RequestBody Card card) {
        card.setCreate_dt(new Date(System.currentTimeMillis()));
        Card theCard=cardService.saveCard(card);
        return theCard;
    }
    @PutMapping("/mycard")
    public Card updateCard(@RequestBody Card card) {
        Card theCard=cardService.saveCard(card);
        return theCard;
    }
    @DeleteMapping("/mycard/{cardId}")
    public String deleteCard(@PathVariable int cardId) {
        Card card=cardService.findByCardId(cardId);
        if (card !=null) {
            cardService.deleteCard(cardId);
            return "delete cardId "+ cardId;
        }else {
            throw new RuntimeException("card id not found - " + cardId);
        }
    }
}
