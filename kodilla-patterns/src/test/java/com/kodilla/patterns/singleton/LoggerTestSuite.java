package com.kodilla.patterns.singleton;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class LoggerTestSuite {

    @Test
    void testGetLog() {
        //given
        Logger logger = Logger.INSTANCE;
        logger.log("BCA");
        logger.log("CAB");
        logger.log("ACB");
        logger.log("ABC");

        //when
        String lastLog = logger.getLastLog();

        //then
        assertEquals("ABC", lastLog);
    }
}
