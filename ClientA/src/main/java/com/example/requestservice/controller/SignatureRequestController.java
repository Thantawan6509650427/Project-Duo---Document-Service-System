package com.example.requestservice.controller;

import com.example.requestservice.dto.SignRequestDTO;
import com.example.requestservice.service.SignatureRequestService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/request/sign")
public class SignatureRequestController {
    
    private static final Logger log = LoggerFactory.getLogger(SignatureRequestController.class);
    
    @Autowired
    private SignatureRequestService signatureRequestService;

    @PostMapping
    public ResponseEntity<String> requestSignature(@RequestBody SignRequestDTO dto) {
        log.info("🔔 Received sign request");
        log.info("   - Document ID: {}", dto.getDocumentId());
        log.info("   - Requester ID: {}", dto.getRequesterId());
        log.info("   - Reason: {}", dto.getReason());
        
        try {
            String result = signatureRequestService.sendSignatureRequest(dto);
            log.info("✅ Sign request completed successfully");
            return ResponseEntity.ok(result);
        } catch (Exception e) {
            log.error("❌ Error processing sign request: {}", e.getMessage(), e);
            return ResponseEntity.status(500).body("Error: " + e.getMessage());
        }
    }
}