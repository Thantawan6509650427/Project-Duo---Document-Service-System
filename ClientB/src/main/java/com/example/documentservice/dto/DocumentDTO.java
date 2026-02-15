package com.example.documentservice.dto;

public class DocumentDTO {
    private Long id;
    private String title;
    private String content;
    private String status;
    private Long ownerId;

    // Constructors
    public DocumentDTO() {}

    public DocumentDTO(Long id, String title, String content, String status, Long ownerId) {
        this.id = id;
        this.title = title;
        this.content = content;
        this.status = status;
        this.ownerId = ownerId;
    }

    // Getters and Setters
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public Long getOwnerId() {
        return ownerId;
    }

    public void setOwnerId(Long ownerId) {
        this.ownerId = ownerId;
    }
}
