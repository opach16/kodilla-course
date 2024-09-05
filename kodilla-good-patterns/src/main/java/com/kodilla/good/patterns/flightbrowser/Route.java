package com.kodilla.good.patterns.flightbrowser;

import java.util.Objects;

public class Route {

    private final String origin;
    private final String destination;

    public Route(final String origin, final String destination) {
        this.origin = origin;
        this.destination = destination;
    }

    public String getOrigin() {
        return origin;
    }

    public String getDestination() {
        return destination;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Route route = (Route) o;
        return Objects.equals(origin, route.origin) && Objects.equals(destination, route.destination);
    }

    @Override
    public int hashCode() {
        int result = Objects.hashCode(origin);
        result = 31 * result + Objects.hashCode(destination);
        return result;
    }

    @Override
    public String toString() {
        return "Route: [" + origin + " -> " + destination + "]";
    }
}
