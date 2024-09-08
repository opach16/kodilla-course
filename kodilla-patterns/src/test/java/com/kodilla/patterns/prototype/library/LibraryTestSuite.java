package com.kodilla.patterns.prototype.library;

import org.junit.jupiter.api.Test;

import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class LibraryTestSuite {

    @Test
    void testGetBooks() {
        //given
        Library library = new Library("National Library");
        Book book = new Book("Title", "Author", LocalDate.now());
        library.getBooks().add(book);
        for (int i = 1; i < 10; i++) {
            library.getBooks().add(new Book("Title" + i, "Author" + (i + 100), LocalDate.now().minusYears(i)));
        }

        Library shallowClonedLibrary = null;
        try {
            shallowClonedLibrary = library.shallowCopy();
        } catch (CloneNotSupportedException e) {
            System.out.println(e.getMessage());
        }

        Library deepClonedLibrary = null;
        try {
            deepClonedLibrary = library.deepCopy();
        } catch (CloneNotSupportedException e) {
            System.out.println(e.getMessage());
        }

        //when
        library.getBooks().remove(book);

        //then
        System.out.println(library);
        System.out.println(shallowClonedLibrary);
        System.out.println(deepClonedLibrary);
        assertEquals(9, library.getBooks().size());
        assertEquals(9, shallowClonedLibrary.getBooks().size());
        assertEquals(10, deepClonedLibrary.getBooks().size());
    }
}
