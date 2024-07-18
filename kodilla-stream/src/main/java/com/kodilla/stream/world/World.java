package com.kodilla.stream.world;

import java.math.BigDecimal;
import java.util.HashSet;
import java.util.Set;

public final class World {

    private final Set<Continent> continents = new HashSet<>();

    public void addContinent(final Continent continent) {
        continents.add(continent);
    }

    public Set<Continent> getContinents() {
        return continents;
    }

    public BigDecimal getPeopleQuantity() {
        BigDecimal peopleQuantity = continents.stream()
                .flatMap(country -> country.getCountrySet().stream())
                .map(Country::getPeopleQuantity)
                .reduce(BigDecimal.ZERO, (sum, quantity) -> sum = sum.add(quantity));
        return peopleQuantity;
    }
}