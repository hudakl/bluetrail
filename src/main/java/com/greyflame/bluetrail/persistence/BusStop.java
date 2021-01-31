package com.greyflame.bluetrail.persistence;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;

@Entity
public class BusStop {
    
    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    @Column(name="busStopId")
    private Long id;

    @OneToOne
    @JoinColumn(name = "stamp_point_id")
    private StampPoint stampPoint;

    private String name;

    private String mapSearch;

    private Integer distanceOfStamp;

    private Integer timeToStamp;

    private Integer timeFromStamp;

    private Integer elevToStamp;

    private Integer elevFromStamp;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public StampPoint getStampPoint() {
        return stampPoint;
    }

    public void setStampPoint(StampPoint stampPoint) {
        this.stampPoint = stampPoint;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getMapSearch() {
        return mapSearch;
    }

    public void setMapSearch(String mapSearch) {
        this.mapSearch = mapSearch;
    }

    public Integer getDistanceOfStamp() {
        return distanceOfStamp;
    }

    public void setDistanceOfStamp(Integer distanceOfStamp) {
        this.distanceOfStamp = distanceOfStamp;
    }

    public Integer getTimeToStamp() {
        return timeToStamp;
    }

    public void setTimeToStamp(Integer timeToStamp) {
        this.timeToStamp = timeToStamp;
    }

    public Integer getTimeFromStamp() {
        return timeFromStamp;
    }

    public void setTimeFromStamp(Integer timeFromStamp) {
        this.timeFromStamp = timeFromStamp;
    }

    public Integer getElevToStamp() {
        return elevToStamp;
    }

    public void setElevToStamp(Integer elevToStamp) {
        this.elevToStamp = elevToStamp;
    }

    public Integer getElevFromStamp() {
        return elevFromStamp;
    }

    public void setElevFromStamp(Integer elevFromStamp) {
        this.elevFromStamp = elevFromStamp;
    }
}
