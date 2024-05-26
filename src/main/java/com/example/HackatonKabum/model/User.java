package com.example.HackatonKabum.model;

import com.example.HackatonKabum.model.enumerator.Gender;
import com.example.HackatonKabum.model.enumerator.Role;
import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.Data;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.SourceType;

import java.time.LocalDate;
import java.util.HashSet;
import java.util.Set;
import java.util.UUID;

@Data
@Entity
@Table(name = "tb_user")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "user_id", nullable = false)
    private UUID id;
    @Column(name = "user_name", nullable = false)
    private String name;
    @Column(name = "user_username", unique = true, nullable = false)
    private String username;
    @Column(name = "user_password", nullable = false, updatable = false)
    private String password;
    @Enumerated(EnumType.STRING)
    @Column(name = "user_gender", nullable = false)
    private Gender gender;
    @Column(name = "user_email", unique = true, nullable = false, updatable = false)
    private String email;
    @Enumerated(EnumType.STRING)
    @Column(name = "user_role", nullable = false, updatable = false)
    private Role role;

    @JsonIgnore
    @OneToMany(mappedBy = "user", cascade = CascadeType.ALL, orphanRemoval = true)
    private Set<Event> events = new HashSet<>();

    @CreationTimestamp(source = SourceType.DB)
    @Column(name = "user_created_at", nullable = false, updatable = false)
    private LocalDate createdAt;

}
