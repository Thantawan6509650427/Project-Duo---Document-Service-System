package com.example.requestservice.client;

import com.example.requestservice.dto.EditRequestDTO;
import com.example.requestservice.dto.SignRequestDTO;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.stereotype.Component;

import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.URL;

@Component
public class DocumentClient {

    private final ObjectMapper objectMapper = new ObjectMapper();

    public String sendEditRequest(EditRequestDTO dto) {
        return sendPostRequest("http://localhost:9090/document/edit", dto);
    }

    public String sendSignatureRequest(SignRequestDTO dto) {
        return sendPostRequest("http://localhost:9090/document/sign", dto);
    }

    private String sendPostRequest(String endpoint, Object data) {
        try {
            URL url = new URL(endpoint);
            HttpURLConnection con = (HttpURLConnection) url.openConnection();
            con.setRequestMethod("POST");
            con.setRequestProperty("Content-Type", "application/json");
            con.setDoOutput(true);

            String jsonInput = objectMapper.writeValueAsString(data);
            try (OutputStream os = con.getOutputStream()) {
                os.write(jsonInput.getBytes());
                os.flush();
            }

            int status = con.getResponseCode();
            return "Response code: " + status;
        } catch (Exception e) {
            return "Error: " + e.getMessage();
        }
    }
}
