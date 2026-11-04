package com.railway.model;

public class Passenger {

    private int passengerId;
    private String passengerName;
    private int age;

    public Passenger() {
    }

    public Passenger(int passengerId, String passengerName, int age) {
        this.passengerId = passengerId;
        this.passengerName = passengerName;
        this.age = age;
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

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    @Override
    public String toString() {
        return "Passenger ID: " + passengerId
                + "\nPassenger Name: " + passengerName
                + "\nAge: " + age;
    }
}