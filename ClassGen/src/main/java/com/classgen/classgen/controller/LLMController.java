package com.classgen.classgen.controller;

import com.classgen.classgen.service.LLMService;
import com.classgen.classgen.service.LLMServiceOpenAI;
import com.classgen.classgen.service.PromptRequest;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestMapping;
import com.classgen.classgen.service.LLMService;
import com.classgen.classgen.service.PromptRequest;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import static com.classgen.classgen.service.CodeCompiler.compileCode;


@RestController
@RequestMapping("/api/llm")
public class LLMController {

    private final LLMService llmService;
    private final LLMServiceOpenAI llmServiceOpenAI;

    public LLMController(LLMService llmService, LLMServiceOpenAI llmServiceOpenAI) {
        this.llmService = llmService;
        this.llmServiceOpenAI = llmServiceOpenAI;
    }

    @PostMapping("/generate")
/*
    public ResponseEntity<String> generateCode(@RequestBody String prompt) {
        String generatedCode = llmServiceOpenAI.generateCode(prompt);
        String cleanResponse = generatedCode.replaceAll("```java", "").replaceAll("```", "").trim();
        return ResponseEntity.ok(cleanResponse);
    }

    @PostMapping("/generateClass")*/
    public ResponseEntity<String> generateCode(@RequestBody String prompt) {
        int i = 0;
        String generatedClass = llmServiceOpenAI.generateCode(prompt);
        String generatedCode = generatedClass.replaceAll("```java", "").replaceAll("```", "").trim();
        while(1 == compileCode(generatedCode).getStatus() && i < 1){
            System.out.println("le resultat de la compilation du code est : " + compileCode(generatedCode).getStatus());
            if (generatedCode == null || generatedCode.isEmpty() ) {
                return ResponseEntity.badRequest().body("Code generation failed.");
            }
            System.out.println(compileCode(generatedCode).getOutput());
            prompt = "The code that you give me does not compile and i have this error during compilation of this code : "
                    + generatedCode;
            generatedCode = llmServiceOpenAI.generateCode(prompt);
            ++i;
        }

        return ResponseEntity.ok(generatedCode);
    }
}