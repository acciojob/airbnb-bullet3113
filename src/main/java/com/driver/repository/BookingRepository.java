package com.driver.repository;

import com.driver.model.Booking;
import org.springframework.stereotype.Repository;

import java.util.HashMap;
import java.util.Map;

@Repository
public class BookingRepository {
    Map<String, Booking> bookingDB;
    int bookingCount;

    public BookingRepository() {
        this.bookingDB = new HashMap<>();
        this.bookingCount = 0;
    }

    public void bookHotel(Booking booking) {
        this.bookingCount++;
        String bookingID = "BID" + String.valueOf(this.bookingCount);
        booking.setBookingId(bookingID);
        bookingDB.put(bookingID, booking);
    }

    public int getBookingByPerson(int adhaarId) {
        int totalBookings = 0;
        // traversing in booking Repo
        for(String i: bookingDB.keySet()) {
            Booking booking = bookingDB.get(i);
            if(booking.getBookingAadharCard() == adhaarId) {
                totalBookings++;
            }
        }

        return totalBookings;
    }
}
