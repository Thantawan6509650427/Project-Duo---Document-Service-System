package com.example.requestservice.repository;

import com.example.requestservice.model.RequestLog;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;

public interface RequestLogRepository extends JpaRepository<RequestLog, Long> {
    
    List<RequestLog> findByDocumentId(Long documentId);
    
    List<RequestLog> findByRequesterId(Long requesterId);
    
    List<RequestLog> findByStatus(String status);
    
    List<RequestLog> findByType(String type);
}