package com.kodilla.good.patterns.challenges;

import com.kodilla.good.patterns.challenges.factorial.Factorial;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class FactorialTestSuite {

    @Test
    void testCalculate() {
        //when & then
        assertEquals(120, Factorial.calculate(5));
        assertEquals(6, Factorial.calculate(3));
        assertEquals(720, Factorial.calculate(6));
    }
}
