package com.kodilla.good.patterns.challenges.factorial;

import java.util.stream.Stream;

public class Factorial {
    public static void main(String[] args) {
        int result = calculate(5);
    }

    public static int calculate(final int number) {
        return Stream.iterate(1, n -> n + 1)
                .limit(number)
                .reduce(1, (result, current) -> result * current);
    }
}
