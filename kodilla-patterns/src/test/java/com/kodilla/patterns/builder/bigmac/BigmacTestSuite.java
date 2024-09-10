package com.kodilla.patterns.builder.bigmac;

import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

public class BigmacTestSuite {

    @Test
    void testBigmacBuilder() {
        //given
        //when
        Bigmac bigmac = new Bigmac.BigmacBuilder()
                .bun(Bun.BUN)
                .burgers(3)
                .sauce(Sauce.BARBECUE)
                .ingredient(Ingredient.CHEESE)
                .ingredient(Ingredient.ONION)
                .ingredient(Ingredient.SALAD)
                .ingredient(Ingredient.BEACON)
                .build();
        //then
        System.out.println(bigmac);
        assertEquals("BUN", bigmac.getBun());
        assertEquals(3, bigmac.getBurgers());
        assertEquals("BARBECUE", bigmac.getSauce());
        assertTrue(bigmac.getIngredients().containsAll(List.of("CHEESE", "ONION", "SALAD", "BEACON")));
    }
}
