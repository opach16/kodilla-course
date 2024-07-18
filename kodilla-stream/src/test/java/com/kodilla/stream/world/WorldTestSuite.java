package com.kodilla.stream.world;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.math.BigDecimal;
import java.util.Optional;
import java.util.Set;

public class WorldTestSuite {

    private World world;
    private Continent europe;
    private Continent africa;
    private Continent asia;

    @BeforeEach
    void setUpBeforeClass() {

        world = new World();
        europe = new Continent("Europe");
        africa = new Continent("Africa");
        asia = new Continent("Asia");

        europe.addCountry(new Country("Poland", new BigDecimal("38120432")));
        europe.addCountry(new Country("Spain", new BigDecimal("62195843")));
        europe.addCountry(new Country("Austria", new BigDecimal("9002414")));
        africa.addCountry(new Country("RPA", new BigDecimal("7804312")));
        africa.addCountry(new Country("Egypt", new BigDecimal("39123456")));
        africa.addCountry(new Country("Maroco", new BigDecimal("12847593")));
        asia.addCountry(new Country("Pakistan", new BigDecimal("73123059")));
        asia.addCountry(new Country("China", new BigDecimal("104847593")));
        asia.addCountry(new Country("Japan", new BigDecimal("82837461")));

        world.addContinent(europe);
        world.addContinent(africa);
        world.addContinent(asia);
    }

    @DisplayName("The method should return the number of people of all countries")
    @Test
    void testGetPeopleQuantity() {
        //given
        BigDecimal expectedQuantity = new BigDecimal("429902163");

        //when
        BigDecimal resultQuantity = world.getPeopleQuantity();

        //then
        Assertions.assertEquals(expectedQuantity, resultQuantity);
    }

    @Test
    void testGetCountryPeopleQuantity() {
        //given
        BigDecimal expectedQuantity = new BigDecimal("38120432");
        Set<Country> countrySet = europe.getCountrySet();
        Optional<Country> found = countrySet.stream().filter(country -> country.equals(new Country("Poland", new BigDecimal("38120432"))))
                .findFirst();
        Country poland = found.get();

        //when
        BigDecimal resultQuantity = poland.getPeopleQuantity();

        //then
        Assertions.assertEquals(expectedQuantity, resultQuantity);
    }

    @Test
    void testGetContinentSet() {
        //given
        Set<Continent> expectedSet = Set.of(europe, africa, asia);

        //when
        Set<Continent> resultSet = world.getContinents();

        //then
        Assertions.assertEquals(3, resultSet.size());
        Assertions.assertEquals(expectedSet, resultSet);
    }

    @Test
    void testGetCountrySet() {
        //given
        Set<Country> expectedSet = Set.of(
                new Country("Poland", new BigDecimal("38120432")),
                new Country("Spain", new BigDecimal("62195843")),
                new Country("Austria", new BigDecimal("9002414"))
        );

        //when
        Set<Country> resultSet = europe.getCountrySet();

        //then
        Assertions.assertEquals(3, resultSet.size());
        Assertions.assertEquals(expectedSet, resultSet);
    }
}