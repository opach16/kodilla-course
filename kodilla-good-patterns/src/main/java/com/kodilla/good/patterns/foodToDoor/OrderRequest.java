package com.kodilla.good.patterns.foodToDoor;

import com.kodilla.good.patterns.foodToDoor.deliveryService.FedEx;

public class OrderRequest {

    public Order createOrder() {
        return new Order(new FedEx(), 12, "Bottle of wine");
    }
}
