package com.kodilla.patterns.strategy;

import com.kodilla.patterns.strategy.predictors.BalancedPredictor;

public class CorporateCustomer extends Customer {

    public CorporateCustomer(final String name) {
        super(name);
        this.buyPredictor = new BalancedPredictor();
    }
}
