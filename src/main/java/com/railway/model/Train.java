
package com.railway.model;

import java.util.ArrayList;
import java.util.List;

public class Train {

    private int trainNumber;
    private String trainName;
    private String source;
    private String destination;
    private double fare;

    private List<String> bookedSeats = new ArrayList<>();

    // Default Constructor
    public Train() {
    }

    // Parameterized Constructor
    public Train(int trainNumber, String trainName,
                 String source, String destination, double fare) {

        this.trainNumber = trainNumber;
        this.trainName = trainName;
        this.source = source;
        this.destination = destination;
        this.fare = fare;
    }

    // Getters and Setters
    public int getTrainNumber() {
        return trainNumber;
    }

    public void setTrainNumber(int trainNumber) {
        this.trainNumber = trainNumber;
    }

    public String getTrainName() {
        return trainName;
    }

    public void setTrainName(String trainName) {
        this.trainName = trainName;
    }

    public String getSource() {
        return source;
    }

    public void setSource(String source) {
        this.source = source;
    }

    public String getDestination() {
        return destination;
    }

    public void setDestination(String destination) {
        this.destination = destination;
    }

    public double getFare() {
        return fare;
    }

    public void setFare(double fare) {
        this.fare = fare;
    }

    // Get Booked Seats
    public List<String> getBookedSeats() {
        return bookedSeats;
    }

    public void setBookedSeats(List<String> bookedSeats) {
        this.bookedSeats = bookedSeats;
    }

    // Check Seat Availability
    public boolean isSeatBooked(String seatNumber) {
        return bookedSeats.contains(seatNumber);
    }

    // Book Seat
    public void bookSeat(String seatNumber) {

        if (!isSeatBooked(seatNumber)) {
            bookedSeats.add(seatNumber);
            System.out.println(seatNumber + " booked successfully!");
        } else {
            System.out.println(seatNumber + " is already booked!");
        }
    }

    // Cancel Seat
    public void cancelSeat(String seatNumber) {
        bookedSeats.remove(seatNumber);
        System.out.println(seatNumber + " is now available!");
    }

    // Display Train Details
    @Override
    public String toString() {

        return "\n===== TRAIN DETAILS ====="
                + "\nTrain Number: " + trainNumber
                + "\nTrain Name: " + trainName
                + "\nSource: " + source
                + "\nDestination: " + destination
                + "\nFare: Rs. " + fare
                + "\nBooked Seats: " + bookedSeats;
    }
}
