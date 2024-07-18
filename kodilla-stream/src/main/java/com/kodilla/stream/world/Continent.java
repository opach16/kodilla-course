package com.kodilla.stream.world;

import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

public final class Continent {

    private final String name;
    private Set<Country> countries = new HashSet<>();

    public Continent(String name) {
        this.name = name;
    }

    public void addCountry(final Country country) {
        countries.add(country);
    }

    public Set<Country> getCountrySet() {
        return countries;
    }

    public String getName() {
        return name;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Continent continent = (Continent) o;
        return Objects.equals(name, continent.name);
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(name);
    }
}