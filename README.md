# hotel-booking-system
The code files are as follows: 

HotelbookingApplication.java

This is a SpringBootApplication with a rest controller i.e. HotelBookingController. It exposes 3 methods so that behaviour of the application can be tested.

1) showBookings ("/bookings/show")

It gives all the bookings in the system. 

2) clearBookings ("/bookings/clear")

It clears all the bookings from the system.

3) addBooking ("/bookings/add/{start_date}/{end_date}")

This method will add a booking in the system.  e.g. Below mentioned URL will add a booking with check in on Day 2 and check out on Day 4

http://localhost:8080/bookings/add/2/4" 

The response text tells if the booking was successful or not.

HotelBookingApplicationTests.java

This file contains all the unit tests for the application.

How to run application? 
1. Open project in IntelliJ
2. Right click on HotelBookingApplicationTests and wait till tomcat starts
3. Open browser with following url: http://localhost:8080/bookings/show

This will just show and empty list as no bookings have been done yet.

4. Add a booking with url http://localhost:8080/bookings/add/0/0 -> (0, 0) - ACCEPT
5. Add another booking with url http://localhost:8080/bookings/add/0/2 -> (0, 2) - ACCEPT
6. Add another booking with url http://localhost:8080/bookings/add/2/3 -> (2, 4) - ACCEPT
7. Add another booking with url http://localhost:8080/bookings/add/2/2 -> (2, 2) - ACCEPT
8. Add another booking with url http://localhost:8080/bookings/add/2/3 -> (2, 3) - DECLINE

9. Show all the bookings with url http://localhost:8080/bookings/show
10. Clear all bookings with url http://localhost:8080/bookings/clear

likewise more test cases can be tested...


Note:  The HotelbookingApplication has 3 number of rooms i.e. SIZE set however this can be changed easily to test application for different hotel size 

BookingManager bookingManager = new BookingManager(SIZE);

NOTE: All 3 exposed methods have getMapping, hence the methods can be tested only through URLs
