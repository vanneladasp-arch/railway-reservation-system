
package com.railway.service;

import com.railway.model.Train;
import com.railway.model.Passenger;

import java.util.ArrayList;
import java.util.List;

public class RailwayService {

    private List<Train> trains = new ArrayList<>();
    private List<Passenger> passengers = new ArrayList<>();

    // Add Train
    public void addTrain(Train train) {
        if (train == null) {
            System.out.println("Invalid train!");
            return;
        }

        trains.add(train);
        System.out.println("Train added successfully!");
    }

    // Add Passenger
    public void addPassenger(Passenger passenger) {
        if (passenger == null) {
            System.out.println("Invalid passenger!");
            return;
        }

        passengers.add(passenger);
        System.out.println("Passenger added successfully!");
    }

    // Display All Trains
    public void displayTrains() {
        if (trains.isEmpty()) {
            System.out.println("No trains available!");
            return;
        }

        for (Train train : trains) {
            System.out.println(train);
        }
    }

    // Display All Passengers
    public void displayPassengers() {
        if (passengers.isEmpty()) {
            System.out.println("No passengers available!");
            return;
        }

        for (Passenger passenger : passengers) {
            System.out.println(passenger);
        }
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

    // Get All Trains
    public List<Train> getAllTrains() {
        return new ArrayList<>(trains);
    }

    // Get All Passengers
    public List<Passenger> getAllPassengers() {
        return new ArrayList<>(passengers);
    }
}
