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
    private final SignatureService signatureService;
    private final EditService editService;

    public DocumentService(DocumentRepository documentRepository, 
                          SignatureService signatureService,
                          EditService editService) {
        this.documentRepository = documentRepository;
        this.signatureService = signatureService;
        this.editService = editService;
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

    // ✅ Implement signDocument
    public boolean signDocument(Long id, SignCommandDTO signCommand) {
        try {
            signatureService.signDocument(id, signCommand.getComment(), signCommand.getStatus());
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    // ✅ Implement editDocument
    public boolean editDocument(Long id, EditCommandDTO editCommand) {
        try {
            editService.requestEdit(id, editCommand.getEditCommand());
            return true;
        } catch (Exception e) {
            return false;
        }
    }
}