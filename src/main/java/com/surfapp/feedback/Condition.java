package com.surfapp.feedback;

import com.surfapp.spot.Spot;
import jakarta.persistence.*;

@Entity
@Table(name = "conditions")
public class Condition {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Integer id;

    @Column(name = "wind_direction")
    private Integer windDirection;
    @Column(name = "wind_speed")
    private Integer windSpeed;

    @Column(name = "rating")
    private Integer rating;

    @ManyToOne
    @JoinColumn(name = "spot_id")
    private Spot spot;

    public Condition() {
    }

    public Condition(Integer windDirection, Integer windSpeed, Integer rating, Spot spot) {
        this.windDirection = windDirection;
        this.windSpeed = windSpeed;
        this.rating = rating;
        this.spot = spot;
    }

    public Integer getId() {
        return id;
    }

    public Integer getWindDirection() {
        return windDirection;
    }

    public Integer getRating() {
        return rating;
    }

    public Spot getSpot() {
        return spot;
    }

    public Integer getWindSpeed() {
        return windSpeed;
    }
}
