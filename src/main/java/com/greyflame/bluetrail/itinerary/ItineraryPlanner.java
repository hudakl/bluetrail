package com.greyflame.bluetrail.itinerary;

import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.Date;
import java.util.LinkedList;
import java.util.TimeZone;

import com.greyflame.bluetrail.persistence.BusStop;
import com.greyflame.bluetrail.persistence.StampPoint;

import org.springframework.web.client.RestTemplate;

public class ItineraryPlanner {
    
    public ItineraryPlanner(LinkedList<StampPoint> stampPoints, boolean westward, Date hikeDay) {
        this.stampPoints = stampPoints;
        this.startBusStop = stampPoints.getFirst().getBusStop();
        this.endBusStop = stampPoints.getLast().getBusStop();

        int time = startBusStop.getTimeToStamp();
        this.allDistance = startBusStop.getDistanceOfStamp();
        this.allElevation = startBusStop.getElevToStamp();

        StampPoint last = stampPoints.removeLast();

        for (StampPoint stampPoint: stampPoints) {
            if (westward) {
                time += stampPoint.getTimeWestward();
                this.allDistance += stampPoint.getDistWestward();
                this.allElevation += stampPoint.getElevWestward();
            }
            else {
                time += stampPoint.getTimeEastward();
                this.allDistance += stampPoint.getDistEastward();
                this.allElevation += stampPoint.getElevEastward();
            }
        }
       
        stampPoints.add(last);
        time += endBusStop.getTimeToStamp();

        this.time = time;

        System.out.println(this.time);

        this.allDistance += endBusStop.getDistanceOfStamp();
        this.allElevation += endBusStop.getElevToStamp();

        this.allTime = (time / 60) + " hours and " + (time % 60) + " minutes";
        this.allDistance /= 1000;

        configSunset(hikeDay);
    }

    public String getAllTime() {
        return allTime;
    }

    public float getAllDistance() {
        return allDistance;
    }

    public int getAllElevation() {
        return allElevation;
    }

    public boolean isOneDay() {
        return sunriseSunset.getDayLength() > time;
    }

    private void configSunset(Date hikeDay) {
        String uri = "https://api.sunrise-sunset.org/json?lat=47.5545259&lng=18.9987329&date=2021-03-24&formatted=0";
        RestTemplate restTemplate = new RestTemplate();

        sunriseSunset = restTemplate.getForObject(uri, SunriseSunset.class);

        TimeZone timeZone = TimeZone.getTimeZone("Europe/Budapest");
        int timeZoneOffset = timeZone.getOffset(hikeDay.getTime()) / 3600000;

        System.out.println(timeZone);
        System.out.println(timeZoneOffset);

        sunriseSunset.setSunRise(
            LocalTime.parse(
                sunriseSunset.getResults().getSunrise(),DateTimeFormatter.ISO_DATE_TIME).plusHours(timeZoneOffset));
        sunriseSunset.setSunSet(
            LocalTime.parse(
                sunriseSunset.getResults().getSunset(),DateTimeFormatter.ISO_DATE_TIME).plusHours(timeZoneOffset));

        sunriseSunset.setDayLength(
            Integer.parseInt(sunriseSunset.getResults().getDay_length()) / 60);

        System.out.println(sunriseSunset);
    }

    private LinkedList<StampPoint> stampPoints;
    private String allTime;
    private float allDistance;
    private int allElevation;

    private BusStop startBusStop;
    private BusStop endBusStop;
    private int time;
    private SunriseSunset sunriseSunset;
}
