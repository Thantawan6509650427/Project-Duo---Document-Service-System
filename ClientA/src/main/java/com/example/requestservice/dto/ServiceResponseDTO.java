package com.example.requestservice.dto;

public class ServiceResponseDTO {    
    private String status;      // SUCCESS, FAILED
    private String message;
    private Long requestId;

    // Constructors
    public ServiceResponseDTO() {}

    public ServiceResponseDTO(String status, String message) {
        this.status = status;
        this.message = message;
    }

    public ServiceResponseDTO(String status, String message, Long requestId) {
        this.status = status;
        this.message = message;
        this.requestId = requestId;
    }

    // Getters and Setters
    public String getStatus() { return status; }
    public void setStatus(String status) { this.status = status; }
    
    public String getMessage() { return message; }
    public void setMessage(String message) { this.message = message; }
    
    public Long getRequestId() { return requestId; }
    public void setRequestId(Long requestId) { this.requestId = requestId; }
}