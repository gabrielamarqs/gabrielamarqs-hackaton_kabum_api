package com.example.HackatonKabum.service;

import com.example.HackatonKabum.model.Card;
import com.example.HackatonKabum.model.Event;
import com.example.HackatonKabum.model.dto.CreateEventDTO;
import com.example.HackatonKabum.repository.CardRepository;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
@AllArgsConstructor
public class CardService {
    @Autowired
    private final CardRepository cardRepository;

    public UUID createCard(CreateEventDTO input) {
        Card card = new Card();
        card.setNumber(input.getNumber());
        card.setCpf(input.getCpf());
        card.setPrice(input.getPrice());
        card.setCardType(input.getCardType());
        card.setVerificationCode(input.getVerificationCode());
        card.setExpirationDate(input.getExpirationDate());
        cardRepository.save(card);
        return card.getId();
    }
}
