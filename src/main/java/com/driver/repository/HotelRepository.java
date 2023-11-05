package com.driver.repository;

import com.driver.model.Hotel;
import org.springframework.stereotype.Repository;

import java.util.*;

@Repository
public class HotelRepository {

    Map<String, Hotel> hotelDB;

    public HotelRepository() {
        this.hotelDB = new HashMap<>();
    }

    public String addHotelById(Hotel h) {
        if(h == null || h.getHotelName() == null || hotelDB.containsKey(h.getHotelName())) return "FAILURE";
        hotelDB.put(h.getHotelName(), h);
        return "SUCCESS";
    }

    public Hotel getHotelById(String id) {

        return hotelDB.get(id);
    }

    public String getHotelWithMostFacilities() {
        ArrayList<Hotel> hotelsWithFacilities = new ArrayList<>();

        // traversing all the hotels
        for(String i: hotelDB.keySet()) {
            Hotel currentHotel = getHotelById(i);
            if(currentHotel.getFacilities().size() > 0) hotelsWithFacilities.add(currentHotel);
        }

        Collections.sort(hotelsWithFacilities, (a, b) -> {

            if(b.getFacilities().size() - a.getFacilities().size() == 0) {
                return b.getHotelName().compareToIgnoreCase(a.getHotelName()) < 0 ? 1 : -1;
            }
            return b.getFacilities().size() - a.getFacilities().size();
        });

        if(hotelsWithFacilities.size() == 0) return null;

        return hotelsWithFacilities.get(0).getHotelName();
    }
}
