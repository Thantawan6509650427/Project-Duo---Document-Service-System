package com.example.client;

import java.io.OutputStream;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.nio.charset.StandardCharsets;
import java.util.stream.Collectors;

public class RequestClient {

    private static final String EDIT_URL = "http://localhost:8080/api/edit-request";
    private static final String SIGNATURE_URL = "http://localhost:8080/api/signature-request";

    public String sendEditRequest(Long documentId, String comment) {
        String json = String.format(
                "{\"requesterId\": 2, \"providerId\": 1, \"documentId\": %d, \"comment\": \"%s\", \"status\": \"EDIT\"}",
                documentId, comment);
        return sendPost(EDIT_URL, json);
    }

    public String sendSignatureRequest(Long documentId, String comment) {
        String json = String.format(
                "{\"requesterId\": 2, \"providerId\": 1, \"documentId\": %d, \"comment\": \"%s\", \"status\": \"SIGN\"}",
                documentId, comment);
        return sendPost(SIGNATURE_URL, json);
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

            try (BufferedReader in = new BufferedReader(new InputStreamReader(conn.getInputStream()))) {
                return in.lines().collect(Collectors.joining());
            }
        } catch (Exception e) {
            return "Error sending request: " + e.getMessage();
        }
    }
}
