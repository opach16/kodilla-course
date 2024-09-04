package com.kodilla.spring.reader;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

@SpringBootTest
public class ReaderTestSuite {

    @Test
    void testRead() {
        //given
        ApplicationContext context = new AnnotationConfigApplicationContext(ReaderConfig.class);
        Reader reader = context.getBean(Reader.class);

        //when & then
        reader.read();
    }

    @Test
    void testConditional() {
        //given
        ApplicationContext context = new AnnotationConfigApplicationContext(ReaderConfig.class);

        //when
        boolean result = context.containsBean("book2");

        //then
        System.out.println("Bean book2 found in the container: " + result);
    }
}
