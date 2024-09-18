package com.booking.hotel.repositories;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.booking.hotel.model.Feature;

@Repository
public interface FeaturesRepository extends CrudRepository<Feature, Long> {
    List<Feature> findAll();
}