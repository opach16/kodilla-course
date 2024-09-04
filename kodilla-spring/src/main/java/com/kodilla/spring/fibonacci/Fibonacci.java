package com.kodilla.spring.fibonacci;

import org.springframework.stereotype.Component;

@Component
public class Fibonacci {

    public int calculate(final int number) {

        int a = 0;
        int b = 1;
        int result = 0;

        if (number == 1) {
            result = a;
        } else if (number == 2) {
            result = b;
        }

        for (int i = 0; i < number - 2; i++) {
            if (a > b) {
                b = a + b;
                result = b;
            } else {
                a = a + b;
                result = a;
            }
        }
        return result;
    }
}
