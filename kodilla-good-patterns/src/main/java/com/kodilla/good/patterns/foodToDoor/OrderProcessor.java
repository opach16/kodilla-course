package com.kodilla.good.patterns.foodToDoor;

import com.kodilla.good.patterns.foodToDoor.infoService.InformationService;
import com.kodilla.good.patterns.foodToDoor.orderService.OrderService;

public class OrderProcessor {

    private final OrderService orderService;
    private final InformationService informationService;

    public OrderProcessor(final OrderService orderService, final InformationService informationService) {
        this.orderService = orderService;
        this.informationService = informationService;
    }

    public void order(Order order) {
        if (orderService.process(order)) {
            if (order.deliveryService().deliver()) {
                informationService.thanksForOrder();
            } else {
                informationService.deliveryError();
            }
        } else {
            informationService.orderError();
        }
    }
}
