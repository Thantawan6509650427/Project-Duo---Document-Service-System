package com.example.documentservice.dto;

public class SignCommandDTO {
    private Long requesterId;
    private Long providerId;
    private String comment;
    private String status;

    // Constructors
    public SignCommandDTO() {}

    public SignCommandDTO(Long requesterId, Long providerId, String comment, String status) {
        this.requesterId = requesterId;
        this.providerId = providerId;
        this.comment = comment;
        this.status = status;
    }

    // Getters and Setters
    public Long getRequesterId() {
        return requesterId;
    }

    public void setRequesterId(Long requesterId) {
        this.requesterId = requesterId;
    }

    public Long getProviderId() {
        return providerId;
    }

    public void setProviderId(Long providerId) {
        this.providerId = providerId;
    }

    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
}