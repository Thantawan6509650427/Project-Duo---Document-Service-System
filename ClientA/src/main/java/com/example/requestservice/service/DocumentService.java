package com.example.requestservice.service;

import com.example.requestservice.model.DocumentDTO;
import com.example.requestservice.model.Document;
import com.example.requestservice.repository.DocumentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class DocumentService {
    
    @Autowired
    private DocumentRepository documentRepository;
    
    /**
     * ดึงเอกสารทั้งหมด (ให้ ClientB เรียก)
     */
    public List<DocumentDTO> findAll() {
        return documentRepository.findAll().stream()
                .map(this::convertToDTO)
                .collect(Collectors.toList());
    }
    
    /**
     * ดึงเอกสารตาม ID (ให้ ClientB เรียก)
     */
    public DocumentDTO findById(Long id) {
        Document doc = documentRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Document not found"));
        return convertToDTO(doc);
    }
    
    /**
     * ค้นหาเอกสาร (ให้ ClientB เรียก)
     */
    public List<DocumentDTO> search(String keyword) {
        return documentRepository.searchByKeyword(keyword).stream()
                .map(this::convertToDTO)
                .collect(Collectors.toList());
    }
    
    /**
     * สร้างเอกสารใหม่
     */
    public DocumentDTO create(DocumentDTO dto) {
        Document doc = new Document();
        doc.setTitle(dto.getTitle());
        doc.setContent(dto.getContent());
        doc.setOwnerId(dto.getOwnerId());
        doc.setStatus("DRAFT");
        doc.setCreatedAt(LocalDateTime.now());
        
        Document saved = documentRepository.save(doc);
        return convertToDTO(saved);
    }
    
    /**
     * อัปเดตเอกสาร
     */
    public DocumentDTO update(Long id, DocumentDTO dto) {
        Document doc = documentRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Document not found"));
        
        doc.setTitle(dto.getTitle());
        doc.setContent(dto.getContent());
        doc.setStatus(dto.getStatus());
        doc.setUpdatedAt(LocalDateTime.now());
        
        Document updated = documentRepository.save(doc);
        return convertToDTO(updated);
    }
    
    // Helper method
    private DocumentDTO convertToDTO(Document doc) {
        DocumentDTO dto = new DocumentDTO();
        dto.setId(doc.getId());
        dto.setTitle(doc.getTitle());
        dto.setContent(doc.getContent());
        dto.setOwnerId(doc.getOwnerId());
        dto.setStatus(doc.getStatus());
        dto.setCreatedAt(doc.getCreatedAt());
        dto.setUpdatedAt(doc.getUpdatedAt());
        return dto;
    }
}