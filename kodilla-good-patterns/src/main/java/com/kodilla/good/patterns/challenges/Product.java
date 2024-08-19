package com.kodilla.good.patterns.challenges;

import java.math.BigDecimal;

public class Product {

    private final String name;
    private BigDecimal price;

    public Product(String name, BigDecimal price) {
        this.name = name;
        this.price = price;
    }

    public String getName() {
        return name;
    }
}
