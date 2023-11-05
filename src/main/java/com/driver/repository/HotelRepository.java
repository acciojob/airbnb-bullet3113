package com.driver.repository;

import com.driver.model.Hotel;
import org.springframework.stereotype.Repository;

import java.util.HashMap;
import java.util.Map;

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

}
