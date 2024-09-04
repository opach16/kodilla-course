package com.kodilla.spring.reader;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Conditional;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Scope;

@Configuration
public class ReaderConfig {

    @Autowired
    @Qualifier("book1")
    Book book;

    @Bean
    public Reader reader() {
        return new Reader(book);
    }

    @Bean(name="book1")
    @Scope("prototype")
    public Book book1() {
        return new Book("The book number one");
    }

    @Bean(name="book2")
    @Scope("prototype")
    @Conditional(IfDayIsOddCondition.class)
    public Book book2() {
        return new Book("The book number two");
    }

}
