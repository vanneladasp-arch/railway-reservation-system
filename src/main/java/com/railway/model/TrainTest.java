
package com.railway.model;

public class TrainTest {

    public static void main(String[] args) {

        // Create Train Object
        Train train = new Train(
                101,
                "Express",
                "Hyderabad",
                "Chennai",
                500.0
        );

        // Display Train Details
        System.out.println("===== TRAIN DETAILS =====");
        System.out.println(train);

        // Display Train Fare
        System.out.println("\nTrain Fare: Rs. " + train.getFare());

        // Book Seats
        System.out.println("\n===== BOOKING SEATS =====");

        train.bookSeat("S1");
        train.bookSeat("S2");
        train.bookSeat("S3");

        // Display Booked Seats
        System.out.println("\nBooked Seats: "
                + train.getBookedSeats());

        // Check Seat Status
        System.out.println("\n===== SEAT STATUS =====");

        System.out.println("S1 Booked: "
                + train.isSeatBooked("S1"));

        System.out.println("S4 Booked: "
                + train.isSeatBooked("S4"));

        // Cancel Seat
        System.out.println("\n===== CANCEL SEAT =====");

        train.cancelSeat("S2");

        // Display Final Details
        System.out.println("\n===== FINAL TRAIN DETAILS =====");
        System.out.println(train);
    }
}
