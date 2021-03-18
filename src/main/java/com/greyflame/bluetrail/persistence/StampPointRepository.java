package com.greyflame.bluetrail.persistence;

import java.util.List;

import org.springframework.data.domain.Sort;
import org.springframework.data.repository.CrudRepository;

public interface StampPointRepository extends CrudRepository<StampPoint, Integer> {

    List<StampPoint> findByNumberBetween(int start, int end);
    
}
