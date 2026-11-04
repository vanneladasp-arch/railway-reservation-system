
package com.railway.service;

import com.railway.model.Train;
import com.railway.model.Passenger;
import com.railway.model.Ticket;

import java.util.ArrayList;
import java.util.List;

public class RailwayData {

    private List<Train> trains = new ArrayList<>();
    private List<Passenger> passengers = new ArrayList<>();
    private List<Ticket> tickets = new ArrayList<>();

    // Add Train
    public void addTrain(Train train) {
        if (train != null) {
            trains.add(train);
            System.out.println("Train added successfully!");
        }
    }

    // Add Passenger
    public void addPassenger(Passenger passenger) {
        if (passenger != null) {
            passengers.add(passenger);
            System.out.println("Passenger added successfully!");
        }
    }

    // Add Ticket
    public void addTicket(Ticket ticket) {
        if (ticket != null) {
            tickets.add(ticket);
            System.out.println("Ticket added successfully!");
        }
    }

    // Get All Trains
    public List<Train> getTrains() {
        return trains;
    }

    // Get All Passengers
    public List<Passenger> getPassengers() {
        return passengers;
    }

    // Get All Tickets
    public List<Ticket> getTickets() {
        return tickets;
    }

    // Find Train
    public Train findTrain(int trainNumber) {
        for (Train train : trains) {
            if (train.getTrainNumber() == trainNumber) {
                return train;
            }
        }
        return null;
    }

    // Find Passenger
    public Passenger findPassenger(int passengerId) {
        for (Passenger passenger : passengers) {
            if (passenger.getPassengerId() == passengerId) {
                return passenger;
            }
        }
        return null;
    }

    // Find Ticket
    public Ticket findTicket(int ticketId) {
        for (Ticket ticket : tickets) {
            if (ticket.getTicketId() == ticketId) {
                return ticket;
            }
        }
        return null;
    }

    // Remove Ticket
    public boolean removeTicket(int ticketId) {
        Ticket ticket = findTicket(ticketId);

        if (ticket != null) {
            tickets.remove(ticket);
            System.out.println("Ticket removed successfully!");
            return true;
        }

        System.out.println("Ticket not found!");
        return false;
    }

    // Display All Data
    public void displayAllData() {

        System.out.println("\n===== TRAINS =====");
        for (Train train : trains) {
            System.out.println(train);
        }

        System.out.println("\n===== PASSENGERS =====");
        for (Passenger passenger : passengers) {
            System.out.println(passenger);
        }

        System.out.println("\n===== TICKETS =====");
        for (Ticket ticket : tickets) {
            System.out.println(ticket);
        }
    }
}
