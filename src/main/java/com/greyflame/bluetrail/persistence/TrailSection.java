package com.greyflame.bluetrail.persistence;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

@Entity
public class TrailSection {
    
    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    @Column(name="sectionId")
    private Long id;
    
    private Integer numberOfSection;

    private String officialId;

    private String region;

    @ManyToOne
    @JoinColumn(name="ldt_id")
    private LongDistanceTrail longDistanceTrail;

    @OneToMany(mappedBy = "trailSection", cascade = CascadeType.ALL)
    private List<StampPoint> stampPoints = new ArrayList<>();

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Integer getNumberOfSection() {
        return numberOfSection;
    }

    public void setNumberOfSection(Integer numberOfSection) {
        this.numberOfSection = numberOfSection;
    }

    public String getOfficialId() {
        return officialId;
    }

    public void setOfficialId(String officialId) {
        this.officialId = officialId;
    }

    public String getRegion() {
        return region;
    }

    public void setRegion(String region) {
        this.region = region;
    }

    public LongDistanceTrail getLongDistanceTrail() {
        return longDistanceTrail;
    }

    public void setLongDistanceTrail(LongDistanceTrail longDistanceTrail) {
        this.longDistanceTrail = longDistanceTrail;
    }

    public List<StampPoint> getStampPoints() {
        return stampPoints;
    }

    public void setStampPoints(List<StampPoint> stampPoints) {
        this.stampPoints = stampPoints;
    }

    @Override
    public String toString() {
        return officialId + " " + region;
    }
}
