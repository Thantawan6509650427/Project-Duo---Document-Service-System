package com.example.requestservice.dto;

import java.time.LocalDateTime;

public class DocumentDTO {
    
    private Long id;
    private String title;
    private String content;
    private Long ownerId;
    private String status;
    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;

    // Constructors
    public DocumentDTO() {}

    public DocumentDTO(Long id, String title, String content, Long ownerId, String status) {
        this.id = id;
        this.title = title;
        this.content = content;
        this.ownerId = ownerId;
        this.status = status;
    }

    // Getters and Setters
    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }
    
    public String getTitle() { return title; }
    public void setTitle(String title) { this.title = title; }
    
    public String getContent() { return content; }
    public void setContent(String content) { this.content = content; }
    
    public Long getOwnerId() { return ownerId; }
    public void setOwnerId(Long ownerId) { this.ownerId = ownerId; }
    
    public String getStatus() { return status; }
    public void setStatus(String status) { this.status = status; }
    
    public LocalDateTime getCreatedAt() { return createdAt; }
    public void setCreatedAt(LocalDateTime createdAt) { this.createdAt = createdAt; }
    
    public LocalDateTime getUpdatedAt() { return updatedAt; }
    public void setUpdatedAt(LocalDateTime updatedAt) { this.updatedAt = updatedAt; }
}