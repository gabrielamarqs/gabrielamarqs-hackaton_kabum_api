package com.example.HackatonKabum.repository;

import com.example.HackatonKabum.model.Card;
import com.example.HackatonKabum.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface CardRepository extends JpaRepository<Card, UUID> {
}
