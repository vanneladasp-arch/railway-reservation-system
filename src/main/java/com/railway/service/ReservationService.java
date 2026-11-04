
package com.railway.service;

import com.railway.model.Passenger;
import com.railway.model.Train;
import com.railway.model.Seat;
import com.railway.model.Ticket;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ReservationService {

    private List<Ticket> tickets = new ArrayList<>();

    private Map<Integer, Seat> bookedSeatObjects = new HashMap<>();
    private Map<Integer, Train> bookedTrains = new HashMap<>();

    private int nextTicketId = 1;

    // Book Ticket
    public Ticket bookTicket(Train train, Passenger passenger, Seat seat) {

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
        int ticketId = nextTicketId++;

        Ticket ticket = new Ticket(
                ticketId,
                train.getTrainNumber(),
                passenger.getPassengerId(),
                passenger.getPassengerName(),
                seatNumber,
                train.getFare()
        );

        tickets.add(ticket);

        bookedSeatObjects.put(ticketId, seat);
        bookedTrains.put(ticketId, train);

        System.out.println("\nTicket booked successfully!");
        System.out.println(ticket);

        return ticket;
    }

    // Cancel Ticket
    public boolean cancelTicket(int ticketId) {

        for (int i = 0; i < tickets.size(); i++) {

            Ticket ticket = tickets.get(i);

            if (ticket.getTicketId() == ticketId) {

                Train train = bookedTrains.get(ticketId);
                Seat seat = bookedSeatObjects.get(ticketId);

                // Release Seat
                if (train != null) {
                    train.cancelSeat(ticket.getSeatNumber());
                }

                if (seat != null) {
                    seat.setBooked(false);
                }

                tickets.remove(i);

                bookedTrains.remove(ticketId);
                bookedSeatObjects.remove(ticketId);

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
    public void displayTickets() {

        if (tickets.isEmpty()) {
            System.out.println("No tickets available!");
            return;
        }

        System.out.println("\n===== ALL BOOKED TICKETS =====");

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
}
