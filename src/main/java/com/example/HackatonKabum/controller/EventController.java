package com.example.HackatonKabum.controller;


import com.example.HackatonKabum.model.Card;
import com.example.HackatonKabum.model.Event;
import com.example.HackatonKabum.model.User;
import com.example.HackatonKabum.model.dto.CreateEventDTO;
import com.example.HackatonKabum.service.EventService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.security.auth.login.LoginException;
import java.util.List;
import java.util.UUID;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/event")
public class EventController {
    private final EventService eventService;

    public EventController(EventService eventService) {
        this.eventService = eventService;
    }

    @GetMapping("/hello")
    public ResponseEntity<String> helloWorld() throws Exception {
        return ResponseEntity.ok("hello world");
    }

    @PostMapping("/create/{id}")
    public ResponseEntity<String> create(@PathVariable UUID id, @RequestBody CreateEventDTO createEventDTO) throws Exception {
        String registeredUser = eventService.createEventForUser(id, createEventDTO);
        return ResponseEntity.ok(registeredUser);
    }

    @GetMapping
    public ResponseEntity<List<Event>> getAllEvents() throws Exception {
        List<Event> events = eventService.getAllEvents();
        return ResponseEntity.ok(events);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Event> getEventById(@PathVariable UUID id) throws Exception {
        Event event = eventService.getUserById(id);
        return ResponseEntity.ok(event);
    }

    @GetMapping("/game/{game}")
    public ResponseEntity<List<Event>> getEventByGame(@PathVariable String game) throws Exception {
        List<Event> events = eventService.getEventByGame(game);
        return ResponseEntity.ok(events);
    }

    @PutMapping("/update/{id}")
    public ResponseEntity<String> update(@PathVariable UUID id, @RequestBody Event eventUpdate) throws LoginException {
        String updatedEvent = eventService.updateEvent(id, eventUpdate);
        return ResponseEntity.ok("User " + updatedEvent + " updated successfully.");
    }
}
