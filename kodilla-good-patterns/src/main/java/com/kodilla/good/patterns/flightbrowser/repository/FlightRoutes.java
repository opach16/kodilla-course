package com.kodilla.good.patterns.flightbrowser.repository;

import com.kodilla.good.patterns.flightbrowser.Route;

import java.util.List;

public class FlightRoutes implements RoutesRepository {

    private final List<Route> flights = List.of(
            new Route("London", "Paris"),
            new Route("London", "Barcelona"),
            new Route("London", "Madrid"),
            new Route("Barcelona", "London"),
            new Route("Barcelona", "Madrid"),
            new Route("Madrid", "London"),
            new Route("Madrid", "Barcelona"),
            new Route("Madrid", "Warsaw"),
            new Route("Madrid", "Amsterdam"),
            new Route("Warsaw", "Madrid"),
            new Route("Warsaw", "Amsterdam"),
            new Route("Amsterdam", "Madrid"),
            new Route("Amsterdam", "Warsaw"),
            new Route("Amsterdam", "Berlin"),
            new Route("Amsterdam", "Paris"),
            new Route("Paris", "Amsterdam"),
            new Route("Paris", "London")
    );

    @Override
    public List<Route> getRoutes() {
        return flights;
    }
}
