
package com.railway;

import com.railway.model.Passenger;
import com.railway.model.Train;
import com.railway.model.Seat;
import com.railway.model.Ticket;
import com.railway.service.ReservationService;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {

    static Scanner sc = new Scanner(System.in);

    static List<Train> trains = new ArrayList<>();

    static List<Passenger> passengers = new ArrayList<>();

    static ReservationService reservationService =
            new ReservationService();

    public static void main(String[] args) {

        boolean running = true;

        while (running) {

            System.out.println("\n===== RAILWAY RESERVATION SYSTEM =====");
            System.out.println("1. Add Train");
            System.out.println("2. View Trains");
            System.out.println("3. Register Passenger");
            System.out.println("4. View Passengers");
            System.out.println("5. Book Ticket");
            System.out.println("6. Cancel Ticket");
            System.out.println("7. Search Ticket");
            System.out.println("8. View All Tickets");
            System.out.println("9. Total Bookings");
            System.out.println("10. Exit");

            System.out.print("Enter your choice: ");
            int choice = sc.nextInt();
            sc.nextLine();

            switch (choice) {

                case 1:
                    addTrain();
                    break;

                case 2:
                    viewTrains();
                    break;

                case 3:
                    registerPassenger();
                    break;

                case 4:
                    viewPassengers();
                    break;

                case 5:
                    bookTicket();
                    break;

                case 6:
                    cancelTicket();
                    break;

                case 7:
                    searchTicket();
                    break;

                case 8:
                    reservationService.displayTickets();
                    break;

                case 9:
                    System.out.println("Total Bookings: "
                            + reservationService.getTotalBookings());
                    break;

                case 10:
                    running = false;
                    System.out.println("Thank you for using Railway Reservation System!");
                    break;

                default:
                    System.out.println("Invalid choice!");
            }
        }

        sc.close();
    }

    // Add Train
    public static void addTrain() {

        System.out.print("Enter Train Number: ");
        int number = sc.nextInt();
        sc.nextLine();

        System.out.print("Enter Train Name: ");
        String name = sc.nextLine();

        System.out.print("Enter Source: ");
        String source = sc.nextLine();

        System.out.print("Enter Destination: ");
        String destination = sc.nextLine();

        System.out.print("Enter Fare: ");
        double fare = sc.nextDouble();

        Train train = new Train(
                number, name, source, destination, fare
        );

        trains.add(train);

        System.out.println("Train added successfully!");
    }

    // View Trains
    public static void viewTrains() {

        if (trains.isEmpty()) {
            System.out.println("No trains available!");
            return;
        }

        for (Train train : trains) {
            System.out.println("\n" + train);
        }
    }

    // Register Passenger
    public static void registerPassenger() {

        System.out.print("Enter Passenger ID: ");
        int id = sc.nextInt();
        sc.nextLine();

        System.out.print("Enter Passenger Name: ");
        String name = sc.nextLine();

        System.out.print("Enter Age: ");
        int age = sc.nextInt();

        Passenger passenger = new Passenger(id, name, age);

        passengers.add(passenger);

        System.out.println("Passenger registered successfully!");
    }

    // View Passengers
    public static void viewPassengers() {

        if (passengers.isEmpty()) {
            System.out.println("No passengers available!");
            return;
        }

        for (Passenger passenger : passengers) {
            System.out.println("\n" + passenger);
        }
    }

    // Book Ticket
    public static void bookTicket() {

        if (trains.isEmpty() || passengers.isEmpty()) {
            System.out.println("Please add a train and register a passenger first!");
            return;
        }

        viewTrains();

        System.out.print("\nEnter Train Number: ");
        int trainNumber = sc.nextInt();

        Train selectedTrain = null;

        for (Train train : trains) {
            if (train.getTrainNumber() == trainNumber) {
                selectedTrain = train;
                break;
            }
        }

        if (selectedTrain == null) {
            System.out.println("Train not found!");
            return;
        }

        viewPassengers();

        System.out.print("\nEnter Passenger ID: ");
        int passengerId = sc.nextInt();

        Passenger selectedPassenger = null;

        for (Passenger passenger : passengers) {
            if (passenger.getPassengerId() == passengerId) {
                selectedPassenger = passenger;
                break;
            }
        }

        if (selectedPassenger == null) {
            System.out.println("Passenger not found!");
            return;
        }

        System.out.println("\nAvailable Seats:");

        for (int i = 1; i <= 10; i++) {

            String seatNumber = "S" + i;

            if (!selectedTrain.isSeatBooked(seatNumber)) {
                System.out.print(seatNumber + " ");
            }
        }

        System.out.print("\nEnter Seat Number (S1-S10): ");
        String seatNumber = sc.next().toUpperCase();

        if (!seatNumber.matches("S([1-9]|10)")) {
            System.out.println("Invalid seat number!");
            return;
        }

        if (selectedTrain.isSeatBooked(seatNumber)) {
            System.out.println("Seat already booked!");
            return;
        }

        Seat seat = new Seat(seatNumber);

        reservationService.bookTicket(
                selectedTrain,
                selectedPassenger,
                seat
        );
    }

    // Cancel Ticket
    public static void cancelTicket() {

        System.out.print("Enter Ticket ID: ");
        int ticketId = sc.nextInt();

        reservationService.cancelTicket(ticketId);
    }

    // Search Ticket
    public static void searchTicket() {

        System.out.print("Enter Ticket ID: ");
        int ticketId = sc.nextInt();

        Ticket ticket = reservationService.searchTicket(ticketId);

        if (ticket != null) {
            System.out.println(ticket);
        } else {
            System.out.println("Ticket not found!");
        }
    }
}
