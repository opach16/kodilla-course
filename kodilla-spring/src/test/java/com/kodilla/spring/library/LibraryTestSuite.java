package com.kodilla.spring.library;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.util.Arrays;

@SpringBootTest
public class LibraryTestSuite {

    @Test
    void testContext() {
        //given
        ApplicationContext context = new AnnotationConfigApplicationContext(LibraryConfig.class);

        //when & then
        System.out.println("==== BEAN LIST ====");
        Arrays.stream(context.getBeanDefinitionNames())
                .forEach(System.out::println);
        System.out.println("==== BEAN LIST ====");
    }

    @Test
    void testSaveToDb() {
        //given
        ApplicationContext context = new AnnotationConfigApplicationContext(LibraryConfig.class);
        Library library = context.getBean(Library.class);
        //when
        library.saveToDb();

        //then

    }

    @Test
    void testLoadFromDb() {
        //given
        ApplicationContext context = new AnnotationConfigApplicationContext(LibraryConfig.class);
        Library library = context.getBean(Library.class);
        //when
        library.loadFromDb();

        //then
    }
}
