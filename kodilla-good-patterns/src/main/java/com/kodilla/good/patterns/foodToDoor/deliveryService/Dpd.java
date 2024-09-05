package com.kodilla.good.patterns.foodToDoor.deliveryService;

public class Dpd implements DeliveryService {

    private final String name = "DPD";

    @Override
    public boolean deliver() {
        System.out.println("Product will be delivered by DPD.");
        return true;
    }

    public String getName() {
        return name;
    }
}
