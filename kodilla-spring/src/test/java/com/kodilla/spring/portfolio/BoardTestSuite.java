package com.kodilla.spring.portfolio;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
public class BoardTestSuite {

    @Test
    void testTaskAdd() {
        //given
        ApplicationContext context = new AnnotationConfigApplicationContext(BoardConfig.class);
        Board board = (Board) context.getBean("board");

        //when
        board.getTodoList().addTask("Sweep the floor");
        board.getInProgressList().addTask("Cook dinner");
        board.getDoneList().addTask("Do shopping");

        //then
        assertEquals("Sweep the floor", board.getTodoList().getTasks().get(0));
        assertEquals("Cook dinner", board.getInProgressList().getTasks().get(0));
        assertEquals("Do shopping", board.getDoneList().getTasks().get(0));
    }
}
