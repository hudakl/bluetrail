package com.greyflame.bluetrail.persistence;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

public interface LongDistanceTrailRepository extends CrudRepository<LongDistanceTrail, Integer> {

    List<LongDistanceTrail> findByForeignNameKey(String foreignNameKey);
}
