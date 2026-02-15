package com.example.documentservice.service;

import com.example.documentservice.model.Document;
import com.example.documentservice.repository.DocumentRepository;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class EditService {

    private final DocumentRepository documentRepository;

    public EditService(DocumentRepository documentRepository) {
        this.documentRepository = documentRepository;
    }

    public Document requestEdit(Long documentId, String editCommand) {
        Optional<Document> optionalDoc = documentRepository.findById(documentId);
        if (optionalDoc.isEmpty()) {
            throw new RuntimeException("Document not found");
        }

        Document doc = optionalDoc.get();
        // ตัวอย่าง: editCommand = "เปลี่ยนชื่อผู้รับเป็น Tantawan"
        // สมมุติว่าเปลี่ยน content โดยตรง (คุณสามารถแยก parsing ได้ภายหลัง)
        doc.setContent(doc.getContent() + "\n[แก้ไข]: " + editCommand);
        return documentRepository.save(doc);
    }
}
