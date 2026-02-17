package com.example.requestservice.client;

import com.example.requestservice.dto.EditRequestDTO;
import com.example.requestservice.dto.ServiceResponseDTO;
import com.example.requestservice.dto.SignRequestDTO;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

@Component
public class DocumentServiceClient {
    
    private static final Logger log = LoggerFactory.getLogger(DocumentServiceClient.class);
    
    @Value("${clientb.url}")  // http://localhost:8081
    private String clientBUrl;
    
    private final RestTemplate restTemplate = new RestTemplate();
    
    /**
     * ส่งคำขอลงนามไป ClientB
     */
    public ServiceResponseDTO sendSignRequest(SignRequestDTO dto) {
        try {
            String url = clientBUrl + "/api/services/sign";
            log.info("📤 Sending sign request to ClientB: {}", url);
            
            ServiceResponseDTO response = restTemplate.postForObject(url, dto, ServiceResponseDTO.class);
            log.info("✅ Received response from ClientB: {}", response.getMessage());
            
            return response;
        } catch (Exception e) {
            log.error("❌ Error calling ClientB: {}", e.getMessage());
            return new ServiceResponseDTO("FAILED", "Error: " + e.getMessage());
        }
    }
    
    /**
     * ส่งคำขอแก้ไขไป ClientB
     */
    public ServiceResponseDTO sendEditRequest(EditRequestDTO dto) {
        try {
            String url = clientBUrl + "/api/services/edit";
            log.info("📤 Sending edit request to ClientB: {}", url);
            
            ServiceResponseDTO response = restTemplate.postForObject(url, dto, ServiceResponseDTO.class);
            log.info("✅ Received response from ClientB: {}", response.getMessage());
            
            return response;
        } catch (Exception e) {
            log.error("❌ Error calling ClientB: {}", e.getMessage());
            return new ServiceResponseDTO("FAILED", "Error: " + e.getMessage());
        }
    }
    
    /**
     * เช็คสถานะคำขอจาก ClientB
     */
    public ServiceResponseDTO checkRequestStatus(Long requestId) {
        try {
            String url = clientBUrl + "/api/services/requests/" + requestId;
            return restTemplate.getForObject(url, ServiceResponseDTO.class);
        } catch (Exception e) {
            log.error("❌ Error checking status: {}", e.getMessage());
            return new ServiceResponseDTO("FAILED", "Error: " + e.getMessage());
        }
    }
}