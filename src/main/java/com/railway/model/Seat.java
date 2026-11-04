
package com.railway.model;

public class Seat {

    private String seatNumber;
    private boolean booked;

    // Default Constructor
    public Seat() {
    }

    // Parameterized Constructor
    public Seat(String seatNumber) {
        this.seatNumber = seatNumber;
        this.booked = false;
    }

    // Getter
    public String getSeatNumber() {
        return seatNumber;
    }

    // Setter
    public void setSeatNumber(String seatNumber) {
        this.seatNumber = seatNumber;
    }

    // Check Seat Status
    public boolean isBooked() {
        return booked;
    }

    // Update Seat Status
    public void setBooked(boolean booked) {
        this.booked = booked;
    }

    // Display Seat Details
    @Override
    public String toString() {
        return "Seat Number: " + seatNumber
                + "\nStatus: " + (booked ? "Booked" : "Available");
    }
}
