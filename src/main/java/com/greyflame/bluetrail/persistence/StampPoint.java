package com.greyflame.bluetrail.persistence;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;

@Entity
public class StampPoint {
    
    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    @Column(name="stampPointId")
    private Long id;

    private Integer number;

    private String name;

    @ManyToOne
    @JoinColumn(name="section_id")
    private TrailSection trailSection;

    private int distEastward;

    private int distWestward;

    private int timeEastward;

    private int timeWestward;

    private int elevEastward;

    private int elevWestward;

    @OneToOne(mappedBy = "stampPoint", cascade = CascadeType.ALL)
    private BusStop busStop;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Integer getNumber() {
        return number;
    }

    public void setNumber(Integer number) {
        this.number = number;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public TrailSection getTrailSection() {
        return trailSection;
    }

    public void setTrailSection(TrailSection trailSection) {
        this.trailSection = trailSection;
    }

    public int getDistEastward() {
        return distEastward;
    }

    public void setDistEastward(int distEastward) {
        this.distEastward = distEastward;
    }

    public int getDistWestward() {
        return distWestward;
    }

    public void setDistWestward(int distWestward) {
        this.distWestward = distWestward;
    }

    public int getTimeEastward() {
        return timeEastward;
    }

    public void setTimeEastward(int timeEastward) {
        this.timeEastward = timeEastward;
    }

    public int getTimeWestward() {
        return timeWestward;
    }

    public void setTimeWestward(int timeWestward) {
        this.timeWestward = timeWestward;
    }

    public int getElevEastward() {
        return elevEastward;
    }

    public void setElevEastward(int elevEastward) {
        this.elevEastward = elevEastward;
    }

    public int getElevWestward() {
        return elevWestward;
    }

    public void setElevWestward(int elevWestward) {
        this.elevWestward = elevWestward;
    }

    public BusStop getBusStop() {
        return busStop;
    }

    public void setBusStop(BusStop busStop) {
        this.busStop = busStop;
    }

    @Override
    public String toString() {
        return "StampPoint [name=" + name + ", number=" + number + "]";
    }

}
