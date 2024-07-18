package com.kodilla.stream.array;

import java.util.stream.IntStream;

public interface ArrayOperations {

    static double getAverage(int[] numbers) {
        if (numbers == null || numbers.length == 0) {
            return 0;
        }
        IntStream.range(0, numbers.length)
                .map(i -> numbers[i])
                .forEach(System.out::println);
        return IntStream.range(0, numbers.length)
                .mapToDouble(i -> numbers[i])
                .average()
                .getAsDouble();
    }
}