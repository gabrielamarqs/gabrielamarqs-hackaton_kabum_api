package com.example.HackatonKabum.model.dto;

import com.example.HackatonKabum.model.enumerator.CardType;
import lombok.Data;

import java.time.LocalDate;

@Data
public class CreateEventDTO {
    private String title;
    private String type;
    private String game;
    private double cashPrize;
    private String description;
    private String hour;
    private String number;
    private LocalDate date;
    private String cpf;
    private double price;
    private CardType cardType;
    private String verificationCode;
    private String expirationDate;
}
