package com.kodilla.spring.portfolio;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Scope;

@Configuration
public class BoardConfig {

    @Autowired
    @Qualifier("toDo")
    TaskList taskList1;

    @Autowired
    @Qualifier("inProgress")
    TaskList taskList2;

    @Autowired
    @Qualifier("done")
    TaskList taskList3;

    @Bean
    public Board board() {
        return new Board(taskList1, taskList2, taskList3);
    }

    @Bean(name = "toDo")
    @Scope("prototype")
    public TaskList toDoList() {
        return new TaskList();
    }

    @Bean(name = "inProgress")
    @Scope("prototype")
    public TaskList inProgress() {
        return new TaskList();
    }

    @Bean(name = "done")
    @Scope("prototype")
    public TaskList done() {
        return new TaskList();
    }
}
