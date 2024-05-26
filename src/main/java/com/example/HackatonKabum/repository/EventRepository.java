package com.example.HackatonKabum.repository;

import com.example.HackatonKabum.model.Event;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.UUID;

public interface EventRepository extends JpaRepository<Event, UUID> {
    List<Event> findByGame(String game);
}
