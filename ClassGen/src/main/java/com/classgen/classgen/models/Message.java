package com.classgen.classgen.models;


import jakarta.persistence.*;

@Entity
public class Message {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String content;
    private boolean fromUser;

    @ManyToOne
    @JoinColumn(name = "discussion_id")
    private Discussion discussion;

    public Message() {}

    public Message(String content, boolean fromUser, Discussion discussion) {
        this.content = content;
        this.fromUser = fromUser;
        this.discussion = discussion;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public boolean isFromUser() {
        return fromUser;
    }

    public void setFromUser(boolean fromUser) {
        this.fromUser = fromUser;
    }

    public Discussion getDiscussion() {
        return discussion;
    }

    public void setDiscussion(Discussion discussion) {
        this.discussion = discussion;
    }
}
