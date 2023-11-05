package com.driver.service;

import com.driver.model.Hotel;
import com.driver.repository.HotelRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class HotelService {

    @Autowired
    HotelRepository hotelRepo;

    public String addHotelById(Hotel h) {
        return hotelRepo.addHotelById(h);
    }

    public Hotel getHotelById(String id) {
        return hotelRepo.getHotelById(id);
    }

    public String getHotelWithMostFacilities() {
        return hotelRepo.getHotelWithMostFacilities();
    }
}
