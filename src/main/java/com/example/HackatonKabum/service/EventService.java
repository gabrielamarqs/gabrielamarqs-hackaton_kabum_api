package com.example.HackatonKabum.service;

import com.example.HackatonKabum.model.Card;
import com.example.HackatonKabum.model.Event;
import com.example.HackatonKabum.model.User;
import com.example.HackatonKabum.model.dto.CreateEventDTO;
import com.example.HackatonKabum.repository.CardRepository;
import com.example.HackatonKabum.repository.EventRepository;
import com.example.HackatonKabum.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
public class EventService {

    @Autowired
    private EventRepository eventRepository;

    @Autowired
    private CardRepository cardRepository;

    private final CardService cardService;

    @Autowired
    private UserRepository userRepository;

    public EventService(CardService cardService) {
        this.cardService = cardService;
    }

    public String createEventForUser(UUID userId, CreateEventDTO createEventDTO) {
        User user = userRepository.findById(userId).orElseThrow(() -> new RuntimeException("User not found"));
        Event event = new Event();
        event.setUser(user);
        event.setTitle(createEventDTO.getTitle());
        event.setType(createEventDTO.getType());
        event.setGame(createEventDTO.getGame());
        event.setHour(createEventDTO.getHour());
        event.setPublicType(createEventDTO.getPublicType());
        event.setCashPrize(createEventDTO.getCashPrize());
        event.setDescription(createEventDTO.getDescription());
        event.setDate(createEventDTO.getDate());
        UUID cardId = cardService.createCard(createEventDTO);
        if (cardId != null) {
            event.setCard(cardRepository.findById(cardId).orElseThrow(() -> new RuntimeException("Card not found")));
            event.setStatus(true);
            eventRepository.save(event);
            return "Evento cadastrado com sucesso";
        } else {
            event.setStatus(false);
            eventRepository.save(event);
            return "Evento pendente de pagamento";
        }

    }

    public List<Event> getAllEvents() {
        return eventRepository.findAll();
    }

    public Event getUserById(UUID id) {
        return eventRepository.findById(id).orElseThrow(() -> new RuntimeException("Event not found"));
    }

    public List<Event> getEventByGame(String game) {
        return eventRepository.findByGame(game);
    }

    public String updateEvent(UUID id, Event eventUpdate) {
        Event event = eventRepository.findById(id).orElseThrow(() -> new RuntimeException("Event not found"));
        event.setTitle(eventUpdate.getTitle());
        event.setDescription(eventUpdate.getDescription());
        event.setDate(eventUpdate.getDate());
        event.setHour(eventUpdate.getHour());
        eventRepository.save(event);
        return event.getTitle();
    }
}
