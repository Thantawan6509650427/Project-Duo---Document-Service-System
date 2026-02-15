package com.example.requestservice.dto;

public class SignRequestDTO {
    private Long documentId;
    private String requester;

    // Getter and Setter
    public Long getDocumentId() {
        return documentId;
    }
    public void setDocumentId(Long documentId) {
        this.documentId = documentId;
    }

    public String getRequester() {
        return requester;
    }
    public void setRequester(String requester) {
        this.requester = requester;
    }
}
