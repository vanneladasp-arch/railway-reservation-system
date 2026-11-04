
package com.railway.model;

public class Route {

    private int routeId;
    private String source;
    private String destination;
    private double distance;

    // Default Constructor
    public Route() {
    }

    // Parameterized Constructor
    public Route(int routeId, String source,
                 String destination, double distance) {

        this.routeId = routeId;
        this.source = source;
        this.destination = destination;
        this.distance = distance;
    }

    // Getters and Setters
    public int getRouteId() {
        return routeId;
    }

    public void setRouteId(int routeId) {
        this.routeId = routeId;
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

    public double getDistance() {
        return distance;
    }

    public void setDistance(double distance) {
        this.distance = distance;
    }

    // Display Route Details
    @Override
    public String toString() {

        return "\nRoute ID: " + routeId
                + "\nSource: " + source
                + "\nDestination: " + destination
                + "\nDistance: " + distance + " KM";
    }
}
