package com.surfapp.spot;


import com.surfapp.feedback.Comment;
import com.surfapp.feedback.Condition;
import jakarta.persistence.*;

import java.util.List;

@Entity
@Table(name = "spots")
public class Spot {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Integer id;
    @Column(name = "name")
    private String name;

    @Column(name = "longitude")
    private Double longitude;
    @Column(name = "latitude")
    private Double latitude;

    @Column(name = "facing")
    private Double facing;
    @OneToMany(mappedBy = "spot", cascade = CascadeType.REMOVE)
    private List<Condition> conditions;

    @OneToMany(mappedBy = "spot", cascade = CascadeType.REMOVE)
    private List<Comment> comments;

    public Spot() {

    }

    public Spot(String name, Double longitude, Double latitude, Double facing) {
        this.name = name;
        this.longitude = longitude;
        this.latitude = latitude;
        this.facing = facing;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Double getLongitude() {
        return longitude;
    }

    public void setLongitude(Double longitude) {
        this.longitude = longitude;
    }

    public Double getLatitude() {
        return latitude;
    }

    public void setLatitude(Double latitude) {
        this.latitude = latitude;
    }

    public Double getFacing() {
        return facing;
    }

    public void setFacing(Double facing) {
        this.facing = facing;
    }
}
