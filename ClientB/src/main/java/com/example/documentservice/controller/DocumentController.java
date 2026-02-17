package com.example.documentservice.controller;

import com.example.documentservice.dto.EditCommandDTO;
import com.example.documentservice.dto.SignCommandDTO;
import com.example.documentservice.model.Document;
import com.example.documentservice.service.DocumentService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;
import java.util.List;

@RestController  // ← ต้องมี annotation นี้
@RequestMapping("/documents")  // ← ต้องมี path นี้
public class DocumentController {

    private final DocumentService documentService;

    public DocumentController(DocumentService documentService) {
        this.documentService = documentService;
    }

    // ✅ ดูเอกสารทั้งหมด
    @GetMapping  // ← GET /documents
    public ResponseEntity<List<Document>> getAllDocuments() {
        List<Document> documents = documentService.getAllDocuments();
        return ResponseEntity.ok(documents);
    }

    // ✅ ดูเอกสารตาม ID
    @GetMapping("/{id}")  // ← GET /documents/{id}
    public ResponseEntity<Document> getDocumentById(@PathVariable Long id) {
        Optional<Document> doc = documentService.getDocumentById(id);
        return doc.map(ResponseEntity::ok)
                  .orElse(ResponseEntity.notFound().build());
    }

    // ✅ ลงนามเอกสาร
    @PostMapping("/{id}/sign")
    public ResponseEntity<String> signDocument(@PathVariable Long id, @RequestBody SignCommandDTO signCommand) {
        boolean success = documentService.signDocument(id, signCommand);
        return success ? ResponseEntity.ok("Document signed successfully.")
                       : ResponseEntity.badRequest().body("Cannot sign document.");
    }

    // ✅ แก้ไขเอกสาร
    @PostMapping("/{id}/edit")
    public ResponseEntity<String> editDocument(@PathVariable Long id, @RequestBody EditCommandDTO editCommand) {
        boolean success = documentService.editDocument(id, editCommand);
        return success ? ResponseEntity.ok("Document edited successfully.")
                       : ResponseEntity.badRequest().body("Cannot edit document.");
    }
}