package com.kodilla.testing.collection;

import com.kodilla.testing.collection.OddNumbersExterminator;
import org.junit.jupiter.api.*;

import java.util.Arrays;
import java.util.List;

public class CollectionTestSuite {

    @BeforeEach
    void before() {
        System.out.println("Test Case: begin");
    }

    @AfterEach
    void after() {
        System.out.println("Test Case: end");
    }

    @DisplayName(
            "If the provided list is empty, the method should return empty list"
    )
    @Test
    void testOddNumbersExterminatorEmptyList() {
        //Given
        OddNumbersExterminator oddNumbersExterminator = new OddNumbersExterminator();
        Integer[] emptyArray = new Integer[0];

        //When
        List<Integer> expectedList = oddNumbersExterminator.exterminate(Arrays.asList(emptyArray));

        //Then
        Assertions.assertArrayEquals(expectedList.toArray(), emptyArray);
    }

    @DisplayName("""
            If the provided list contains odd numbers, 
            the method should return list of only even numbers
            """)
    @Test
    void testOddNumbersExterminatorNormalList() {
        //Given
        OddNumbersExterminator oddNumbersExterminator = new OddNumbersExterminator();
        //When
        List<Integer> result = oddNumbersExterminator.exterminate(List.of(1, 2, 3, 4, 5, 6));

        //Then
        Assertions.assertEquals(List.of(2, 4, 6), result);
    }
}