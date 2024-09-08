package com.kodilla.patterns.prototype;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.stream.IntStream;

public class BoardTestSuite {

    @Test
    void testToString() {
        //given
        TasksList listToDo = new TasksList("To Do Tasks");
        IntStream.iterate(1, n -> n + 1)
                .limit(10)
                .forEach(n -> listToDo.getTasks().add(new Task("ToDo task" + n)));

        TasksList listInProgress = new TasksList("In Progress Tasks");
        IntStream.iterate(1, n -> n + 1)
                .limit(10)
                .forEach(n -> listInProgress.getTasks().add(new Task("InProgress task" + n)));

        TasksList listDone = new TasksList("Done Tasks");
        IntStream.iterate(1, n -> n + 1)
                .limit(10)
                .forEach(n -> listDone.getTasks().add(new Task("Done task" + n)));

        Board board = new Board("Project number 1");
        board.getLists().add(listToDo);
        board.getLists().add(listInProgress);
        board.getLists().add(listDone);

        Board clonedBoard = null;
        try {
            clonedBoard = board.shallowCopy();
            clonedBoard.setName("Project number 2");
        } catch (CloneNotSupportedException e) {
            System.out.println(e.getMessage());
        }

        Board deepClonedBoard = null;
        try {
            deepClonedBoard = board.deepCopy();
            deepClonedBoard.setName("Project number 3");
        } catch (CloneNotSupportedException e) {
            System.out.println(e.getMessage());
        }

        //when
        board.getLists().remove(listToDo);

        //then
        System.out.println(board);
        System.out.println(clonedBoard);
        System.out.println(deepClonedBoard);
        Assertions.assertEquals(2, board.getLists().size());
        Assertions.assertEquals(2, clonedBoard.getLists().size());
        Assertions.assertEquals(3, deepClonedBoard.getLists().size());
        Assertions.assertEquals(clonedBoard.getLists(), board.getLists());
        Assertions.assertNotEquals(deepClonedBoard.getLists(), board.getLists());
    }
}
