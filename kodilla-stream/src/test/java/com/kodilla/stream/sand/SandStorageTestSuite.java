package com.kodilla.stream.sand;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

public class SandStorageTestSuite {

    @Test
    void testGetSandBeansQuantity() {
        //given
        List<SandStorage> continents = new ArrayList<>();
        continents.add(new Europe());
        continents.add(new Asia());
        continents.add(new Africa());
        BigDecimal expectedQuantity = new BigDecimal("211111110903703703670");

        //when
        BigDecimal sandQuantity = BigDecimal.ZERO;
        for (SandStorage continent : continents) {
            sandQuantity = sandQuantity.add(continent.getSandBeansQuantity());
        }
        //then
        Assertions.assertEquals(expectedQuantity, sandQuantity);
    }

    @Test
    void testGetSandBeansQuantityWithReduce() {
        //given
        List<SandStorage> continents = new ArrayList<>();
        continents.add(new Europe());
        continents.add(new Asia());
        continents.add(new Africa());
        BigDecimal expectedQuantity = new BigDecimal("211111110903703703670");

        //when
        BigDecimal sandQuantity = continents.stream()
                .map(SandStorage::getSandBeansQuantity)
                .reduce(BigDecimal.ZERO, (sum, current) -> sum.add(current));

        //then
        Assertions.assertEquals(expectedQuantity, sandQuantity);
    }
}
