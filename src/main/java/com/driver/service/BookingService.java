package com.driver.service;

import com.driver.model.Booking;
import com.driver.model.Hotel;
import com.driver.repository.BookingRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class BookingService {

    BookingRepository bookingRepo = new BookingRepository();
    HotelService hotelService = new HotelService();

    public int bookHotel(Booking booking) {

        int roomsToBeBooked = booking.getNoOfRooms();
        Hotel hotel = hotelService.getHotelById(booking.getHotelName());
        // checking availability of rooms in hotel
        int roomsAvailable = hotel.getAvailableRooms();
        if(roomsAvailable < roomsToBeBooked) return -1;
        // reducing count of available rooms in hotel
        hotel.setAvailableRooms(hotel.getAvailableRooms() - roomsToBeBooked);

        // total amount to pay
        int amountToPay = hotel.getPricePerNight() * roomsToBeBooked;
        booking.setAmountToBePaid(amountToPay);
        bookingRepo.bookHotel(booking);

        return amountToPay;
    }

    public int getBookingsByPerson(int adhaarId) {
        return bookingRepo.getBookingByPerson(adhaarId);
    }
}
