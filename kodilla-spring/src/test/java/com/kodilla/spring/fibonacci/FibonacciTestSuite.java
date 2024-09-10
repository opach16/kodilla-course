package com.kodilla.spring.fibonacci;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest
public class FibonacciTestSuite {


    @Test
    void fibonacciTest() {
        //given
        ApplicationContext context = new AnnotationConfigApplicationContext("com.kodilla.spring.fibonacci");
        Fibonacci fibonacci = context.getBean(Fibonacci.class);

        //when & then
        assertEquals(8, fibonacci.calculate(6));
        assertEquals(1, fibonacci.calculate(2));
        assertEquals(34, fibonacci.calculate(9));
    }
}
