package com.example.HackatonKabum.model;

import jakarta.persistence.*;
import lombok.Data;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.SourceType;

import java.time.LocalDate;
import java.util.UUID;

@Data
@Entity
@Table(name = "tb_event")
public class Event {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "event_id", nullable = false)
    private UUID id;
    @Column(name = "event_title", nullable = false)
    private String title;
//    rankiado, 2v2, campeonato
    @Column(name = "event_type", nullable = false)
    private String type;
    @Column(name = "event_description", nullable = false)
    private String description;
    @Column(name = "event_tags", nullable = false)
    private String tags;
    @Column(name = "event_date", nullable = false)
    private LocalDate date;
    @Column(name = "event_hour", nullable = false)
    private String hour;
    @Column(name = "event_image")
    private String image;
//    link para cadastro
    @Column(name = "event_link")
    private String link;
    @Column(name = "event_cash_prize")
    private String cashPrize;
    @Column(name = "event_status", nullable = false)
    private String status;
    @CreationTimestamp(source = SourceType.DB)
    @Column(name = "event_created_at", nullable = false, updatable = false)
    private LocalDate createdAt;
}

