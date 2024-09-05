package com.kodilla.good.patterns.foodToDoor.deliveryService;

public class Dhl implements DeliveryService {

   private final String name = "DHL";

    @Override
    public boolean deliver() {
        System.out.println("Product will be delivered by DHL.");
        return true;
    }

    public String getName() {
        return name;
    }
}
