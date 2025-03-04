package com.classgen.classgen.controller;

import com.classgen.classgen.service.LLMService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@RestController
@RequestMapping("/chatbot")
public class ChatbotController {

    @Autowired
    private LLMService llmService;

    @PostMapping("/process")
    public ResponseEntity<String> processText(@RequestBody Map<String, String> payload) {
        String text = payload.get("text"); // Récupère le texte envoyé depuis le frontend
        String response = llmService.generateCode(text); // Appelle le service LLM
        return ResponseEntity.ok(response); // Renvoie la réponse au frontend
    }
}
