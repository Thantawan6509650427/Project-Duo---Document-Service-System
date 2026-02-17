package com.example.requestservice.model;

import com.example.requestservice.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import java.util.List;

public interface DocumentRepository extends JpaRepository<Document, Long> {
    
    List<Document> findByOwnerId(Long ownerId);
    
    List<Document> findByStatus(String status);
    
    @Query("SELECT d FROM Document d WHERE d.title LIKE %:keyword% OR d.content LIKE %:keyword%")
    List<Document> searchByKeyword(@Param("keyword") String keyword);
}
public class Document {
    
}
