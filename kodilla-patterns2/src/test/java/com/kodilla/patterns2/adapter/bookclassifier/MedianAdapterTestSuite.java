package com.kodilla.patterns2.adapter.bookclassifier;

import com.kodilla.patterns2.adapter.bookclassifier.librarya.Book;
import org.junit.jupiter.api.Test;

import java.util.Set;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class MedianAdapterTestSuite {

    @Test
    void publicationYearMedianTest() {
        //given
        MedianAdapter medianAdapter = new MedianAdapter();
        Set<Book> bookSet = Set.of(
                new Book("author1", "title1", 2001, "signature1"),
                new Book("author2", "title2", 2002, "signature2"),
                new Book("author3", "title3", 2003, "signature3"),
                new Book("author4", "title4", 2004, "signature4"),
                new Book("author5", "title5", 2005, "signature5")
        );
        //when
        int median = medianAdapter.publicationYearMedian(bookSet);
        //then
        assertEquals(2003, median);
    }
}
