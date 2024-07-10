package com.kodilla.testing;

import com.kodilla.testing.calculator.Calculator;
import com.kodilla.testing.user.SimpleUser;

public class TestingMain {

    public static void main(String[] args) {
        SimpleUser simpleUser = new SimpleUser("theForumUser");

        String result = simpleUser.getUsername();

        if (result.equals("theForumUser")) {
            System.out.println("test OK");
        } else {
            System.out.println("Error!");
        }
        System.out.println("Test - pierwszy test jednostkowy:");

        Calculator calculator = new Calculator();
        calculator.add(5, 4);
        calculator.subtract(5, 4);

        if (calculator.add(5, 4) == 5 + 4) {
            System.out.println("test OK");
        } else if (calculator.add(5, 4) != 5 + 4) {
            System.out.println("Error!");
        }

        if (calculator.subtract(5, 4) == 5 - 4) {
            System.out.println("test OK");
        } else if (calculator.subtract(5, 4) != 5 - 4) {
            System.out.println("Error!");
        }
    }
}