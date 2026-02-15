package com.example.documentservice.service;

import com.example.documentservice.dto.EditCommandDTO;
import com.example.documentservice.dto.SignCommandDTO;
import com.example.documentservice.model.Document;
import com.example.documentservice.repository.DocumentRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class DocumentService {

    private final DocumentRepository documentRepository;

    public DocumentService(DocumentRepository documentRepository) {
        this.documentRepository = documentRepository;
    }

    public List<Document> getAllDocuments() {
        return documentRepository.findAll();
    }

    public Optional<Document> getDocumentById(Long id) {
        return documentRepository.findById(id);
    }

    public List<Document> getDocumentsByOwnerId(Long ownerId) {
        return documentRepository.findByOwnerId(ownerId);
    }

    public Document saveDocument(Document document) {
        return documentRepository.save(document);
    }

    public void deleteDocument(Long id) {
        documentRepository.deleteById(id);
    }

    public boolean signDocument(Long id, SignCommandDTO signCommand) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'signDocument'");
    }

    public boolean editDocument(Long id, EditCommandDTO editCommand) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'editDocument'");
    }
}
