package com.classgen.classgen.service;

import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import org.json.JSONObject;
import org.springframework.stereotype.Service;
import javax.tools.JavaCompiler;
import javax.tools.ToolProvider;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintStream;
import java.lang.reflect.Method;

@Service
public class LLMService {

    private final String LLM_API_URL = "http://localhost:11434/api/generate";
    private final RestTemplate restTemplate;

    public LLMService(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }

    public String processPrompt(String text) {
        // Simuler une réponse du chatbot
        return "Réponse générée pour : " + text;
    }


    public String generateCode(String prompt) {
        LLMRequest request = new LLMRequest("llama3.2", prompt);
        try {
            System.out.println("Sending request to LLM API: " + LLM_API_URL);

            // Capture the response as raw string
            String response = restTemplate.postForObject(LLM_API_URL, request, String.class);

            StringBuilder concatenatedResponse = new StringBuilder();

            String[] jsonLines = response.split("\n");

            // Loop through each line, parse it, and extract the "response" field
            for (String line : jsonLines) {
                JSONObject jsonObject = new JSONObject(line);
                String responseString = jsonObject.getString("response");
                concatenatedResponse.append(responseString);
            }

            return concatenatedResponse.toString();

        } catch (Exception e) {
            e.printStackTrace();
            System.err.println("Error during API call: " + e.getMessage());
            return "Error during code generation " + e;
        }
    }
}
