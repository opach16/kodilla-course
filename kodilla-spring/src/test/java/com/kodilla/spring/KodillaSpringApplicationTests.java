package com.kodilla.spring;

import com.kodilla.spring.shape.Circle;
import com.kodilla.spring.shape.Shape;
import com.kodilla.spring.shape.Square;
import com.kodilla.spring.shape.Triangle;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

@SpringBootTest
class KodillaSpringApplicationTests {

    @Test
    void testShapeLoadedIntoContainer() {
        //given
        ApplicationContext context = new AnnotationConfigApplicationContext("com.kodilla.spring");
        Shape shape = (Shape) context.getBean("chosenShape");

        //when
        String name = shape.getShapeName();

        //then
        System.out.println("Chosen shape says: " + name);
    }

    @Test
    void testSquareLoadedIntoContainer() {
        //given
        ApplicationContext context = new AnnotationConfigApplicationContext("com.kodilla.spring");
        Shape square = (Square) context.getBean("createSquare");

        //when
        String name = square.getShapeName();

        //then
        Assertions.assertEquals("This is a square.", name);
    }

    @Test
    void testCircleLoadedIntoContainer() {
        //given
        ApplicationContext context = new AnnotationConfigApplicationContext("com.kodilla.spring");
        Shape shape = (Circle) context.getBean("circle");

        //when
        String name = shape.getShapeName();
        //then
        Assertions.assertEquals("This is a circle.", name);
    }

    @Test
    void testTriangleLoadedIntoContainer() {
        //given
        ApplicationContext context = new AnnotationConfigApplicationContext("com.kodilla.spring");
        Shape shape = (Triangle) context.getBean("triangle");

        //when
        String name = shape.getShapeName();

        //then
        Assertions.assertEquals("This is a triangle.", name);
    }

    @Test
    void contextLoads() {
    }
}
