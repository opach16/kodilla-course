package com.kodilla.good.patterns.foodToDoor;

import com.kodilla.good.patterns.foodToDoor.deliveryService.DeliveryService;

public record Order(DeliveryService deliveryService, int quantity, String productName) {

}
