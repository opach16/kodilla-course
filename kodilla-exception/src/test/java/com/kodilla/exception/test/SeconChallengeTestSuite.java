package com.kodilla.exception.test;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class SeconChallengeTestSuite {

    @DisplayName("This test verify that an exception is thrown when the values \'x\' or \'y\' are out of the valid range")
    @Test
    void testProbablyIWillThrowAnException() {
        //given
        SecondChallenge secondChallenge = new SecondChallenge();

        //when & then
        assertAll(
                () -> assertThrows(Exception.class, () -> secondChallenge.probablyIWillThrowException(2, 1)),
                () -> assertThrows(Exception.class, () -> secondChallenge.probablyIWillThrowException(0, 1)),
                () -> assertThrows(Exception.class, () -> secondChallenge.probablyIWillThrowException(1, 1.5))
        );
    }

    @DisplayName("This test verify that an exception is not thrown when the values \'x\' or \'y\' are within the valid range")
    @Test
    void testProbablyIWillThrowAnExceptionIfNotThrow() {
        //given
        SecondChallenge secondChallenge = new SecondChallenge();

        //when & then
        assertAll(
                () -> assertDoesNotThrow(() -> secondChallenge.probablyIWillThrowException(1.9, 1)),
                () -> assertDoesNotThrow(() -> secondChallenge.probablyIWillThrowException(1, 1))
        );
    }

    @DisplayName("This test verify the return value when any exception is thrown")
    @Test
    void testProbablyIWillThrowAnExceptionReturnValue() {
        //given
        SecondChallenge secondChallenge = new SecondChallenge();
        String result = "";

        //when
        try {
            result = secondChallenge.probablyIWillThrowException(1, 1);
        } catch (Exception e) {
            System.out.println("Something went wrong");
        }

        //then
        assertEquals("Done!", result);
    }
}