package com.surfapp.feedback;

import jakarta.persistence.*;


public class ConditionDto {

    private Integer spotId;
    private Integer windDirection;
    private Integer windSpeed;
    private Integer rating;


    public ConditionDto() {
    }

    public ConditionDto(Integer spotId, Integer windDirection, Integer windSpeed, Integer rating) {
        this.spotId = spotId;
        this.windDirection = windDirection;
        this.windSpeed = windSpeed;
        this.rating = rating;
    }

    public Integer getWindDirection() {
        return windDirection;
    }

    public Integer getRating() {
        return rating;
    }

    public Integer getSpotId() {
        return spotId;
    }

    public Integer getWindSpeed() {
        return windSpeed;
    }
}
