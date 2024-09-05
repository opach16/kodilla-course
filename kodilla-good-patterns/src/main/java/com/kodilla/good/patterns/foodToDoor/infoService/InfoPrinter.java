package com.kodilla.good.patterns.foodToDoor.infoService;

public class InfoPrinter implements InformationService {

    @Override
    public void thanksForOrder() {
        System.out.println("Thank you for your order!");
    }

    @Override
    public void orderError() {
        System.out.println("Something went wrong with your order!");
    }

    @Override
    public void deliveryError() {
        System.out.println("Sorry, we could not deliver your order!");
    }
}
