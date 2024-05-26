package com.example.HackatonKabum.model;

import jakarta.persistence.*;
import lombok.Data;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.SourceType;

import java.time.LocalDate;
import java.util.UUID;

@Data
@Entity
@Table(name = "tb_card")
public class Card {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "card_id", nullable = false)
    private UUID id;
    @Column(name = "card_number")
    private String number;
    @Column(name = "card_cpf")
    private String cpf;
    @Transient
    private String verificationCode;
    @Transient
    private String cardType;
    @Transient
    private String expirationDate;

    @OneToOne(mappedBy = "card", fetch = FetchType.LAZY)
    private Event event;

    @CreationTimestamp(source = SourceType.DB)
    @Column(name = "card_created_at", nullable = false, updatable = false)
    private LocalDate createdAt;
}
