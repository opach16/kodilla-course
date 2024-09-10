package com.kodilla.spring.fibonacci;

public class FibonacciRecurrent {

    public static int calculate(int n) {
        if (n == 0 || n == 1) {
            return n;
        } else {
            return calculate(n - 1) + calculate(n - 2);
        }
    }
}
