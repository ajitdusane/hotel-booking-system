package com.example.hotelbooking;

public class Booking {
    public final int RoomNumber;
    public final int StartDate;
    public final int EndDate;

    public Booking(int roomNumber, int startDate, int endDate) {
        RoomNumber = roomNumber;
        StartDate = startDate;
        EndDate = endDate;
    }

    @Override
    public String toString() {
        return "Booking{" +
                "RoomNumber=" + RoomNumber +
                ", StartDate=" + StartDate +
                ", EndDate=" + EndDate +
                '}';
    }
}

