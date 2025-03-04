package com.classgen.classgen.models;

import jakarta.persistence.*;

@Entity
public class GeneratedClass {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String className;

    @Column(columnDefinition = "TEXT")
    private String classContent;

    private boolean compiledSuccessfully;

    public GeneratedClass() {}

    public GeneratedClass(String className, String classContent) {
        this.className = className;
        this.classContent = classContent;
        this.compiledSuccessfully = false;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getClassName() {
        return className;
    }

    public void setClassName(String className) {
        this.className = className;
    }

    public String getClassContent() {
        return classContent;
    }

    public void setClassContent(String classContent) {
        this.classContent = classContent;
    }

    public boolean isCompiledSuccessfully() {
        return compiledSuccessfully;
    }

    public void setCompiledSuccessfully(boolean compiledSuccessfully) {
        this.compiledSuccessfully = compiledSuccessfully;
    }
}
