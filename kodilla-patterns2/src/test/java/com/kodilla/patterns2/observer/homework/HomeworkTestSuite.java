package com.kodilla.patterns2.observer.homework;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class HomeworkTestSuite {

    @Test
    void testUpdate() {
        //given
        UserTasks tasks1 = new UserTasks("Biology");
        UserTasks tasks2 = new UserTasks("Physics");
        UserTasks tasks3 = new UserTasks("Mathematics");
        Mentor mentor1 = new Mentor("Piotr");
        Mentor mentor2 = new Mentor("Karol");
        tasks1.registerObserver(mentor1);
        tasks1.registerObserver(mentor2);
        tasks2.registerObserver(mentor1);
        tasks3.registerObserver(mentor1);
        //when
        tasks1.addTask("homework1");
        tasks1.addTask("homework2");
        tasks2.addTask("homework3");
        tasks3.addTask("homework4");
        tasks3.addTask("homework5");
        tasks3.addTask("homework6");
        //then
        assertEquals(6, mentor1.getUpdateCount());
        assertEquals(2, mentor2.getUpdateCount());
    }
}
