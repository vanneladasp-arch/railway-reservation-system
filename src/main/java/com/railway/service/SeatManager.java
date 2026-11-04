
package com.railway.service;

import com.railway.model.Train;

public class SeatManager {

    private final int TOTAL_SEATS = 10;

    // Display all seats
    public void displaySeats(Train train) {

        System.out.println("\n----- SEAT STATUS -----");

        for (int i = 1; i <= TOTAL_SEATS; i++) {

            String seatNumber = "S" + i;

            if (train.isSeatBooked(seatNumber)) {
                System.out.println(seatNumber + " - BOOKED");
            } else {
                System.out.println(seatNumber + " - AVAILABLE");
            }
        }
    }

    // Check seat availability
    public boolean isSeatAvailable(Train train, String seatNumber) {

        if (seatNumber == null ||
            !seatNumber.matches("S([1-9]|10)")) {
            return false;
        }

        return !train.isSeatBooked(seatNumber);
    }

    // Book a seat
    public boolean bookSeat(Train train, String seatNumber) {

        if (!isSeatAvailable(train, seatNumber)) {
            System.out.println("Seat is not available!");
            return false;
        }

        train.bookSeat(seatNumber);

        System.out.println(seatNumber + " booked successfully!");
        return true;
    }

    // Cancel a seat
    public boolean cancelSeat(Train train, String seatNumber) {

        if (!train.isSeatBooked(seatNumber)) {
            System.out.println("Seat is not booked!");
            return false;
        }

        train.cancelSeat(seatNumber);

        System.out.println(seatNumber + " cancelled successfully!");
        return true;
    }
}
