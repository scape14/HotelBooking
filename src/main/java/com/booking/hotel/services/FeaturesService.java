package com.booking.hotel.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.booking.hotel.model.Feature;
import com.booking.hotel.repositories.FeaturesRepository;

@Service
public class FeaturesService {
	
	@Autowired
    private FeaturesRepository featuresRepository;
    
    public List<Feature> findedAllFeatures() {
        return featuresRepository.findAll();
    }
}
