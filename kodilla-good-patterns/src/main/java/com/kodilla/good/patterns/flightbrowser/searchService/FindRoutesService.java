package com.kodilla.good.patterns.flightbrowser.searchService;

import com.kodilla.good.patterns.flightbrowser.Route;

import java.util.List;

public interface FindRoutesService {

    List<Route> findDestinations(List<Route> routes, String origin);

    List<Route> findOrigins(List<Route> routes, String destination);

    List<Route> findTransfers(List<Route> routes, String origin, String destination);
}
