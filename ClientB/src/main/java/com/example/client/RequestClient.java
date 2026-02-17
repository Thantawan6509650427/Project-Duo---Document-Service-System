package com.example.client;

import java.io.OutputStream;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.nio.charset.StandardCharsets;
import java.util.stream.Collectors;

public class RequestClient {

    // ✅ แก้ URL ให้ตรงกับ endpoint ของฝั่ง A
    private static final String EDIT_URL = "http://localhost:8080/documents/{id}/edit";
    private static final String SIGNATURE_URL = "http://localhost:8080/documents/{id}/sign";

    public String sendEditRequest(Long documentId, String editCommand) {
        String json = String.format(
                "{\"requesterId\": 2, \"editorId\": 1, \"editCommand\": \"%s\"}",
                editCommand);
        return sendPost(EDIT_URL.replace("{id}", documentId.toString()), json);
    }

    public String sendSignatureRequest(Long documentId, String comment) {
        String json = String.format(
                "{\"requesterId\": 2, \"providerId\": 1, \"comment\": \"%s\", \"status\": \"SIGNED\"}",
                comment);
        return sendPost(SIGNATURE_URL.replace("{id}", documentId.toString()), json);
    }

    private String sendPost(String targetUrl, String jsonBody) {
        try {
            URL url = new URL(targetUrl);
            HttpURLConnection conn = (HttpURLConnection) url.openConnection();
            conn.setRequestMethod("POST");
            conn.setRequestProperty("Content-Type", "application/json; utf-8");
            conn.setDoOutput(true);

            try (OutputStream os = conn.getOutputStream()) {
                os.write(jsonBody.getBytes(StandardCharsets.UTF_8));
            }

            int responseCode = conn.getResponseCode();
            if (responseCode == 200) {
                try (BufferedReader in = new BufferedReader(new InputStreamReader(conn.getInputStream()))) {
                    return in.lines().collect(Collectors.joining());
                }
            } else {
                return "Error: HTTP " + responseCode;
            }
        } catch (Exception e) {
            return "Error sending request: " + e.getMessage();
        }
    }
}