package com.example.requestservice.dto;

public class EditRequestDTO {
    
    private Long documentId;
    private Long requesterId;
    private String newContent;
    private String reason;

    // Constructors
    public EditRequestDTO() {}

    public EditRequestDTO(Long documentId, Long requesterId, String newContent, String reason) {
        this.documentId = documentId;
        this.requesterId = requesterId;
        this.newContent = newContent;
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

    public String getNewContent() {
        return newContent;
    }

    public void setNewContent(String newContent) {
        this.newContent = newContent;
    }

    public String getReason() {
        return reason;
    }

    public void setReason(String reason) {
        this.reason = reason;
    }

    @Override
    public String toString() {
        return "EditRequestDTO{" +
                "documentId=" + documentId +
                ", requesterId=" + requesterId +
                ", newContent='" + newContent + '\'' +
                ", reason='" + reason + '\'' +
                '}';
    }
}