package com.kodilla.patterns.factory.task;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class TaskFactoryTestSuite {

    @Test
    void testCreateTask() {
        //given
        TaskFactory taskFactory = new TaskFactory();

        //when
        Task drivingTask = taskFactory.createTask("DrivingTask");
        boolean taskNotExecuted = drivingTask.isTaskExecuted();
        drivingTask.executeTask();
        boolean taskExecuted = drivingTask.isTaskExecuted();
        Task paintingTask = taskFactory.createTask("PaintingTask");

        //then
        assertEquals("DrivingTask", drivingTask.getTaskName());
        assertFalse(taskNotExecuted);
        assertTrue(taskExecuted);
        assertEquals("PaintingTask", paintingTask.getTaskName());
    }
}
