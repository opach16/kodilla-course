package com.kodilla.patterns.builder.pizza;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class PizzaTestSuite {

    @Test
    void testPizzaNew() {
        //given
        Pizza pizza = new Pizza.PizzaBuilder()
                .ingredient("Onion")
                .bottom("Thin")
                .sauce("Spicy")
                .ingredient("Ham")
                .ingredient("Mushrooms")
                .build();
        System.out.println(pizza);
        //when
        int howManyIngredients = pizza.getIngredients().size();
        //then
        Assertions.assertEquals(3, howManyIngredients);
    }
}
