package com.kodilla.exception.test;

public class Power {

    public double power(double a, double b) {
        double result = 1;
        for (int i = 0; i < b; i++) {
            result *= a;
        }
        return result;
    }

    public static void main(String[] args) {

        Power p = new Power();
        double result = p.power(5, 0);
        System.out.println(result);
    }
}