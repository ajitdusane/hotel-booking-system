package com.example.hotelbooking;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class HotelBookingApplicationTests {

    @Test
    void MainTests1() {
        BookingManager target = new BookingManager(3);
        assertTrue(target.TryAddBooking(0, 0), "Accept");
        assertTrue(target.TryAddBooking(0, 2), "Accept");
        assertTrue(target.TryAddBooking(2, 4), "Accept");
        assertTrue(target.TryAddBooking(2, 2), "Accept");
        assertFalse(target.TryAddBooking(2, 3), "Decline");
    }

    //Requests outside our planning period are declined
    @Test
    void BoundaryTests() {
        BookingManager target = new BookingManager(3);

        assertFalse(target.TryAddBooking(-4, 2), "Invalid start date");
        assertFalse(target.TryAddBooking(200, 400), "Invalid end date");
        assertFalse(target.TryAddBooking(-1, 365), "Invalid start and end dates");
    }

    //Requests are accepted
    @Test
    void MainTests2() {
        BookingManager target = new BookingManager(3);

        assertTrue(target.TryAddBooking(0, 5), "Accept");
        assertTrue(target.TryAddBooking(7, 13), "Accept");
        assertTrue(target.TryAddBooking(3, 9), "Accept");
        assertTrue(target.TryAddBooking(5, 7), "Accept");
        assertTrue(target.TryAddBooking(6, 6), "Accept");
        assertTrue(target.TryAddBooking(0, 4), "Accept");
    }

    //Requests are declined
    @Test
    void MainTests3() {
        BookingManager target = new BookingManager(3);

        assertTrue(target.TryAddBooking(1, 3), "Accept");
        assertTrue(target.TryAddBooking(2, 5), "Accept");
        assertTrue(target.TryAddBooking(1, 9), "Accept");
        assertFalse(target.TryAddBooking(0, 15), "Decline");
    }

    //Requests are declined
    @Test
    void MainTests4() {
        BookingManager target = new BookingManager(3);

        assertTrue(target.TryAddBooking(1, 3), "Accept");
        assertTrue(target.TryAddBooking(0, 15), "Accept");
        assertTrue(target.TryAddBooking(1, 9), "Accept");
        assertFalse(target.TryAddBooking(2, 5), "Decline");
        assertTrue(target.TryAddBooking(4, 9), "Accept");
    }

    //Complex requests (Size = 2)
    @Test
    void MainTests5() {
        BookingManager target = new BookingManager(2);

        assertTrue(target.TryAddBooking(1, 3), "Accept");
        assertTrue(target.TryAddBooking(0, 4), "Accept");
        assertFalse(target.TryAddBooking(2, 3), "Decline");
        assertTrue(target.TryAddBooking(5, 5), "Accept");
        assertFalse(target.TryAddBooking(4, 10), "Decline");
        assertTrue(target.TryAddBooking(10, 10), "Accept");
        assertTrue(target.TryAddBooking(6, 7), "Accept");
        assertTrue(target.TryAddBooking(8, 10), "Accept");
        assertTrue(target.TryAddBooking(8, 9), "Accept");
    }

}
