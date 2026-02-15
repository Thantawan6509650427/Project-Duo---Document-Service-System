package com.example.requestservice.model;

import jakarta.persistence.*;
import java.time.LocalDateTime;

@Entity
public class RequestLog {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private Long documentId;
    private String type; // EDIT or SIGN
    private String detail;
    private LocalDateTime requestedAt = LocalDateTime.now();

    // Getters and Setters...
}
