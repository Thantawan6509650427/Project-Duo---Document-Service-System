package com.example.requestservice.service;

import com.example.requestservice.client.DocumentClient;
import com.example.requestservice.dto.SignRequestDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class SignatureRequestService {

    @Autowired
    private DocumentClient documentClient;

    public String sendSignatureRequest(SignRequestDTO dto) {
        return documentClient.sendSignatureRequest(dto);
    }
}
