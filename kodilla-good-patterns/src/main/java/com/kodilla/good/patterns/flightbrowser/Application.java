package com.kodilla.good.patterns.flightbrowser;

import com.kodilla.good.patterns.flightbrowser.io.RoutePrinter;
import com.kodilla.good.patterns.flightbrowser.repository.FlightRoutes;
import com.kodilla.good.patterns.flightbrowser.searchService.FindFlightsService;

public class Application {

    public static void main(String[] args) {

        FlightFinderProcessor flightFinderProcessor = new FlightFinderProcessor(new FindFlightsService(), new FlightRoutes(), new RoutePrinter());

        flightFinderProcessor.findTransfers("London", "Warsaw");
        flightFinderProcessor.findDestinations("Madrid");
        flightFinderProcessor.findOrigins("Madrid");
    }
}
