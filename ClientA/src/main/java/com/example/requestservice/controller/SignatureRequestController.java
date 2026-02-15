package com.example.requestservice.controller;

import com.example.requestservice.dto.SignRequestDTO;
import com.example.requestservice.service.SignatureRequestService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/request/sign")
public class SignatureRequestController {

    @Autowired
    private SignatureRequestService signatureRequestService;

    @PostMapping
    public String requestSignature(@RequestBody SignRequestDTO dto) {
        return signatureRequestService.sendSignatureRequest(dto);
    }
}
