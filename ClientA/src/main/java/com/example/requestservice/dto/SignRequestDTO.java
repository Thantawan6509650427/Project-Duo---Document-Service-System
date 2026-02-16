package com.example.requestservice.dto;

public class SignRequestDTO {
    
    private Long documentId;
    private Long requesterId;
    private String reason;

    // Constructors
    public SignRequestDTO() {}

    public SignRequestDTO(Long documentId, Long requesterId, String reason) {
        this.documentId = documentId;
        this.requesterId = requesterId;
        this.reason = reason;
    }

    // Getters and Setters
    public Long getDocumentId() {
        return documentId;
    }

    public void setDocumentId(Long documentId) {
        this.documentId = documentId;
    }

    public Long getRequesterId() {
        return requesterId;
    }

    public void setRequesterId(Long requesterId) {
        this.requesterId = requesterId;
    }

    public String getReason() {
        return reason;
    }

    public void setReason(String reason) {
        this.reason = reason;
    }

    @Override
    public String toString() {
        return "SignRequestDTO{" +
                "documentId=" + documentId +
                ", requesterId=" + requesterId +
                ", reason='" + reason + '\'' +
                '}';
    }
}