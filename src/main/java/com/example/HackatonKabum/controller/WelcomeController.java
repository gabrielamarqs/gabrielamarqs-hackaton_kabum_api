package com.example.HackatonKabum.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@CrossOrigin(origins = "*")
@RequestMapping("/welcome")
@RestController
public class WelcomeController {
    @GetMapping
    public ResponseEntity<String> getUserById() {
        return ResponseEntity.status(HttpStatus.OK).body("Welcome");
    }
}
