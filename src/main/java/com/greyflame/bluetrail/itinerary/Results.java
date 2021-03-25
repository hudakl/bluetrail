package com.greyflame.bluetrail.itinerary;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public class Results {
    private String sunrise;
    private String sunset;
    private String day_length;

    public String getSunrise() {
        return sunrise;
    }
    public void setSunrise(String sunrise) {
        this.sunrise = sunrise;
    }
    public String getSunset() {
        return sunset;
    }
    public void setSunset(String sunset) {
        this.sunset = sunset;
    }
    public String getDay_length() {
        return day_length;
    }
    public void setDay_length(String day_length) {
        this.day_length = day_length;
    }
    @Override
    public String toString() {
        return "Results [day_length=" + day_length + ", sunrise=" + sunrise + ", sunset=" + sunset + "]";
    }
}
