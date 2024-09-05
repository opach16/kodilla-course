package com.kodilla.good.patterns.foodToDoor;

import com.kodilla.good.patterns.foodToDoor.deliveryService.Dhl;
import com.kodilla.good.patterns.foodToDoor.orderService.ExtraFoodShop;
import com.kodilla.good.patterns.foodToDoor.orderService.GlutenFreeShop;
import com.kodilla.good.patterns.foodToDoor.orderService.HealthyShop;
import com.kodilla.good.patterns.foodToDoor.orderService.OrderService;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertTrue;

public class OrderServiceTestSuite {

    Order order = new Order(new Dhl(), 12, "Bread");
    OrderService extraFoodShop = new ExtraFoodShop();
    OrderService getExtraFoodShop = new GlutenFreeShop();
    OrderService healthyShop = new HealthyShop();

    @Test
    void testProcess() {
        //given
        //when
        boolean result1 = extraFoodShop.process(order);
        boolean result2 = getExtraFoodShop.process(order);
        boolean result3 = healthyShop.process(order);
        //then
        assertTrue(result1);
        assertTrue(result2);
        assertTrue(result3);
    }
}
