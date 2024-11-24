package com.kodilla.patterns2.aop.calculator;

import org.junit.jupiter.api.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.math.BigDecimal;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
public class CalculatorTestSuite {

    private static final Logger LOGGER = LoggerFactory.getLogger(CalculatorTestSuite.class);

    @Autowired
    private Calculator calculator;

    @Test
    public void additionTest() {
        //when
        double result = calculator.add(1, 2);
        //then
        LOGGER.info("Testing add method");
        assertEquals(3, result, 0);
    }

    @Test
    public void subtractionTest() {
        //when
        double result = calculator.subtract(5, 2);
        //then
        LOGGER.info("Testing subtract method");
        assertEquals(3, result, 0);
    }

    @Test
    public void multiplicationTest() {
        //when
        double result = calculator.multiply(5, 2);
        //then
        LOGGER.info("Testing multiply method");
        assertEquals(10, result, 0);
    }

    @Test
    public void divisionTest() {
        //when
        double result = calculator.divide(6, 2);
        //then
        LOGGER.info("Testing divide method");
        assertEquals(3, result, 0);
        assertThrows(ArithmeticException.class, () -> calculator.divide(6, 0));
    }

    @Test
    void testFactorial() {
        //when
        BigDecimal result = calculator.factorial(new BigDecimal(100));
        LOGGER.info("Testing factorial method");
        assertTrue(BigDecimal.ONE.compareTo(result) < 0);
    }
}
