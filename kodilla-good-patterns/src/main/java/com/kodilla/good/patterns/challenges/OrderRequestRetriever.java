package com.kodilla.good.patterns.challenges;

import java.math.BigDecimal;

public class OrderRequestRetriever {

    public OrderRequest retrieve() {
        User user = new User("John Smith");
        Product product = new Product("Apple", new BigDecimal(1.2));
        return new OrderRequest(user, product);
    }
}
