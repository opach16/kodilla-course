package com.kodilla.exception.test;

import java.util.HashMap;
import java.util.Map;

public class FlightFinder {

    public String findFlight(Flight flight) throws RouteNotFoundException {
        Map<String, Boolean> airports = new HashMap<>();
        airports.put("Heathrow Airport", false);
        airports.put("Charles de Gaulle Airport", true);
        airports.put("Frankfurt Airport", true);
        airports.put("Amsterdam Schiphol Airport", false);
        airports.put("Madrid Barajas Airport", true);
        airports.put("Zurich Airport", true);
        airports.put("Leonardo da Vinci-Fiumicino Airport", true);
        airports.put("Barcelona El Prat Airport", true);

        if (!airports.containsKey(flight.getArrivalAirport()) || !airports.containsKey(flight.getDepartureAirport())) {
            throw new RouteNotFoundException("Airport not found");
        } else if (flight.getArrivalAirport().equals(flight.getDepartureAirport())) {
            return "Departure Airport and Arrival Airport must be different";
        } else if (airports.get(flight.getArrivalAirport()) && airports.get(flight.getDepartureAirport())) {
            return "The flight is available";
        } else {
            return "The flight is not available";
        }
    }
}
