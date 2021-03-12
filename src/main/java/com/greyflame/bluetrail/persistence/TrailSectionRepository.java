package com.greyflame.bluetrail.persistence;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

public interface TrailSectionRepository extends CrudRepository<TrailSection, Integer> {

    List<TrailSection> findByOfficialId(String officialId);
    
}