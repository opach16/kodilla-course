package com.kodilla.spring.fibonacci;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class RecurrentFibonacciTestSuite {

    @Test
    void testFibonacci() {
        //given
        //when & than
        assertEquals(8, FibonacciRecurrent.calculate(6));
        assertEquals(1, FibonacciRecurrent.calculate(2));
        assertEquals(34, FibonacciRecurrent.calculate(9));
    }
}
