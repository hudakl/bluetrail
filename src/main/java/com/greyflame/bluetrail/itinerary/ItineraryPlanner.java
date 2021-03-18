package com.greyflame.bluetrail.itinerary;

import java.util.LinkedList;

import com.greyflame.bluetrail.persistence.BusStop;
import com.greyflame.bluetrail.persistence.StampPoint;

public class ItineraryPlanner {
    
    public ItineraryPlanner(LinkedList<StampPoint> stampPoints, boolean westward) {
        this.stampPoints = stampPoints;
        this.startBusStop = stampPoints.getFirst().getBusStop();
        this.endBusStop = stampPoints.getLast().getBusStop();

        int time = startBusStop.getTimeToStamp();
        this.allDistance = startBusStop.getDistanceOfStamp();
        this.allElevation = startBusStop.getElevToStamp();

        stampPoints.removeLast();

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
       
        time += endBusStop.getTimeToStamp();
        this.allDistance += endBusStop.getDistanceOfStamp();
        this.allElevation += endBusStop.getElevToStamp();

        this.allTime = (time / 60) + " hours and " + (time % 60) + " minutes";
        this.allDistance /= 1000;
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
    
    private LinkedList<StampPoint> stampPoints;
    private String allTime;
    private float allDistance;
    private int allElevation;

    private BusStop startBusStop;
    private BusStop endBusStop;

}
