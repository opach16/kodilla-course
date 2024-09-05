package com.kodilla.good.patterns.foodToDoor.orderService;

import com.kodilla.good.patterns.foodToDoor.Order;

public class GlutenFreeShop implements OrderService {

    private final String name = "Gluten Free Shop";

    @Override
    public boolean process(Order order) {
        System.out.println("Ordered: " + order.quantity() + " of '" + order.productName() + "'");
        return true;
    }
}
