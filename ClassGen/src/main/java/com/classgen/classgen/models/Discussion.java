package com.classgen.classgen.models;

import jakarta.persistence.*;
import java.time.LocalDateTime;
import java.util.List;

@Entity
public class Discussion {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private LocalDateTime timestamp;

    @OneToMany(mappedBy = "discussion", cascade = CascadeType.ALL)
    private List<Message> messages;

    private String llmUsed; // Nom du LLM utilisé

    public Discussion() {
        this.timestamp = LocalDateTime.now();
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public LocalDateTime getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(LocalDateTime timestamp) {
        this.timestamp = timestamp;
    }

    public List<Message> getMessages() {
        return messages;
    }

    public void setMessages(List<Message> messages) {
        this.messages = messages;
    }

    public String getLlmUsed() {
        return llmUsed;
    }

    public void setLlmUsed(String llmUsed) {
        this.llmUsed = llmUsed;
    }
}
