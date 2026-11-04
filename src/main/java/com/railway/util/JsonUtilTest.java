
package com.railway.util;

import com.railway.model.Train;

public class JsonUtilTest {

    public static void main(String[] args) {

        // Create a Train object
        Train train = new Train(
                101,
                "Express",
                "Hyderabad",
                "Chennai",
                500.0
        );

        // Save Train object into JSON file
        System.out.println("----- SAVING TRAIN DATA -----");

        JsonUtil.save(train, "train.json");

        // Load Train object from JSON file
        System.out.println("\n----- LOADING TRAIN DATA -----");

        Train loadedTrain = JsonUtil.load(
                "train.json",
                Train.class
        );

        // Display loaded data
        if (loadedTrain != null) {

            System.out.println("Train loaded successfully!");

            System.out.println("Train Number: "
                    + loadedTrain.getTrainNumber());

            System.out.println("Train Name: "
                    + loadedTrain.getTrainName());

            System.out.println("Source: "
                    + loadedTrain.getSource());

            System.out.println("Destination: "
                    + loadedTrain.getDestination());

            System.out.println("Fare: "
                    + loadedTrain.getFare());

        } else {

            System.out.println("Unable to load train data!");
        }
    }
}
