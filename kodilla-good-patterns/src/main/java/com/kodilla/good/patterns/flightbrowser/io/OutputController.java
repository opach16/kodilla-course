package com.kodilla.good.patterns.flightbrowser.io;

import com.kodilla.good.patterns.flightbrowser.Route;

import java.util.List;

public interface OutputController {

    void showRoutesTo(List<Route> routes);

    void showRoutesFrom(List<Route> routes);

    void showTransfers(List<Route> routes);
}
