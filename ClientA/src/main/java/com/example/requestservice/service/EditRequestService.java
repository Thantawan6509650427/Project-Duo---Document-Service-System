package com.example.requestservice.service;

import com.example.requestservice.model.EditRequestDTO;
import com.example.requestservice.model.RequestLog;
import com.example.requestservice.repository.RequestLogRepository;
import com.example.requestservice.client.DocumentServiceClient; 
import com.example.requestservice.model.ServiceResponseDTO;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.time.LocalDateTime;

@Service
public class EditRequestService {
    
    private static final Logger log = LoggerFactory.getLogger(EditRequestService.class);
    
    @Autowired
    private DocumentServiceClient client;
    
    @Autowired
    private RequestLogRepository logRepository;
    
    /**
     * ส่งคำขอแก้ไขไป ClientB
     */
    public String sendEditRequest(EditRequestDTO dto) {
        log.info("📝 Processing edit request for document ID: {}", dto.getDocumentId());
        
        try {
            // 1. บันทึก log ใน ClientA
            RequestLog requestLog = new RequestLog();
            requestLog.setDocumentId(dto.getDocumentId());
            requestLog.setRequesterId(dto.getRequesterId());
            requestLog.setType("EDIT");
            requestLog.setReason(dto.getReason());
            requestLog.setStatus("SENT");
            requestLog.setSentAt(LocalDateTime.now());
            logRepository.save(requestLog);
            
            log.info("💾 Saved edit request log with ID: {}", requestLog.getId());
            
            // 2. ส่งคำขอไป ClientB
            ServiceResponseDTO response = client.sendEditRequest(dto);
            
            // 3. อัปเดตสถานะ log
            requestLog.setStatus(response.getStatus());
            requestLog.setResponseMessage(response.getMessage());
            requestLog.setCompletedAt(LocalDateTime.now());
            logRepository.save(requestLog);
            
            log.info("✅ Edit request completed with status: {}", response.getStatus());
            
            return response.getMessage();
            
        } catch (Exception e) {
            log.error("❌ Error processing edit request: {}", e.getMessage(), e);
            throw new RuntimeException("Failed to process edit request: " + e.getMessage());
        }
    }
}