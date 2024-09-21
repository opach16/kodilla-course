package com.kodilla.hibernate.tasklist.dao;

import com.kodilla.hibernate.task.Task;
import com.kodilla.hibernate.task.TaskFinancialDetails;
import com.kodilla.hibernate.tasklist.TaskList;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.math.BigDecimal;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
public class TaskListDaoTestSuite {

    @Autowired
    TaskListDao taskListDao;

    @Test
    void testFindByListName() {
        //given
        TaskList taskList = new TaskList("ListName", "ListDescription");

        //when
        taskListDao.save(taskList);
        List<TaskList> readTaskList = taskListDao.findByListName("ListName");

        //then
        assertEquals(1, readTaskList.size());

        //cleanUp
        taskListDao.delete(readTaskList.getFirst());
    }

    @Test
    void testTaskListDaoSaveWithTasks() {
        //given
        Task task1 = new Task("Test: Learn Hibernate", 14);
        Task task2 = new Task("Test: Write some entities", 30);
        TaskFinancialDetails taskFinancialDetails1 = new TaskFinancialDetails(new BigDecimal(150), false);
        TaskFinancialDetails taskFinancialDetails2 = new TaskFinancialDetails(new BigDecimal(120), false);
        task1.setTaskFinancialDetails(taskFinancialDetails1);
        task2.setTaskFinancialDetails(taskFinancialDetails2);
        TaskList taskList = new TaskList("ListName", "ToDo task");
        taskList.getTasks().add(task1);
        taskList.getTasks().add(task2);
        task1.setTaskList(taskList);
        task2.setTaskList(taskList);

        //when
        taskListDao.save(taskList);
        int id = taskList.getId();

        //then
        assertNotEquals(0, id);

        //cleanUp
        taskListDao.deleteById(id);
    }
}
