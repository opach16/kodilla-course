package com.kodilla.good.patterns.challenges;

public class DataBaseService implements OrderRepository {

    @Override
    public void createOrder(User user, Product product) {
        System.out.println(String.format("<%s : %s> Entry was saved into database", user.getName(), product.getName()));
    }
}
