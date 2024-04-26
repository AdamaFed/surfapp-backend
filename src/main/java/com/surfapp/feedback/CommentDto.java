package com.surfapp.feedback;

import com.fasterxml.jackson.annotation.JsonFormat;

import java.time.LocalDateTime;

public class CommentDto {
    private String text;
    private String username;
    private Integer spotId;
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm")
    private LocalDateTime date;

    public CommentDto(String text, String username, Integer spotId, LocalDateTime date) {
        this.text = text;
        this.username = username;
        this.spotId = spotId;
        this.date = date;
    }

    public CommentDto() {
    }

    public String getText() {
        return text;
    }

    public String getUsername() {
        return username;
    }

    public Integer getSpotId() {
        return spotId;
    }

    public LocalDateTime getDate() {
        return date;
    }
}
