package com.kodilla.stream.array;

import java.util.Objects;

public final class City {

    private final String name;
    private final int population;

    public City(final String name, final int population) {
        this.name = name;
        this.population = population;
    }

    public String getName() {
        return name;
    }

    public int getPopulation() {
        return population;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        City city = (City) o;
        return population == city.population && Objects.equals(name, city.name);
    }

    @Override
    public int hashCode() {
        int result = Objects.hashCode(name);
        result = 31 * result + population;
        return result;
    }
}