package com.kodilla.good.patterns.foodToDoor.deliveryService;

public class FedEx implements DeliveryService {

    private final String name = "FedEx";

    @Override
    public boolean deliver() {
        System.out.println("Product will be delivered by FedEx.");
        return true;
    }

    public String getName() {
        return name;
    }
}
