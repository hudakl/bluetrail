package com.greyflame.bluetrail.itinerary;

import java.time.LocalTime;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public class SunriseSunset {

    private String status;
    private Results results;

    private LocalTime sunRise;
    private LocalTime sunSet;
    private int dayLength;

    public Results getResults() {
        return results;
    }
    public void setResults(Results results) {
        this.results = results;
    }

    public String getStatus() {
        return status;
    }
    public void setStatus(String status) {
        this.status = status;
    }
    public int getDayLength() {
        return dayLength;
    }
    public void setDayLength(int dayLength) {
        this.dayLength = dayLength;
    }
    public LocalTime getSunRise() {
        return sunRise;
    }
    public void setSunRise(LocalTime sunRise) {
        this.sunRise = sunRise;
    }
    public LocalTime getSunSet() {
        return sunSet;
    }
    public void setSunSet(LocalTime sunSet) {
        this.sunSet = sunSet;
    }

    @Override
    public String toString() {
        return "SunriseSunset [status=" + status + ", results=" + results + "]\n" +
        "Sunrise: " + sunRise +
        "\nSunset: " + sunSet + 
        "\nDay length in seconds: " + dayLength;
    }

}
