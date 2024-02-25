package com.example.bank.service;

import com.example.bank.model.Card;
import com.example.bank.repository.CardRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CardServiceImpl implements CardService{
    private CardRepository cardRepository;
    @Autowired
    public CardServiceImpl(CardRepository cardRepository) {
        this.cardRepository = cardRepository;
    }
    @Override
    public List<Card> findByCustomerId(int customerId) {
        List<Card> cards=cardRepository.findByCustomerId(customerId);
        if (cards != null ) {
            return cards;
        }else {
            throw new RuntimeException("Did not find card " );
        }
    }
    @Override
    public Card findByCardId(int cardId) {
        Card card=cardRepository.findByCardId(cardId);
        if (card != null ) {
            return card;
        }else {
            throw new RuntimeException("Did not find card " );
        }
    }
    @Override
    @Transactional
    public Card saveCard(Card theCard) {
        return cardRepository.save(theCard);
    }

    @Override
    @Transactional
    public void deleteCard(int cardId) {
        cardRepository.deleteCardByCardId(cardId);
    }
}
