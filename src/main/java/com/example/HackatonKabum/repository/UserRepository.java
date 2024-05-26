package com.example.HackatonKabum.repository;

import com.example.HackatonKabum.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface UserRepository  extends JpaRepository<User, UUID> {

    User findByEmailAndPassword(String email, String password);

    User findByEmail(String email);

    User findByUsername(String username);

}
