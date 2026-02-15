package com.example.requestservice.service;

import com.example.requestservice.client.DocumentClient;
import com.example.requestservice.dto.EditRequestDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class EditRequestService {

    @Autowired
    private DocumentClient documentClient;

    public String sendEditRequest(EditRequestDTO dto) {
        return documentClient.sendEditRequest(dto);
    }
}
