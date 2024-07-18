package com.kodilla.stream.array;

import java.util.ArrayList;
import java.util.List;

public final class PopulationCalculator {

    private List<City> listOfCities = new ArrayList<>();

    public PopulationCalculator() {
        listOfCities.add(new City("Madrid", 5400000));
        listOfCities.add(new City("Warsaw", 2800000));
        listOfCities.add(new City("Paris", 6400000));
        listOfCities.add(new City("Amsterdam", 1240000));
    }

    public int[] getPopulationArray() {
        int[] population = listOfCities.stream()
                .mapToInt(City::getPopulation)
                .toArray();
        return population;
    }
}