package com.booking.hotel.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.booking.hotel.model.Feature;
import com.booking.hotel.services.FeaturesService;

@RestController
@RequestMapping("/findallFeatures")
public class FeaturesController {
	
    @Autowired
    private FeaturesService featuresService;


    public List<Feature> findedAllFeatures() {
        return featuresService.findedAllFeatures();
    }
}
