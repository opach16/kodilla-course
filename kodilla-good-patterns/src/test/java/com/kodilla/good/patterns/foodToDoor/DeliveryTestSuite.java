package com.kodilla.good.patterns.foodToDoor;

import com.kodilla.good.patterns.foodToDoor.deliveryService.DeliveryService;
import com.kodilla.good.patterns.foodToDoor.deliveryService.Dhl;
import com.kodilla.good.patterns.foodToDoor.deliveryService.Dpd;
import com.kodilla.good.patterns.foodToDoor.deliveryService.FedEx;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertTrue;

public class DeliveryTestSuite {

    DeliveryService dhl = new Dhl();
    DeliveryService dpd = new Dpd();
    DeliveryService fedEx = new FedEx();

    @Test
    void testDelivery() {
        //given
        //when
        boolean result1 = dhl.deliver();
        boolean result2 = dhl.deliver();
        boolean result3 = dhl.deliver();

        //then
        assertTrue(result1);
        assertTrue(result2);
        assertTrue(result3);
    }
}
