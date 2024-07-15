package com.kodilla.testing.library;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
public class BookDirectoryTestSuite {

    private List<Book> generateListOfNBooks(int booksQuantity) {
        List<Book> resultList = new ArrayList<>();
        for (int n = 1; n <= booksQuantity; n++) {
            resultList.add(new Book("Title" + n, "Author" + n, +1970 + n));
        }
        return resultList;
    }

    @Mock
    private LibraryDatabase libraryDatabaseMock;

    @Test
    public void listBooksWithConditionReturnList() {
        //given
        BookLibrary bookLibrary = new BookLibrary(libraryDatabaseMock);
        List<Book> resultListOfBooks = generateListOfNBooks(4);

        when(libraryDatabaseMock.listBooksWithCondition("Secret")).thenReturn(resultListOfBooks);

        //when
        List<Book> theListOfBooks = bookLibrary.listBooksWithCondition("Secret");

        //then
        assertEquals(4, theListOfBooks.size());
    }

    @Test
    public void listBooksWithConditionMoreThan20() {
        //given
        BookLibrary bookLibrary = new BookLibrary(libraryDatabaseMock);
        List<Book> resultListOf0Books = generateListOfNBooks(0);
        List<Book> resultListOf15Books = generateListOfNBooks(15);
        List<Book> resultListOf40Books = generateListOfNBooks(40);

        when(libraryDatabaseMock.listBooksWithCondition(anyString())).thenReturn(resultListOf15Books);
        when(libraryDatabaseMock.listBooksWithCondition("ZeroBooks")).thenReturn(resultListOf0Books);
        when(libraryDatabaseMock.listBooksWithCondition("FortyBooks")).thenReturn(resultListOf40Books);

        //when
        List<Book> theListOfBooks0 = bookLibrary.listBooksWithCondition("ZeroBooks");
        List<Book> theListOfBooks15 = bookLibrary.listBooksWithCondition("AnyTitle");
        List<Book> theListOfBooks40 = bookLibrary.listBooksWithCondition("FortyBooks");

        //then
        assertEquals(0, theListOfBooks0.size());
        assertEquals(15, theListOfBooks15.size());
        assertEquals(0, theListOfBooks40.size());
    }

    @Test
    public void listBooksWithConditionFragmentShorterThan3() {
        //given
        BookLibrary bookLibrary = new BookLibrary(libraryDatabaseMock);

        //when
        List<Book> theListOfBooks10 = bookLibrary.listBooksWithCondition("An");

        //then
        assertEquals(0, theListOfBooks10.size());
        verify(libraryDatabaseMock, times(0)).listBooksWithCondition(anyString());
    }

    @Test
    public void listBooksInHandsOfTest() {
        //given
        BookLibrary bookLibrary = new BookLibrary(libraryDatabaseMock);
        LibraryUser libraryUser0 = new LibraryUser("John", "Snow", 26);
        LibraryUser libraryUser1 = new LibraryUser("John", "White", 27);
        LibraryUser libraryUser5 = new LibraryUser("John", "Black", 28);
        List<Book> userBooks0 = generateListOfNBooks(0);
        List<Book> userBooks1 = generateListOfNBooks(1);
        List<Book> userBooks5 = generateListOfNBooks(5);

        when(libraryDatabaseMock.listBooksInHandsOf(libraryUser0)).thenReturn(userBooks0);
        when(libraryDatabaseMock.listBooksInHandsOf(libraryUser1)).thenReturn(userBooks1);
        when(libraryDatabaseMock.listBooksInHandsOf(libraryUser5)).thenReturn(userBooks5);

        //when
        List<Book> resultList0 = bookLibrary.listBooksInHandsOf(libraryUser0);
        List<Book> resultList1 = bookLibrary.listBooksInHandsOf(libraryUser1);
        List<Book> resultList5 = bookLibrary.listBooksInHandsOf(libraryUser5);

        //then
        assertEquals(0, resultList0.size());
        assertEquals(1, resultList1.size());
        assertEquals(5, resultList5.size());
    }
}