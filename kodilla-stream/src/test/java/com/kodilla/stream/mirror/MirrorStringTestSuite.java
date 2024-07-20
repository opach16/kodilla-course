package com.kodilla.stream.mirror;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class MirrorStringTestSuite {

    @Test
    void testMirrorString() {
        //given
        MirrorString mirror = new MirrorString();

        //when
        String result = mirror.turn("Example");

        //then
        Assertions.assertEquals("elpmaxE", result);
    }

    @Test
    void testMirrorStringEmpty() {
        //given
        MirrorString mirror = new MirrorString();

        //when
        String result = mirror.turn("");

        //then
        Assertions.assertEquals("", result);
    }

    @Test
    void testMirrorStringNull() {
        //given
        MirrorString mirror = new MirrorString();

        //when
        String result = mirror.turn(null);

        //then
        Assertions.assertEquals("", result);
    }
}