package com.surfapp.GPT;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;

@Entity
public class ChatElement {

    @Id
    Long id;
    String content;

    public ChatElement(String content) {
        this.content = content;
    }

    public ChatElement() {

    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getId() {
        return id;
    }

    public String getContent() {
        return content;
    }

    @Override
    public String toString() {
        return "Answer {" +
                "'content' =" + content + '}';
    }
}
