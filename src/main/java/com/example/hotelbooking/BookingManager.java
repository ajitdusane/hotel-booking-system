package com.example.hotelbooking;

import java.util.ArrayList;
import java.util.List;

public class BookingManager {

    BookingManager(int maxNumberOfRooms) {
        SIZE = maxNumberOfRooms;
    }

    public List<Booking> Bookings = new ArrayList<>();
    private final int SIZE;

    /**
     * @param wishStartDate start date from when user wish to book
     * @param wishEndDate   end date until when user wish to book
     * @return True, if booking is successful, else false
     */
    public boolean TryAddBooking(int wishStartDate, int wishEndDate) {
        if (wishStartDate < 0 || wishStartDate > 364 || wishEndDate < 0 || wishEndDate > 364)
            return false;

        for (int currentRoomNumber = 1; currentRoomNumber <= SIZE; currentRoomNumber++) {
            if (IsRoomAvailable(currentRoomNumber, wishStartDate, wishEndDate)) {
                Bookings.add(new Booking(currentRoomNumber, wishStartDate, wishEndDate));
                System.out.print("Room number assigned: " + currentRoomNumber + "\n");
                return true;
            }
        }

        return false;
    }

    /**
     * @param roomNumber    Room number to check
     * @param wishStartDate start date
     * @param wishEndDate   end date
     * @return true, if available else false
     */
    private boolean IsRoomAvailable(int roomNumber, int wishStartDate, int wishEndDate) {

        //get existing bookings for the roomNumber
        List<Booking> bookings = Bookings.stream().filter(s -> s.RoomNumber == roomNumber).toList();

        boolean result = true;
        for (Booking booking : bookings)
            if (wishStartDate <= booking.StartDate && wishEndDate <= booking.EndDate && wishEndDate >= booking.StartDate) {
                result = false;
                break;
            } else if (wishStartDate <= booking.StartDate && wishEndDate >= booking.EndDate) {
                result = false;
                break;
            } else if (wishStartDate <= booking.EndDate && wishEndDate >= booking.EndDate) {
                result = false;
                break;
            } else if (booking.StartDate <= wishStartDate && booking.EndDate >= wishEndDate) {
                result = false;
                break;
            }
        return result;
    }
}
