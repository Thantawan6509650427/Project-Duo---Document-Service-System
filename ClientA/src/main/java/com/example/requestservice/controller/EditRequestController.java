package com.example.requestservice.controller;

import com.example.requestservice.dto.EditRequestDTO;
import com.example.requestservice.service.EditRequestService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/request/edit")
public class EditRequestController {

    @Autowired
    private EditRequestService editRequestService;

    @PostMapping
    public String requestEdit(@RequestBody EditRequestDTO dto) {
        return editRequestService.sendEditRequest(dto);
    }
}
