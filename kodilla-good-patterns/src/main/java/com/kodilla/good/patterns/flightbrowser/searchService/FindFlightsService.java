package com.kodilla.good.patterns.flightbrowser.searchService;

import com.kodilla.good.patterns.flightbrowser.Route;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class FindFlightsService implements FindRoutesService {

    @Override
    public List<Route> findOrigins(List<Route> routes, String destination) {
        return routes.stream()
                .filter(route -> route.getDestination().equals(destination))
                .collect(Collectors.toList());
    }

    @Override
    public List<Route> findDestinations(List<Route> routes, String origin) {
        return routes.stream()
                .filter(route -> route.getOrigin().equals(origin))
                .collect(Collectors.toList());
    }

    @Override
    public List<Route> findTransfers(List<Route> routes, String origin, String destination) {
        List<Route> flightsFrom = findDestinations(routes, origin);
        List<Route> flightsTo = findOrigins(routes, destination);
        List<Route> transfers = new ArrayList<>();

        flightsFrom
                .forEach(routeFrom -> flightsTo
                        .forEach(routeTo -> {
                                    if (routeFrom.getDestination().equals(routeTo.getOrigin())) {
                                        transfers.add(routeFrom);
                                        transfers.add(routeTo);
                                    }
                                }
                        ));
        return transfers;
    }
}
