package com.classgen.classgen.service;

import com.classgen.classgen.models.GeneratedClass;
import com.classgen.classgen.repositories.GeneratedClassRepository;
import org.springframework.stereotype.Service;

@Service
public class ClassGenerationService {

    private final GeneratedClassRepository generatedClassRepository;

    public ClassGenerationService(GeneratedClassRepository generatedClassRepository) {
        this.generatedClassRepository = generatedClassRepository;
    }

    public GeneratedClass generateClass(String prompt) {
        String className = "GeneratedClass";
        String classContent = "public class GeneratedClass { /* Code */ }";
        GeneratedClass generatedClass = new GeneratedClass(className, classContent);
        return generatedClassRepository.save(generatedClass);
    }

    public String compileClass(Long classId) {
        return "Compilation réussie";
    }

    public String executeClass(Long classId) {
        return "Exécution réussie";
    }
}
