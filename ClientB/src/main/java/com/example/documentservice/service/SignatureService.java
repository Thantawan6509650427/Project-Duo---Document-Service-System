package com.example.documentservice.service;

import com.example.documentservice.model.Document;
import com.example.documentservice.repository.DocumentRepository;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class SignatureService {

    private final DocumentRepository documentRepository;

    public SignatureService(DocumentRepository documentRepository) {
        this.documentRepository = documentRepository;
    }

    public Document signDocument(Long documentId, String comment, String status) {
        Optional<Document> optionalDoc = documentRepository.findById(documentId);
        if (optionalDoc.isEmpty()) {
            throw new RuntimeException("Document not found");
        }

        Document doc = optionalDoc.get();
        doc.setStatus(status);
        doc.setContent(doc.getContent() + "\n[ลงนาม]: " + comment);
        return documentRepository.save(doc);
    }
}
