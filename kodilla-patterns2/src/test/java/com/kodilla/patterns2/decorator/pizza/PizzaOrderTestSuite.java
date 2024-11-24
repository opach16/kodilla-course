package com.kodilla.patterns2.decorator.pizza;

import org.junit.jupiter.api.Test;

import java.math.BigDecimal;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class PizzaOrderTestSuite {


    @Test
    void testBasicPizzaOrderGetCost() {
        //given
        PizzaOrder pizzaOrder = new BasicPizzaOrder();
        //when
        BigDecimal calculatedCost = pizzaOrder.getCost();
        //then
        assertEquals(15, calculatedCost.intValue());
    }

    @Test
    void testBasicPizzaOrderGetDescription() {
        //given
        PizzaOrder pizzaOrder = new BasicPizzaOrder();
        //when
        String description = pizzaOrder.getDescription();
        //then
        assertEquals("Margherita", description);
    }

    @Test
    void testDoubleCheeseOlivesPizzaOrderGetCost() {
        PizzaOrder pizzaOrder = new BasicPizzaOrder();
        pizzaOrder = new DoubleCheeseDecorator(pizzaOrder);
        pizzaOrder = new OlivesPizzaDecorator(pizzaOrder);
        pizzaOrder = new TakeAwayPizzaDecorator(pizzaOrder);
        //when
        BigDecimal calculatedCost = pizzaOrder.getCost();
        //then
        assertEquals(20, calculatedCost.intValue());
    }

    @Test
    void testDoubleCheeseOlivesPizzaOrderGetDescription() {
        //given
        PizzaOrder pizzaOrder = new BasicPizzaOrder();
        pizzaOrder = new DoubleCheeseDecorator(pizzaOrder);
        pizzaOrder = new OlivesPizzaDecorator(pizzaOrder);
        pizzaOrder = new TakeAwayPizzaDecorator(pizzaOrder);
        //when
        String description = pizzaOrder.getDescription();
        //then
        assertEquals("Margherita + double cheese + olives + take away", description);
    }

    @Test
    void testChorizoDeliveryPizzaOrderGetCost() {
        //given
        PizzaOrder pizzaOrder = new BasicPizzaOrder();
        pizzaOrder = new ChorizoDecorator(pizzaOrder);
        pizzaOrder = new DeliveryPizzaDecorator(pizzaOrder);
        //when
        BigDecimal calculatedCost = pizzaOrder.getCost();
        //then
        assertEquals(23, calculatedCost.intValue());
    }

    @Test
    void testChorizoDeliveryPizzaOrderGetDescription() {
        //given
        PizzaOrder pizzaOrder = new BasicPizzaOrder();
        pizzaOrder = new ChorizoDecorator(pizzaOrder);
        pizzaOrder = new DeliveryPizzaDecorator(pizzaOrder);
        //when
        String description = pizzaOrder.getDescription();
        //then
        assertEquals("Margherita + chorizo + delivery service", description);
    }

}
