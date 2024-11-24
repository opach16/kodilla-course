package com.kodilla.patterns2.decorator.pizza;

import java.math.BigDecimal;

public class DeliveryPizzaDecorator extends AbstractPizzaOrderDecorator {

    public DeliveryPizzaDecorator(final PizzaOrder pizzaOrder) {
        super(pizzaOrder);
    }

    @Override
    public BigDecimal getCost() {
        return super.getCost().add(new BigDecimal(5));
    }

    @Override
    public String getDescription() {
        return super.getDescription() + " + delivery service";
    }
}
