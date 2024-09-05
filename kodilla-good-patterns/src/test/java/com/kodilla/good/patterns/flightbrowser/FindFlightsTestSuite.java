package com.kodilla.good.patterns.flightbrowser;

import com.kodilla.good.patterns.flightbrowser.searchService.FindFlightsService;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;
import java.util.List;

public class FindFlightsTestSuite {

    FindFlightsService findFlightsService = new FindFlightsService();
    List<Route> routes = List.of(
        new Route("Madrid", "London"),
        new Route("Madrid", "Barcelona"),
        new Route("London", "Warsaw"),
        new Route("Amsterdam", "Berlin"),
        new Route("Berlin", "London")
    );

    @Test
    void testFindOrigins() {
        //given
        List<Route> expectedRoutes = List.of(
                new Route("Madrid", "London"),
                new Route("Berlin", "London")
        );
        //when
        List<Route> retrievedRoutesTo = findFlightsService.findOrigins(routes, "London");
        List<Route> invalidDestination = findFlightsService.findOrigins(routes, "Chicago");

        //then
        assertEquals(expectedRoutes, retrievedRoutesTo);
        assertEquals(new ArrayList<>(), invalidDestination);
    }

    @Test
    void testFindDestinations() {
        //given
        List<Route> expectedRoutes = List.of(
                new Route("Madrid", "London"),
                new Route("Madrid", "Barcelona")
        );
        //when
        List<Route> retrievedRoutes = findFlightsService.findDestinations(routes, "Madrid");
        List<Route> invalidOrigin = findFlightsService.findDestinations(routes, "Chicago");

        //then
        assertEquals(expectedRoutes, retrievedRoutes);
        assertEquals(new ArrayList<>(), invalidOrigin);
    }

    @Test
    void testFindTransfers() {
        //given
        List<Route> expectedRoutes = List.of(
                new Route("Madrid", "London"),
                new Route("London", "Warsaw")
        );
        //when
        List<Route> retrievedRoutes = findFlightsService.findTransfers(routes, "Madrid", "Warsaw");
        List<Route> invalidOrigin = findFlightsService.findTransfers(routes, "Chicago", "Warsaw");
        List<Route> invalidDestination = findFlightsService.findTransfers(routes, "Madrid", "Chicago");

        //then
        assertEquals(expectedRoutes, retrievedRoutes);
        assertEquals(new ArrayList<>(), invalidOrigin);
        assertEquals(new ArrayList<>(), invalidDestination);
    }
}
