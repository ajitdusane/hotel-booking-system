package com.example.hotelbooking;

import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class HotelBookingController {

    BookingManager bookingManager = new BookingManager(3);

    /**
     * @return Show all bookings
     */
    @GetMapping(value = "/bookings/show")
    public List<Booking> showBookings() {
        return bookingManager.Bookings;
    }

    /**
     * Clear all bookings
     */
    @GetMapping("/bookings/clear")
    public String clearBookings() {
        bookingManager.Bookings.clear();
        return "Bookings have been cleared!";
    }

    /**
     * @param start_date date from which user wish to book
     * @param end_date   date until when user wish to book
     * @return if room has been allotted or not
     */
    @GetMapping("/bookings/add/{start_date}/{end_date}")
    public String addBooking(@PathVariable("start_date") int start_date, @PathVariable("end_date") int end_date) {
        if (bookingManager.TryAddBooking(start_date, end_date))
            return "Room has been allotted!";
        else
            return "Sorry, no room available for the specified dates!";
    }
}
