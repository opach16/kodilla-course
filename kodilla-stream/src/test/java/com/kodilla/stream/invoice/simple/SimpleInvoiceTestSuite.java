package com.kodilla.stream.invoice.simple;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class SimpleInvoiceTestSuite {

    @Test
    void testGetValueToPay() {
        //given
        SimpleInvoice invoice = new SimpleInvoice();

        //when
        invoice.addItem(new SimpleItem(new SimpleProduct("product1", 17.28), 2.0));
        invoice.addItem(new SimpleItem(new SimpleProduct("product2", 11.99), 3.5));
        invoice.addItem(new SimpleItem(new SimpleProduct("product2", 6.49), 5.0));

        //then
        Assertions.assertEquals(108.975, invoice.getValueToPay(), 0.001);
    }
}
