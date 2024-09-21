package com.kodilla.hibernate.task.dao;

import com.kodilla.hibernate.task.Task;
import com.kodilla.hibernate.task.TaskFinancialDetails;
import com.kodilla.hibernate.tasklist.dao.TaskListDao;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.math.BigDecimal;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;


@SpringBootTest
public class TaskDaoTestSuite {

    @Autowired
    private TaskDao taskDao;

    @Autowired
    private TaskListDao taskListDao;

    private static final String DESCRIPTION = "Test: Learn Hibernate";

    @Test
    void testTaskDaoSave() {
        //given
        Task task = new Task(DESCRIPTION, 7);

        //when
        taskDao.save(task);

        //then
        int id = task.getId();
        Optional<Task> readTask = taskDao.findById(id);
        assertTrue(readTask.isPresent());

        //cleanUp
        taskDao.deleteById(id);
    }

    @Test
    void testTaskDaoFindByDuration() {
        //given
        Task task = new Task(DESCRIPTION, 7);

        //when
        taskDao.save(task);
        List<Task> readTask = taskDao.findByDuration(7);

        //then
        assertEquals(1, readTask.size());

        //cleanUp
        int id = readTask.getFirst().getId();
        taskDao.deleteById(id);
    }

    @Test
    void testTaskDaoSaveWithFinancialDetails() {
        //given
        Task task = new Task(DESCRIPTION, 30);
        task.setTaskFinancialDetails(new TaskFinancialDetails(new BigDecimal(120), false));

        //when
        taskDao.save(task);
        int id = task.getId();

        //then
        assertNotEquals(0, id);

        //cleanUp
//        taskDao.deleteById(id);
    }
}
