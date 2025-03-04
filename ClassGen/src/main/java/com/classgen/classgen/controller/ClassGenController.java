package com.classgen.classgen.controller;

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
@RequestMapping("/api")
public class ClassGenController {

    private static final Logger logger = LoggerFactory.getLogger(ClassGenController.class);
    private final LLMService llmService;

    public ClassGenController(LLMService llmService) {
        this.llmService = llmService;
    }

    @PostMapping("/generateClass")
    public ResponseEntity<String> generateClass(@RequestBody PromptRequest request) {

        int i = 0;
        logger.info("Received request to generate class with prompt: {}", request.getPrompt());

        String prompt = request.getPrompt();
        String generatedCode = llmService.generateCode(prompt);
        while(1 == compileCode(generatedCode).getStatus() && i < 2){
            System.out.println("le resultat de la compilation du code est : " + compileCode(generatedCode).getStatus());
            if (generatedCode == null || generatedCode.isEmpty() ) {
                logger.warn("Code generation failed for prompt: {}", prompt);
                return ResponseEntity.badRequest().body("Code generation failed.");
            }
            System.out.println(compileCode(generatedCode).getOutput());
            prompt = "The code that you give me does not compile and i have this error during compilation of this code : "
                            + generatedCode;
            generatedCode = llmService.generateCode(prompt);
            ++i;
        }

        logger.info("Code generation successful.");
        return ResponseEntity.ok(generatedCode);
    }
}
