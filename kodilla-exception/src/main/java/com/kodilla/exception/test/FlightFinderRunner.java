package com.kodilla.exception.test;

public class FlightFinderRunner {

    public static void main(String[] args) {
        Flight exceptionalFlight = new Flight("adad", "Barcelona El Prat Airport");
        FlightFinder flightFinder = new FlightFinder();

        try {
            System.out.println(flightFinder.findFlight(exceptionalFlight));
        } catch (RouteNotFoundException e) {
            System.out.println(e.getMessage());
        }
    }
}
