package com.greyflame.bluetrail.display;

import java.util.Date;
import java.util.List;

import com.greyflame.bluetrail.persistence.LongDistanceTrail;
import com.greyflame.bluetrail.persistence.StampPoint;
import com.greyflame.bluetrail.persistence.TrailSection;

import org.springframework.format.annotation.DateTimeFormat;

public class BluetrailDisplayContext {
    
    public BluetrailDisplayContext(LongDistanceTrail ldt, StampPoint start, StampPoint end, Date hikeDay) {
        this.startPointSections = ldt.getTrailSections();
        this.endPointSections = ldt.getTrailSections();

        this.startPointSection = start.getTrailSection().getOfficialId();
        this.endPointSection = end.getTrailSection().getOfficialId();

        this.startPoints = start.getTrailSection().getStampPoints();
        this.endPoints = end.getTrailSection().getStampPoints();

        this.startPoint = start;
        this.endPoint = end;
        
        this.hikeDay = hikeDay;
    }

    public BluetrailDisplayContext(LongDistanceTrail ldt) {
        this.startPointSections = ldt.getTrailSections();
        this.endPointSections = ldt.getTrailSections();

        this.startPointSection = startPointSections.get(0).getOfficialId();
        this.endPointSection = endPointSections.get(0).getOfficialId();

        this.startPoints = startPointSections.get(0).getStampPoints();
        this.endPoints = endPointSections.get(0).getStampPoints();

        this.startPoint = startPoints.get(0);
        this.endPoint = endPoints.get(0);

        this.hikeDay = new Date();
    
    }
        
    private List<TrailSection> startPointSections;

    private List<TrailSection> endPointSections;

    private List<StampPoint> startPoints;

    private List<StampPoint> endPoints;

    private String startPointSection;

    private String endPointSection;

    private StampPoint startPoint;

    private StampPoint endPoint;

    private float distance;

    private String time;

    private int elevation;

    private boolean oneDay;

    private boolean result;

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

    public StampPoint getStartPoint() {
        return startPoint;
    }

    public void setStartPoint(StampPoint startPoint) {
        this.startPoint = startPoint;
    }

    public StampPoint getEndPoint() {
        return endPoint;
    }

    public void setEndPoint(StampPoint endPoint) {
        this.endPoint = endPoint;
    }

    @Override
    public String toString() {
        return "BluetrailDisplayContext [endPointSection=" + endPointSection + ", startPointSection="
                + startPointSection + "]";
    }

    public int getElevation() {
        return elevation;
    }

    public void setElevation(int elevation) {
        this.elevation = elevation;
    }

    public boolean isOneDay() {
        return oneDay;
    }

    public void setOneDay(boolean oneDay) {
        this.oneDay = oneDay;
    }

    public float getDistance() {
        return distance;
    }

    public void setDistance(float distance) {
        this.distance = distance;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public boolean isResult() {
        return result;
    }

    public void setResult(boolean result) {
        this.result = result;
    }


}
