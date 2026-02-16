package com.example.requestservice.model;

import jakarta.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(name = "request_log")
public class RequestLog {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "document_id")
    private Long documentId;
    
    @Column(name = "requester_id")
    private Long requesterId;
    
    @Column(name = "type", length = 20)
    private String type; // EDIT or SIGN
    
    @Column(name = "detail", length = 500)
    private String detail;
    
    @Column(name = "reason", length = 500)
    private String reason;
    
    @Column(name = "requested_at")
    private LocalDateTime requestedAt = LocalDateTime.now();

    // Constructors
    public RequestLog() {}

    public RequestLog(Long documentId, Long requesterId, String type, String detail, String reason) {
        this.documentId = documentId;
        this.requesterId = requesterId;
        this.type = type;
        this.detail = detail;
        this.reason = reason;
        this.requestedAt = LocalDateTime.now();
    }

    // Getters and Setters
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

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

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getDetail() {
        return detail;
    }

    public void setDetail(String detail) {
        this.detail = detail;
    }

    public String getReason() {
        return reason;
    }

    public void setReason(String reason) {
        this.reason = reason;
    }

    public LocalDateTime getRequestedAt() {
        return requestedAt;
    }

    public void setRequestedAt(LocalDateTime requestedAt) {
        this.requestedAt = requestedAt;
    }

    @Override
    public String toString() {
        return "RequestLog{" +
                "id=" + id +
                ", documentId=" + documentId +
                ", requesterId=" + requesterId +
                ", type='" + type + '\'' +
                ", detail='" + detail + '\'' +
                ", reason='" + reason + '\'' +
                ", requestedAt=" + requestedAt +
                '}';
    }
}