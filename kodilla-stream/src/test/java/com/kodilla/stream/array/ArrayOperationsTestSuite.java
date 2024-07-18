package com.kodilla.stream.array;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class ArrayOperationsTestSuite {

    @DisplayName("The method should return the average of all numbers provided in array")
    @Test
    void testGetAverage() {
        //given
        PopulationCalculator calculator = new PopulationCalculator();

        //when
        double result = ArrayOperations.getAverage(calculator.getPopulationArray());

        //then
        Assertions.assertEquals(3960000, result, 0.0);
    }

    @DisplayName("The method should return the average of all numbers provided in array")
    @Test
    void testGetAverageNumbers() {
        //given
        int[] numbers = {2, 41, 6, 32, 55};

        //when
        double resultNumbers = ArrayOperations.getAverage(numbers);

        //then
        Assertions.assertEquals(27.2, resultNumbers, 0.0);
    }

    @DisplayName("When the array contains only one number, the method should return this number")
    @Test
    void testGetAverageSingleNumber() {
        //given
        int[] singleNumber = {11};

        //when
        double resultSingleNumber = ArrayOperations.getAverage(singleNumber);

        //then
        Assertions.assertEquals(11, resultSingleNumber, 0.0);
    }

    @DisplayName("When the array is empty, the method should return 0")
    @Test
    void testGetAverageIfEmpty() {
        //given
        int[] empty = {};

        //when
        double resultEmpty = ArrayOperations.getAverage(empty);

        //then
        Assertions.assertEquals(0, resultEmpty, 0.0);
    }

    @DisplayName("When the array is null, the method should return 0")
    @Test
    void testGetAverageIfNull() {
        //given
        int[] nl = null;

        //when
        double resultNull = ArrayOperations.getAverage(nl);

        //then
        Assertions.assertEquals(0, resultNull, 0.0);
    }
}