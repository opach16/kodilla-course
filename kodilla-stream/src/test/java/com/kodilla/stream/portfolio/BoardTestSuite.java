package com.kodilla.stream.portfolio;

import org.junit.jupiter.api.Test;

import java.time.LocalDate;
import java.util.List;

import static java.util.stream.Collectors.*;
import static org.junit.jupiter.api.Assertions.*;

class BoardTestSuite {

    @Test
    void testAddTaskList() {
        //Given
        Board project = prepareTestData();
        //When

        //Then
        assertEquals(3, project.getTaskLists().size());
    }

    @Test
    void testAddTaskListFindUsersTasks() {
        //given
        Board project = prepareTestData();
        User user = new User("developer1", "John Smith");

        //when
        List<Task> userTasks = project.getTaskLists().stream()
                .flatMap(list -> list.getTasks().stream())
                .filter(task -> task.getAsignedUser().equals(user))
                .collect(toList());

        //then
        assertEquals(2, userTasks.size());
        assertEquals(user, userTasks.get(0).getAsignedUser());
        assertEquals(user, userTasks.get(1).getAsignedUser());
    }

    @Test
    void testAddTaskListFindOutdatedTasks() {
        //given
        Board project = prepareTestData();

        //when
        List<Task> undoneTasks = project.getTaskLists().stream()
                .filter(list -> list.getName().equals("To do") || list.getName().equals("In progress"))
                .flatMap(list -> list.getTasks().stream())
                .filter(task -> task.getDeadline().isBefore(LocalDate.now()))
                .collect(toList());

        //then
        assertEquals(1, undoneTasks.size());
        assertEquals("HQLs for analysis", undoneTasks.get(0).getTitle());
    }

    @Test
    void testAddTaskListFindLongTasks() {
        //given
        Board project = prepareTestData();

        //when
        long inProgressTasks = project.getTaskLists().stream()
                .filter(list -> list.getName().equals("In progress"))
                .flatMap(list -> list.getTasks().stream())
                .map(Task::getCreated)
                .filter(task -> task.compareTo(LocalDate.now().minusDays(10)) >= 0)
                .count();

        //then
        assertEquals(2, inProgressTasks);
    }

    @Test
    void testAddTaskListAverageWorkingOnTask() {
        //given
        Board project = prepareTestData();

        //when
        long averageNumberOfDays = (long) project.getTaskLists().stream()
                .filter(list -> list.getName().equals("In progress"))
                .flatMap(list -> list.getTasks().stream())
                .map(task -> task.getCreated())
                .mapToLong(date -> LocalDate.now().toEpochDay() - date.toEpochDay())
                .average().getAsDouble();

        //then
        assertEquals(10, averageNumberOfDays, 0);
    }

    private Board prepareTestData() {
        //users
        User user1 = new User("developer1", "John Smith");
        User user2 = new User("projectmanager1", "Nina White");
        User user3 = new User("developer2", "Emilia Stephanson");
        User user4 = new User("developer3", "Konrad Bridge");

        //tasks
        Task task1 = new Task("Microservice for taking temperature",
                "Write and test the microservice taking\n" +
                        "the temperaure from external service",
                user1,
                user2,
                LocalDate.now().minusDays(20),
                LocalDate.now().plusDays(30));
        Task task2 = new Task("HQLs for analysis",
                "Prepare some HQL queries for analysis",
                user1,
                user2,
                LocalDate.now().minusDays(20),
                LocalDate.now().minusDays(5));
        Task task3 = new Task("Temperatures entity",
                "Prepare entity for temperatures",
                user3,
                user2,
                LocalDate.now().minusDays(20),
                LocalDate.now().plusDays(15));
        Task task4 = new Task("Own logger",
                "Refactor company logger to meet our needs",
                user3,
                user2,
                LocalDate.now().minusDays(10),
                LocalDate.now().plusDays(25));
        Task task5 = new Task("Optimize searching",
                "Archive data searching has to be optimized",
                user4,
                user2,
                LocalDate.now(),
                LocalDate.now().plusDays(5));
        Task task6 = new Task("Use Streams",
                "use Streams rather than for-loops in predictions",
                user4,
                user2,
                LocalDate.now().minusDays(15),
                LocalDate.now().minusDays(2));

        //taskLists
        TaskList taskListToDo = new TaskList("To do");
        taskListToDo.addTask(task1);
        taskListToDo.addTask(task3);
        TaskList taskListInProgress = new TaskList("In progress");
        taskListInProgress.addTask(task5);
        taskListInProgress.addTask(task4);
        taskListInProgress.addTask(task2);
        TaskList taskListDone = new TaskList("Done");
        taskListDone.addTask(task6);

        //board
        Board project = new Board("Project Weather Prediction");
        project.addTaskList(taskListToDo);
        project.addTaskList(taskListInProgress);
        project.addTaskList(taskListDone);
        return project;
    }
}