package com.kodilla.spring.calculator;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
public class CalculatorTestSuite {

    @Autowired
    Calculator calculator;

    @Test
    void testAddition() {
        //given
        //when
        double result = calculator.add(5, 2);
        //then
        assertEquals(7, result);
    }

    @Test
    void testSubtraction() {
        //given
        //when
        double result = calculator.sub(5, 2);
        //then
        assertEquals(3, result);
    }

    @Test
    void testMultiplication() {
        //given
        //when
        double result = calculator.mul(5, 2);
        //then
        assertEquals(10, result);
    }

    @Test
    void testDivision() {
        //given
        //when
        double result = calculator.div(5, 2);
        //then
        assertEquals(2.5, result);
    }
}
