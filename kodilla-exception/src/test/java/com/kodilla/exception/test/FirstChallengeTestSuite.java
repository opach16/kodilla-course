package com.kodilla.exception.test;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class FirstChallengeTestSuite {

    @Test
    void testDevide() {
        //given
        FirstChallenge firstChallenge = new FirstChallenge();

        //when
        double result = firstChallenge.divide(12, 4);

        //then
        assertEquals(3, result);
    }

    @Test
    void testDivideByZero() {
        //given
        FirstChallenge firstChallenge = new FirstChallenge();

        //then
        assertThrows(ArithmeticException.class, () -> firstChallenge.divide(5, 0), "Divide by zero");
    }
}
