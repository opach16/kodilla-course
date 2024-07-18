package com.kodilla.stream.book;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.List;
import java.util.stream.IntStream;

public class BookTestSuite {

    @Test
    void testGetListUsingFor() {
        //given
        BookDirectory bookDirectory = new BookDirectory();

        //when
        List<Book> books = bookDirectory.getList();
        int numberOfBooksAfter2007 = 0;
        for (Book book : books) {
            if (book.getYearOfPublication() > 2007) {
                numberOfBooksAfter2007++;
            }
        }

        //then
        Assertions.assertEquals(3, numberOfBooksAfter2007);
    }

    @Test
    void testGetListUsingIntStream() {
        //given
        BookDirectory bookDirectory = new BookDirectory();

        //when
        List<Book> books = bookDirectory.getList();

        //then
        long numberOfBooksAfter2007 = IntStream.range(0, books.size())
                .filter(n -> books.get(n).getYearOfPublication() > 2007)
                .map(n -> 1)
                .sum();

        Assertions.assertEquals(3, numberOfBooksAfter2007);
    }
}