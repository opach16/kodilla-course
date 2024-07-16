package com.kodilla.stream.beautifier;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;

import org.junit.jupiter.api.*;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;


@ExtendWith(MockitoExtension.class)
public class PoemBeautifierTestSuite {

    private PoemBeautifier poemBeautifier;
    private ByteArrayOutputStream outContent;

    @Mock
    private PoemDecorator decoratorMock;

    @BeforeEach
    void beforeEachCase() {
        poemBeautifier = new PoemBeautifier();
        outContent = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outContent));
    }

    @AfterEach
    void AfterEachCase() {
        System.setOut(null);
    }

    @DisplayName("Verify the output captured text matches with expected uppercase written text")
    @Test
    void testDecorateText() {
        //given
        String text = "Text to be beautified";
        String decoratedText = "TEXT TO BE BEAUTIFIED";
        when(decoratorMock.decorate(text)).thenReturn("TEXT TO BE BEAUTIFIED");

        //when
        poemBeautifier.beautify(text, decoratorMock);

        //then
        assertEquals(decoratedText + System.lineSeparator(), outContent.toString());
    }

    @DisplayName("Verify that the output captured text is empty if provided text is empty")
    @Test
    void testEmptyText() {
        //given
        String text = "";
        String decoratedText = "";
        when(decoratorMock.decorate(text)).thenReturn("");

        //when
        poemBeautifier.beautify(text, decoratorMock);

        //then
        assertEquals(decoratedText + System.lineSeparator(), outContent.toString());
    }
}