package com.example.HackatonKabum.model.dto;

import lombok.Data;

@Data
public class CreateEventDTO {
    private String title;
    private String type;
    private String game;
    private double cashPrize;
    private String description;
    private String hour;
    private String number;
    private String date;
    private String cpf;
    private String cardType;
    private String verificationCode;
    private String expirationDate;
}
