package com.greyflame.bluetrail.display;

import java.util.Date;

import org.springframework.format.annotation.DateTimeFormat;

public class BluetrailPlannerModel {
    
    public BluetrailPlannerModel(int startPoint, int endPoint, Date hikeDay) {
        this.startPoint = startPoint;
        this.endPoint = endPoint;
        this.hikeDay = hikeDay;
    }

    private int startPoint;

    private int endPoint;

    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date hikeDay;

    public Date getHikeDay() {
        return hikeDay;
    }

    public void setHikeDay(Date hikeDay) {
        this.hikeDay = hikeDay;
    }

    public int getStartPoint() {
        return startPoint;
    }

    public void setStartPoint(int startPoint) {
        this.startPoint = startPoint;
    }

    public int getEndPoint() {
        return endPoint;
    }

    public void setEndPoint(int endPoint) {
        this.endPoint = endPoint;
    }

    @Override
    public String toString() {
        return "BluetrailDisplayContext [startPoint=" + startPoint + ", startPoint="
                + endPoint + "]";
    }
}
