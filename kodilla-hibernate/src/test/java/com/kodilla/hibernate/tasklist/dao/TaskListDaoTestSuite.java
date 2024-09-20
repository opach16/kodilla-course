package com.kodilla.hibernate.tasklist.dao;

import com.kodilla.hibernate.tasklist.TaskList;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

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
}
