
package com.railway.model;

public class Ticket {

    private int ticketId;
    private int trainNumber;
    private int passengerId;
    private String passengerName;
    private String seatNumber;
    private double fare;

    // Default Constructor
    public Ticket() {
    }

    // Parameterized Constructor
    public Ticket(int ticketId, int trainNumber,
                  int passengerId, String passengerName,
                  String seatNumber, double fare) {

        this.ticketId = ticketId;
        this.trainNumber = trainNumber;
        this.passengerId = passengerId;
        this.passengerName = passengerName;
        this.seatNumber = seatNumber;
        this.fare = fare;
    }

    // Getters and Setters
    public int getTicketId() {
        return ticketId;
    }

    public void setTicketId(int ticketId) {
        this.ticketId = ticketId;
    }

    public int getTrainNumber() {
        return trainNumber;
    }

    public void setTrainNumber(int trainNumber) {
        this.trainNumber = trainNumber;
    }

    public int getPassengerId() {
        return passengerId;
    }

    public void setPassengerId(int passengerId) {
        this.passengerId = passengerId;
    }

    public String getPassengerName() {
        return passengerName;
    }

    public void setPassengerName(String passengerName) {
        this.passengerName = passengerName;
    }

    public String getSeatNumber() {
        return seatNumber;
    }

    public void setSeatNumber(String seatNumber) {
        this.seatNumber = seatNumber;
    }

    public double getFare() {
        return fare;
    }

    public void setFare(double fare) {
        this.fare = fare;
    }

    // Display Ticket Details
    @Override
    public String toString() {

        return "\n===== TICKET DETAILS ====="
                + "\nTicket ID: " + ticketId
                + "\nTrain Number: " + trainNumber
                + "\nPassenger ID: " + passengerId
                + "\nPassenger Name: " + passengerName
                + "\nSeat Number: " + seatNumber
                + "\nFare: Rs. " + fare;
    }
}
