package com.driver.service;

import com.driver.model.Facility;
import com.driver.model.Hotel;
import com.driver.repository.HotelRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

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

    public Hotel updateFacilitiesByHotelId(List<Facility> newFacilities, String hotelName) {

        Hotel hotel = getHotelById(hotelName);
        List<Facility> existingFacilities = hotel.getFacilities();
        Set<Facility> uniqueFacilites = new HashSet<>(newFacilities);

        // adding the facilities
        for(Facility f: uniqueFacilites) {
            if(!existingFacilities.contains(f)) {
                existingFacilities.add(f);
            }
        }

        hotel.setFacilities(existingFacilities);

        return hotel;
    }
}
