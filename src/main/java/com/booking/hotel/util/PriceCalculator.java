package com.booking.hotel.util;

import java.util.List;

import com.booking.hotel.model.Feature;
import com.booking.hotel.model.Room;

public class PriceCalculator {
    public static double getPrice(Room room, List<Feature> features) {

        double price = room.getPrice();

        if (price < 0) {
            return -1;
        }

        for (Feature feature : features) {
            price += feature.getPrice();
        }

        return price;
    }
}
