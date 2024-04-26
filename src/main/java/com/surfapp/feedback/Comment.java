package com.surfapp.feedback;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.surfapp.spot.Spot;
import com.surfapp.user.User;
import jakarta.persistence.*;
import org.springframework.format.annotation.DateTimeFormat;

import java.time.LocalDateTime;

@Entity
@Table(name = "comments")
public class Comment {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;

    @Column(name = "text")
    private String text;

    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;

    @ManyToOne
    @JoinColumn(name = "spot_id")
    private Spot spot;

    @JsonFormat(pattern = "yyyy-MM-dd HH:mm")
    @Column(name = "date", columnDefinition = "DATE")
    private LocalDateTime date;

    public Comment(){
    }

    public Comment(String text, User user, Spot spot, LocalDateTime date) {
        this.text = text;
        this.user = user;
        this.spot = spot;
        this.date = date;
    }

    public int getId() {
        return id;
    }
    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }
    public User getUser() {
        return user;
    }

    public LocalDateTime getDate() {
        return date;
    }

    public Spot getSpot() {
        return spot;
    }

    @Override
    public String toString() {
        return user.getUsername() + ": " + getText();
    }
}
