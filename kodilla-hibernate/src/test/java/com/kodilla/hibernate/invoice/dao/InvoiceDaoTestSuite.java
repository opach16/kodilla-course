package com.kodilla.hibernate.invoice.dao;

import com.kodilla.hibernate.invoice.Invoice;
import com.kodilla.hibernate.invoice.Item;
import com.kodilla.hibernate.invoice.Product;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.math.BigDecimal;

import static org.junit.jupiter.api.Assertions.assertNotEquals;

@SpringBootTest
public class InvoiceDaoTestSuite {

    @Autowired
    private InvoiceDao invoiceDao;

    @Test
    void testInvoiceDaoSave() {
        //given
        Item item1 = new Item(new BigDecimal(50), 3, new BigDecimal(150));
        Item item2 = new Item(new BigDecimal(40), 4, new BigDecimal(160));
        Item item3 = new Item(new BigDecimal(10), 3, new BigDecimal(30));
        Item item4 = new Item(new BigDecimal(50), 10, new BigDecimal(500));

        Product product1 = new Product("Cleaning cloth");
        Product product2 = new Product("Cleaning detergent");
        Product product3 = new Product("Trash bag");
        Product product4 = new Product("Air Freshener");

        item1.setProduct(product1);
        item2.setProduct(product3);
        item3.setProduct(product4);
        item4.setProduct(product2);

        Invoice invoice1 = new Invoice("2024_03_21_001");
        Invoice invoice2 = new Invoice("2024_03_21_002");

        invoice1.getItems().add(item1);
        invoice1.getItems().add(item2);
        invoice2.getItems().add(item3);
        invoice2.getItems().add(item4);

        item1.setInvoice(invoice1);
        item2.setInvoice(invoice1);
        item3.setInvoice(invoice2);
        item4.setInvoice(invoice2);

        //when
        invoiceDao.save(invoice1);
        invoiceDao.save(invoice2);
        int invoice1Id = invoice1.getId();
        int invoice2Id = invoice2.getId();

        //then
        assertNotEquals(0, invoice1Id);
        assertNotEquals(0, invoice2Id);

        //cleanUp
        try {
            invoiceDao.deleteById(invoice1Id);
            invoiceDao.deleteById(invoice2Id);
        } catch (RuntimeException e) {
            System.out.println("TEST CLEANUP: Erasing records error");
        }
    }
}
