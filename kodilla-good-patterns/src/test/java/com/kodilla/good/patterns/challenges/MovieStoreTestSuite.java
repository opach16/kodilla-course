package com.kodilla.good.patterns.challenges;

import org.junit.jupiter.api.Test;

import java.util.List;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.*;

public class MovieStoreTestSuite {

    @Test
    void testCollectTittles() {
        //given
        MovieStore movieStore = new MovieStore();
        List<String> translations = List.of("IronMan", "Żelazny Człowiek");
        List<String> translations1 = List.of("Flash", "Błyskawica");
        Map<String, List<String>> movies = Map.of("IM", translations, "Flash", translations1);
        String expected = "IronMan ! Żelazny Człowiek ! Flash ! Błyskawica";
        String expected1 = "Flash ! Błyskawica ! IronMan ! Żelazny Człowiek";

        //when
        String result = movieStore.collectTittles(movies);

        //then
        assertTrue(result.equals(expected) || result.equals(expected1));
    }
}
