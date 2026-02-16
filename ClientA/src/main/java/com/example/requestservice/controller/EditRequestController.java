package com.example.requestservice.controller;

import com.example.requestservice.dto.EditRequestDTO;
import com.example.requestservice.service.EditRequestService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/request/edit")
public class EditRequestController {
    
    private static final Logger log = LoggerFactory.getLogger(EditRequestController.class);
    
    @Autowired
    private EditRequestService editRequestService;

    @PostMapping
    public ResponseEntity<String> requestEdit(@RequestBody EditRequestDTO dto) {
        log.info("📝 Received edit request");
        log.info("   - Document ID: {}", dto.getDocumentId());
        log.info("   - Requester ID: {}", dto.getRequesterId());
        log.info("   - New Content: {}", dto.getNewContent());
        log.info("   - Reason: {}", dto.getReason());
        
        try {
            String result = editRequestService.sendEditRequest(dto);
            log.info("✅ Edit request completed successfully");
            return ResponseEntity.ok(result);
        } catch (Exception e) {
            log.error("❌ Error processing edit request: {}", e.getMessage(), e);
            return ResponseEntity.status(500).body("Error: " + e.getMessage());
        }
    }
}