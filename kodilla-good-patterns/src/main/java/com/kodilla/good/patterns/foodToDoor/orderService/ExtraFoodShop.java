package com.kodilla.good.patterns.foodToDoor.orderService;

import com.kodilla.good.patterns.foodToDoor.Order;

public class ExtraFoodShop implements OrderService {

    private final String name = "Extra Food Shop";

    @Override
    public boolean process(Order order) {
        System.out.println(order.quantity() + " of '" + order.productName() + "' ordered.");
        return true;
    }

    public String getName() {
        return name;
    }
}
