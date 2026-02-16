package com.example.requestservice.controller;

import com.example.requestservice.dto.EditRequestDTO;
import com.example.requestservice.dto.ServiceResponseDTO;
import com.example.requestservice.dto.SignRequestDTO;
import com.example.requestservice.model.User;
import com.example.requestservice.service.DocumentService;
import com.example.requestservice.service.EditRequestService;
import com.example.requestservice.service.SignatureRequestService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/request")
public class RequestController {
    
    private static final Logger log = LoggerFactory.getLogger(RequestController.class);
    
    @Autowired
    private SignatureRequestService signatureService;
    
    @Autowired
    private EditRequestService editService;
    
    /**
     * ผู้ใช้ ClientA ส่งคำขอลงนามไป ClientB
     */
    @PostMapping("/sign")
    public ResponseEntity<String> requestSignature(@RequestBody SignRequestDTO dto) {
        log.info("🔔 User requesting signature for document ID: {}", dto.getDocumentId());
        
        try {
            String result = signatureService.sendSignatureRequest(dto);
            return ResponseEntity.ok(result);
        } catch (Exception e) {
            log.error("❌ Error: {}", e.getMessage());
            return ResponseEntity.status(500).body("Error: " + e.getMessage());
        }
    }
    
    /**
     * ผู้ใช้ ClientA ส่งคำขอแก้ไขไป ClientB
     */
    @PostMapping("/edit")
    public ResponseEntity<String> requestEdit(@RequestBody EditRequestDTO dto) {
        log.info("📝 User requesting edit for document ID: {}", dto.getDocumentId());
        
        try {
            String result = editService.sendEditRequest(dto);
            return ResponseEntity.ok(result);
        } catch (Exception e) {
            log.error("❌ Error: {}", e.getMessage());
            return ResponseEntity.status(500).body("Error: " + e.getMessage());
        }
    }
}