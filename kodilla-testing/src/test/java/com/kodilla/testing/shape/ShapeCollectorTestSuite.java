package com.kodilla.testing.shape;

import com.kodilla.testing.shape.*;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.*;

@DisplayName("ShapeCollector Test Suite")
public class ShapeCollectorTestSuite {

    private static int testCounter = 0;

    @BeforeEach
    public void beforeEach() {
        testCounter++;
        System.out.println("Preparing to test #" + testCounter);
    }

    @AfterAll
    public static void afterAll() {
        System.out.println("All " + testCounter + " tests executed");
    }

    @Nested
    @DisplayName("Operations on figures")
    public class FigureOperate {
        @Test
        public void addFigureTest() {
            //Given
            Shape circle = new Circle(5);
            ShapeCollector collector = new ShapeCollector();

            //When
            collector.addFigure(circle);

            //Then
            assertEquals(1, collector.getNumberOfFigures());
        }

        @Test
        public void removeFigureTest() {
            //Given
            Shape circle = new Circle(5);
            ShapeCollector collector = new ShapeCollector();
            collector.addFigure(circle);

            //When
            boolean result = collector.removeFigure(circle);

            //Then
            assertTrue(result);
        }
    }

    @Nested
    @DisplayName("Getting figures")
    public class FigureAccess {
        @Test
        public void getFiguresTest() {
            //Given
            Shape circle = new Circle(5);
            ShapeCollector collector = new ShapeCollector();
            collector.addFigure(circle);

            //When
            Shape retrievedShape = collector.getFigure(0);

            //Then
            assertEquals(circle, retrievedShape);
        }

        @Test
        public void showFiguresTest() {
            //Given
            Shape circle = new Circle(5);
            Shape square = new Square(5);
            ShapeCollector collector = new ShapeCollector();
            collector.addFigure(circle);
            collector.addFigure(square);

            //When
            String result = collector.showFigures();

            //Then
            assertEquals("Circle, Square", result);
        }
    }
}