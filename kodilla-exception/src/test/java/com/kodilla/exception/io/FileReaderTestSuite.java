package com.kodilla.exception.io;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class FileReaderTestSuite {

    @Test
    void testFileReader() {
        //given
        FileReader fileReader = new FileReader();

        //when & then
        assertDoesNotThrow(() -> fileReader.readFile());
    }

    @Test
    void testFileReaderFileDoesNotExist() {
        //given
        FileReader fileReader = new FileReader();

        //when & then
        assertThrows(FileReaderException.class, () -> fileReader.readFile("Nie_ma_takiego_pliku.txt"));
    }

    @Test
    void testReadFileWithName() {
        //given
        FileReader fileReader = new FileReader();

        //when & then
        assertAll(
                () -> assertThrows(FileReaderException.class, () -> fileReader.readFile("Nie_ma_takiego_pliku.txt")),
                () -> assertThrows(FileReaderException.class, () -> fileReader.readFile(null)),
                () -> assertDoesNotThrow(() -> fileReader.readFile("names.txt"))
        );

    }
}