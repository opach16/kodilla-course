package com.kodilla.good.patterns.foodToDoor;

import com.kodilla.good.patterns.foodToDoor.infoService.InfoPrinter;
import com.kodilla.good.patterns.foodToDoor.orderService.ExtraFoodShop;

public class Application {
    public static void main(String[] args) {

        OrderRequest orderRequest = new OrderRequest();
        OrderProcessor orderProcessor = new OrderProcessor(new ExtraFoodShop(), new InfoPrinter());

        orderProcessor.order(orderRequest.createOrder());
    }
}
