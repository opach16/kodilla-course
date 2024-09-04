package com.kodilla.spring.portfolio;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Scope;

@Configuration
public class BoardConfig {

    @Autowired
    TaskList taskList1;

    @Autowired
    TaskList taskList2;

    @Autowired
    TaskList taskList3;

    @Bean
    public Board board() {
        return new Board(taskList1, taskList2, taskList3);
    }

    @Bean
    @Scope("prototype")
    public TaskList taskList() {
        return new TaskList();
    }
}
