package com.kodilla.good.patterns.flightbrowser.io;

import com.kodilla.good.patterns.flightbrowser.Route;

import java.util.List;

public class RoutePrinter implements OutputController {


    @Override
    public void showRoutesTo(List<Route> routes) {
        System.out.println("------ FLIGHT TO '" + routes.get(0).getDestination().toUpperCase() + "' ------" );
        routes.forEach(System.out::println);
        System.out.println("--------------------------------");
        System.out.println();
    }

    @Override
    public void showRoutesFrom(List<Route> routes) {
        System.out.println("----- FLIGHT FROM '" + routes.get(0).getOrigin().toUpperCase() + "' -----");
        routes.forEach(System.out::println);
        System.out.println("--------------------------------");
        System.out.println();
    }

    @Override
    public void showTransfers(List<Route> routes) {
        System.out.println("----- FLIGHT WITH TRANSFER -----");
        routes.forEach(System.out::println);
        System.out.println("--------------------------------");
        System.out.println();
    }
}
