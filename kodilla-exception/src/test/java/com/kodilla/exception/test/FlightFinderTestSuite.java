package com.kodilla.exception.test;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class FlightFinderTestSuite {

    private Flight availableBoth = new Flight("Madrid Barajas Airport", "Barcelona El Prat Airport");
    private Flight availableFirst = new Flight("Madrid Barajas Airport", "Heathrow Airport");
    private Flight availableSecond = new Flight("Heathrow Airport", "Barcelona El Prat Airport");
    private Flight inavailableBoth = new Flight("Heathrow Airport", "Amsterdam Schiphol Airport");
    private Flight EqualsAirports = new Flight("Madrid Barajas Airport", "Madrid Barajas Airport");
    private Flight wrongFirstAirport = new Flight("adsasd", "Barcelona El Prat Airport");
    private Flight wrongSecondAirport = new Flight("Heathrow Airport", "asdasd");

    @Test
    void testFindFlightInvalidAirport() {
        //given
        FlightFinder flightFinder = new FlightFinder();

        //when & then
        assertThrows(RouteNotFoundException.class, () -> flightFinder.findFlight(wrongFirstAirport));
        assertThrows(RouteNotFoundException.class, () -> flightFinder.findFlight(wrongSecondAirport));
    }

    @Test
    void testFindFlightValidAirport() {
        //given
        FlightFinder flightFinder = new FlightFinder();

        //when & then
        assertDoesNotThrow(() -> flightFinder.findFlight(availableBoth));
        assertDoesNotThrow(() -> flightFinder.findFlight(inavailableBoth));
    }

    @Test
    void testFindFlightAvailableAirport() throws RouteNotFoundException {
        //given
        FlightFinder flightFinder = new FlightFinder();

        //when
        String result = flightFinder.findFlight(availableBoth);

        //then
        assertEquals("The flight is available", result);
    }

    @Test
    void testFindFlightInavailableAirport() throws RouteNotFoundException {
        //given
        FlightFinder flightFinder = new FlightFinder();

        //when
        String result = flightFinder.findFlight(inavailableBoth);
        String result1 = flightFinder.findFlight(availableFirst);
        String result2 = flightFinder.findFlight(availableSecond);

        //then
        assertEquals("The flight is not available", result);
        assertEquals("The flight is not available", result1);
        assertEquals("The flight is not available", result2);
    }

    @Test
    void testFindFlightEqualAirports() throws RouteNotFoundException {
        //given
        FlightFinder flightFinder = new FlightFinder();

        //when
        String result = flightFinder.findFlight(EqualsAirports);

        //then
        assertEquals("Departure Airport and Arrival Airport must be different", result);
    }
}
