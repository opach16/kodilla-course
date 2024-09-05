package com.kodilla.good.patterns.foodToDoor.orderService;

import com.kodilla.good.patterns.foodToDoor.Order;

public class HealthyShop implements OrderService {

    private final String name = "Healthy Shop";

    @Override
    public boolean process(Order order) {
        System.out.println("The order of " + order.quantity() + " of '" + order.productName() + "' has been created.");
        return true;
    }

    public String getName() {
        return name;
    }
}
