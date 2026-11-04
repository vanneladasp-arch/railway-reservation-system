
package com.railway.util;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;

import java.io.File;
import java.io.IOException;

public class JsonUtil {

    private static final ObjectMapper mapper = new ObjectMapper()
            .enable(SerializationFeature.INDENT_OUTPUT);

    // Save data into JSON file
    public static void save(Object data, String fileName) {

        try {
            mapper.writeValue(new File(fileName), data);

            System.out.println("Data saved successfully!");

        } catch (IOException e) {

            System.out.println("Error saving data: " + e.getMessage());
        }
    }

    // Load data from JSON file
    public static <T> T load(String fileName, Class<T> classType) {

        try {

            File file = new File(fileName);

            if (!file.exists()) {
                System.out.println("File not found: " + fileName);
                return null;
            }

            return mapper.readValue(file, classType);

        } catch (IOException e) {

            System.out.println("Error loading data: " + e.getMessage());
            return null;
        }
    }
}
