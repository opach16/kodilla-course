package com.kodilla.good.patterns.flightbrowser;

import com.kodilla.good.patterns.flightbrowser.io.OutputController;
import com.kodilla.good.patterns.flightbrowser.repository.RoutesRepository;
import com.kodilla.good.patterns.flightbrowser.searchService.FindRoutesService;

import java.util.List;

public class FlightFinderProcessor {

    private final FindRoutesService findRoutesService;
    private final RoutesRepository routesRepository;
    private final OutputController outputController;

    public FlightFinderProcessor(final FindRoutesService findRoutesService, final RoutesRepository routesRepository, final OutputController outputController) {
        this.findRoutesService = findRoutesService;
        this.routesRepository = routesRepository;
        this.outputController = outputController;
    }

    public void findOrigins(String destination) {
        List<Route> origins = findRoutesService.findOrigins(routesRepository.getRoutes(), destination);
        outputController.showRoutesTo(origins);
    }

    public void findDestinations(String origin) {
        List<Route> destinations = findRoutesService.findDestinations(routesRepository.getRoutes(), origin);
        outputController.showRoutesFrom(destinations);
    }

    public void findTransfers(String origin, String destination) {
        List<Route> transfers = findRoutesService.findTransfers(routesRepository.getRoutes(), origin, destination);
        outputController.showTransfers(transfers);
    }
}
