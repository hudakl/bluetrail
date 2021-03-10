package com.greyflame.bluetrail;

import java.util.Date;
import java.util.List;

import com.greyflame.bluetrail.persistence.LongDistanceTrail;
import com.greyflame.bluetrail.persistence.StampPoint;
import com.greyflame.bluetrail.persistence.TrailSection;

import org.springframework.format.annotation.DateTimeFormat;

public class BluetrailDisplayContext {
    
    public BluetrailDisplayContext(LongDistanceTrail ldt) {
        this.startPointSections = ldt.getTrailSections();
        this.endPointSections = ldt.getTrailSections();

        this.startPointSection = startPointSections.get(0).getOfficialId();
        this.endPointSection = endPointSections.get(0).getOfficialId();

        this.startPoints = startPointSections.get(0).getStampPoints();
        this.endPoints = endPointSections.get(0).getStampPoints();

        this.startPoint = startPoints.get(0).getNumber();
        this.endPoint = endPoints.get(0).getNumber();

        this.hikeDay = new Date();

        
    }
        
    private List<TrailSection> startPointSections;

    private List<TrailSection> endPointSections;

    private List<StampPoint> startPoints;

    private List<StampPoint> endPoints;

    private String startPointSection;

    private String endPointSection;

    private int startPoint;

    private int endPoint;

    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date hikeDay;

    public List<TrailSection> getStartPointSections() {
        return startPointSections;
    }

    public void setStartPointSections(List<TrailSection> startPointSections) {
        this.startPointSections = startPointSections;
    }

    public List<TrailSection> getEndPointSections() {
        return endPointSections;
    }

    public void setEndPointSections(List<TrailSection> endPointSections) {
        this.endPointSections = endPointSections;
    }

    public String getStartPointSection() {
        return startPointSection;
    }

    public void setStartPointSection(String startPointSection) {
        this.startPointSection = startPointSection;
    }

    public String getEndPointSection() {
        return endPointSection;
    }

    public void setEndPointSection(String endPointSection) {
        this.endPointSection = endPointSection;
    }

    public Date getHikeDay() {
        return hikeDay;
    }

    public void setHikeDay(Date hikeDay) {
        this.hikeDay = hikeDay;
    }

    public List<StampPoint> getStartPoints() {
        return startPoints;
    }

    public void setStartPoints(List<StampPoint> startPoints) {
        this.startPoints = startPoints;
    }

    public List<StampPoint> getEndPoints() {
        return endPoints;
    }

    public void setEndPoints(List<StampPoint> endPoints) {
        this.endPoints = endPoints;
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
}
