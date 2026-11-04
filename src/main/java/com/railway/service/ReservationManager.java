
package com.railway.service;

import com.railway.model.Train;
import com.railway.model.Passenger;
import com.railway.model.Seat;
import com.railway.model.Ticket;

import java.util.ArrayList;
import java.util.List;
import java.util.HashMap;
import java.util.Map;

public class ReservationManager {

    private List<Ticket> tickets = new ArrayList<>();

    private Map<Integer, Train> bookedTrains = new HashMap<>();

    private Map<Integer, Seat> bookedSeats = new HashMap<>();

    private int nextTicketId = 1;

    // Book Ticket
    public Ticket bookTicket(Train train,
                             Passenger passenger,
                             Seat seat) {

        if (train == null || passenger == null || seat == null) {
            System.out.println("Invalid booking details!");
            return null;
        }

        String seatNumber = seat.getSeatNumber();

        if (seatNumber == null || seatNumber.isEmpty()) {
            System.out.println("Invalid seat number!");
            return null;
        }

        if (seat.isBooked() || train.isSeatBooked(seatNumber)) {
            System.out.println("Seat already booked!");
            return null;
        }

        // Book Seat
        train.bookSeat(seatNumber);
        seat.setBooked(true);

        // Create Ticket
        Ticket ticket = new Ticket(
                nextTicketId++,
                train.getTrainNumber(),
                passenger.getPassengerId(),
                passenger.getPassengerName(),
                seatNumber,
                train.getFare()
        );

        tickets.add(ticket);

        bookedTrains.put(ticket.getTicketId(), train);
        bookedSeats.put(ticket.getTicketId(), seat);

        System.out.println("\n===== BOOKING SUCCESSFUL =====");
        System.out.println(ticket);

        return ticket;
    }

    // Cancel Ticket
    public boolean cancelTicket(int ticketId) {

        for (int i = 0; i < tickets.size(); i++) {

            Ticket ticket = tickets.get(i);

            if (ticket.getTicketId() == ticketId) {

                Train train = bookedTrains.get(ticketId);
                Seat seat = bookedSeats.get(ticketId);

                // Release Seat
                if (train != null) {
                    train.cancelSeat(ticket.getSeatNumber());
                }

                if (seat != null) {
                    seat.setBooked(false);
                }

                tickets.remove(i);

                bookedTrains.remove(ticketId);
                bookedSeats.remove(ticketId);

                System.out.println("Ticket cancelled successfully!");

                return true;
            }
        }

        System.out.println("Ticket not found!");
        return false;
    }

    // Search Ticket
    public Ticket searchTicket(int ticketId) {

        for (Ticket ticket : tickets) {

            if (ticket.getTicketId() == ticketId) {
                return ticket;
            }
        }

        System.out.println("Ticket not found!");
        return null;
    }

    // Display All Tickets
    public void displayAllTickets() {

        if (tickets.isEmpty()) {
            System.out.println("No tickets available!");
            return;
        }

        System.out.println("\n===== ALL RESERVATIONS =====");

        for (Ticket ticket : tickets) {
            System.out.println(ticket);
        }
    }

    // Get All Tickets
    public List<Ticket> getAllTickets() {
        return new ArrayList<>(tickets);
    }

    // Get Total Bookings
    public int getTotalBookings() {
        return tickets.size();
    }

    // Check Seat Availability
    public boolean isSeatAvailable(Train train, String seatNumber) {

        return train != null
                && !train.isSeatBooked(seatNumber);
    }
}
