package com.example.bank.repository;

import com.example.bank.model.Card;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository
public interface CardRepository extends CrudRepository<Card, Long>{
    List<Card> findByCustomerId(int customerId);
    Card findByCardId(int cardId);
    void deleteCardByCardId(int cardId);
}
