package com.example.requestservice.dto;

public class EditRequestDTO {
    private Long documentId;
    private String reason;

    // Getter and Setter
    public Long getDocumentId() {
        return documentId;
    }
    public void setDocumentId(Long documentId) {
        this.documentId = documentId;
    }

    public String getReason() {
        return reason;
    }
    public void setReason(String reason) {
        this.reason = reason;
    }
}
