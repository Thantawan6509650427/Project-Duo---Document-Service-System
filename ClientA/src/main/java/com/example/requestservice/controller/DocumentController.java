package com.example.requestservice.controller;

import com.example.requestservice.dto.SignRequestDTO;
import com.example.requestservice.service.SignatureRequestService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/api/documents")
public class DocumentController {
    
    private static final Logger log = LoggerFactory.getLogger(DocumentController.class);
    
    @Autowired
    private DocumentService documentService;
    
    @Autowired
    private SignatureRequestService signatureRequestService;
    
    /**
     * ClientB เรียก API นี้เพื่อดูเอกสารทั้งหมด
     */
    @GetMapping
    public ResponseEntity<List<DocumentDTO>> getAllDocuments() {
        log.info("📋 ClientB requested all documents");
        List<DocumentDTO> documents = documentService.findAll();
        return ResponseEntity.ok(documents);
    }
    
    /**
     * ClientB เรียก API นี้เพื่อดูเอกสารตาม ID
     */
    @GetMapping("/{id}")
    public ResponseEntity<DocumentDTO> getDocument(@PathVariable Long id) {
        log.info("📄 ClientB requested document ID: {}", id);
        DocumentDTO document = documentService.findById(id);
        return ResponseEntity.ok(document);
    }
    
    /**
     * ClientB เรียก API นี้เพื่อค้นหาเอกสาร
     */
    @GetMapping("/search")
    public ResponseEntity<List<DocumentDTO>> searchDocuments(@RequestParam String keyword) {
        log.info("🔍 ClientB searching for: {}", keyword);
        List<DocumentDTO> documents = documentService.search(keyword);
        return ResponseEntity.ok(documents);
    }
    
    /**
     * สร้างเอกสารใหม่ (สำหรับผู้ใช้ ClientA)
     */
    @PostMapping
    public ResponseEntity<DocumentDTO> createDocument(@RequestBody DocumentDTO dto) {
        log.info("➕ Creating new document: {}", dto.getTitle());
        DocumentDTO created = documentService.create(dto);
        return ResponseEntity.ok(created);
    }
    
    /**
     * อัปเดตเอกสาร (สำหรับผู้ใช้ ClientA)
     */
    @PutMapping("/{id}")
    public ResponseEntity<DocumentDTO> updateDocument(
            @PathVariable Long id, 
            @RequestBody DocumentDTO dto) {
        log.info("✏️ Updating document ID: {}", id);
        DocumentDTO updated = documentService.update(id, dto);
        return ResponseEntity.ok(updated);
    }
}