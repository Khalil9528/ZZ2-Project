package com.classgen.classgen.service;

import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import org.json.JSONObject;

@Service
public class LLMServiceOpenAI {

    private final String OPENAI_API_URL = "https://api.openai.com/v1/chat/completions";
    private final String API_KEY = "openapikey"; // Remplace par ta clé API
    private final RestTemplate restTemplate;

    public LLMServiceOpenAI(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }

    public String generateCode(String prompt) {
        try {
            HttpHeaders headers = new HttpHeaders();
            headers.set("Authorization", "Bearer " + API_KEY);
            headers.set("Content-Type", "application/json");

            // Construction de la requête JSON
            JSONObject requestBody = new JSONObject();
            requestBody.put("model", "gpt-4"); // Ou "gpt-3.5-turbo" selon ton choix
            requestBody.put("messages", new JSONObject[]{
                    new JSONObject().put("role", "system").put("content", "You are an AI that generates clean Java code."),
                    new JSONObject().put("role", "user").put("content", prompt)
            });
            requestBody.put("temperature", 0.7);

            HttpEntity<String> entity = new HttpEntity<>(requestBody.toString(), headers);
            ResponseEntity<String> response = restTemplate.exchange(OPENAI_API_URL, HttpMethod.POST, entity, String.class);

            // Extraction de la réponse
            JSONObject jsonResponse = new JSONObject(response.getBody());
            String codeGenerated = jsonResponse.getJSONArray("choices").getJSONObject(0).getJSONObject("message").getString("content");

            return formatCode(codeGenerated);
        } catch (Exception e) {
            e.printStackTrace();
            return "Erreur lors de la génération du code avec OpenAI : " + e.getMessage();
        }
    }

    private String formatCode(String rawCode) {
        return "```java\n" + rawCode + "\n```";
    }
}
