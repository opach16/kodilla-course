package com.kodilla.jdbc.additional_exercise;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class FindMinMaxTestSuite {

    @Test
    void findMinMax() {
        //given
        int[] numbers = new int[]{4, 21, 4, 23, 4, 5, 12, 4, 5, 6, 2, 9};
        //when & then
        assertEquals(2, FindMinMax.findMin(numbers));
        assertEquals(23, FindMinMax.findMax(numbers));
    }
}
