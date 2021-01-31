package com.greyflame.bluetrail.persistence;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class LongDistanceTrail {
    
    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    @Column(name="ldtId")
    private Long id;
    
    private String originalName;

    private String foreignNameKey;

    private Integer distance;

    private Integer numberOfSections;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getOriginalName() {
        return originalName;
    }

    public void setOriginalName(String originalName) {
        this.originalName = originalName;
    }

    public String getForeignNameKey() {
        return foreignNameKey;
    }

    public void setForeignNameKey(String foreignNameKey) {
        this.foreignNameKey = foreignNameKey;
    }

    public Integer getDistance() {
        return distance;
    }

    public void setDistance(Integer distance) {
        this.distance = distance;
    }

    public Integer getNumberOfSections() {
        return numberOfSections;
    }

    public void setNumberOfSections(Integer numberOfSections) {
        this.numberOfSections = numberOfSections;
    }
    
}
