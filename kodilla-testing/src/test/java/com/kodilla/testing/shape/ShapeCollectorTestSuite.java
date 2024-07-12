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
            //given
            Shape circle = new Circle(5);
            ShapeCollector collector = new ShapeCollector();

            //when
            collector.addFigure(circle);

            //then
            assertEquals(1, collector.getNumberOfFigures());
        }

        @Test
        public void removeFigureTest() {
            //given
            Shape circle = new Circle(5);
            ShapeCollector collector = new ShapeCollector();
            collector.addFigure(circle);

            //when
            boolean result = collector.removeFigure(circle);

            //then
            assertTrue(result);
            assertEquals(0, collector.getNumberOfFigures());
        }
    }

    @Nested
    @DisplayName("Getting figures")
    public class FigureAccess {
        @Test
        public void getFiguresTest() {
            //given
            Shape circle = new Circle(5);
            ShapeCollector collector = new ShapeCollector();
            collector.addFigure(circle);

            //when
            Shape retrievedShape = collector.getFigure(0);

            //then
            assertEquals(circle, retrievedShape);
        }

        @Test
        public void showFiguresTest() {
            //given
            Shape circle = new Circle(5);
            Shape square = new Square(5);
            ShapeCollector collector = new ShapeCollector();
            collector.addFigure(circle);
            collector.addFigure(square);

            //when
            String result = collector.showFigures();

            //then
            assertEquals("Circle, Square", result);
        }
    }
}