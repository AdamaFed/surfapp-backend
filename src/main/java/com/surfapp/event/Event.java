package com.surfapp.event;


import com.fasterxml.jackson.annotation.JsonFormat;
import jakarta.persistence.*;

import java.time.LocalDateTime;

@Entity
@Table(name = "events")
public class Event {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    Integer id;
    @Column(name = "name")
    String name;

    @Column(name = "description")
    String description;

    @JsonFormat(pattern = "yyyy-MM-dd HH:mm")
    @Column(name = "date", columnDefinition = "DATE")
    LocalDateTime date;



    public Event() {

    }

    public Event(String name, String description, LocalDateTime date) {
        this.name = name;
        this.description = description;
        this.date = date;
    }

    public String getDescription() {
        return description;
    }

    public Integer getId() {
        return id;
    }
    public String getName() {
        return name;
    }
    public LocalDateTime getDate() {
        return date;
    }
}
