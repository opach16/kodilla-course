package com.kodilla.exception.test;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class PowerTestSuite {

    @Test
    void testPower() {
        //given
        Power p = new Power();

        //then
        assertEquals(0, p.power(0, 8));
        assertEquals(1, p.power(4, 0));
        assertEquals(4, p.power(4, 1));
        assertEquals(125, p.power(5, 3));
    }
}
