package com.example.requestservice.client;

import com.example.requestservice.dto.EditRequestDTO;
import com.example.requestservice.dto.SignRequestDTO;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.stereotype.Component;

import java.io.OutputStream;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.nio.charset.StandardCharsets;
import java.util.stream.Collectors;

@Component
public class DocumentClient {

    private final ObjectMapper objectMapper = new ObjectMapper();

    // ✅ ส่งคำขอไปที่ ClientB (port 8081)
    public String sendEditRequest(EditRequestDTO dto) {
        String url = "http://localhost:8081/documents/" + dto.getDocumentId() + "/edit";
        String json = String.format(
            "{\"requesterId\": 2, \"editorId\": 1, \"editCommand\": \"%s\"}",
            dto.getReason()
        );
        return sendPostRequest(url, json);
    }

    public String sendSignatureRequest(SignRequestDTO dto) {
        String url = "http://localhost:8081/documents/" + dto.getDocumentId() + "/sign";
        String json = String.format(
            "{\"requesterId\": 2, \"providerId\": 1, \"comment\": \"%s\", \"status\": \"SIGNED\"}",
            dto.getRequester()
        );
        return sendPostRequest(url, json);
    }

    private String sendPostRequest(String endpoint, String data) {
        try {
            URL url = new URL(endpoint);
            HttpURLConnection con = (HttpURLConnection) url.openConnection();
            con.setRequestMethod("POST");
            con.setRequestProperty("Content-Type", "application/json");
            con.setDoOutput(true);

            try (OutputStream os = con.getOutputStream()) {
                os.write(data.getBytes(StandardCharsets.UTF_8));
                os.flush();
            }

            int status = con.getResponseCode();
            if (status >= 200 && status < 300) {
                try (BufferedReader in = new BufferedReader(new InputStreamReader(con.getInputStream()))) {
                    return in.lines().collect(Collectors.joining());
                }
            } else {
                return "Error: HTTP " + status;
            }
        } catch (Exception e) {
            return "Error: " + e.getMessage();
        }
    }
}