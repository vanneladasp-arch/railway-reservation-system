
package com.railway.service;

import com.railway.model.Train;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class TrainSorter {

    // Sort trains by train number
    public void sortByTrainNumber(List<Train> trains) {

        Collections.sort(trains,
            Comparator.comparingInt(Train::getTrainNumber));

        System.out.println("Trains sorted by train number!");
    }

    // Sort trains by train name
    public void sortByTrainName(List<Train> trains) {

        Collections.sort(trains,
            Comparator.comparing(Train::getTrainName));

        System.out.println("Trains sorted by train name!");
    }

    // Sort trains by fare
    public void sortByFare(List<Train> trains) {

        Collections.sort(trains,
            Comparator.comparingDouble(Train::getFare));

        System.out.println("Trains sorted by fare!");
    }

    // Display sorted trains
    public void displaySortedTrains(List<Train> trains) {

        System.out.println("\n----- SORTED TRAIN DETAILS -----");

        for (Train train : trains) {
            System.out.println(train);
        }
    }
}
