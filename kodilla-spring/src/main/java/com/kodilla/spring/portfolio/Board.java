package com.kodilla.spring.portfolio;

public final class Board {

    private final TaskList todoList;
    private final TaskList inProgressList;
    private final TaskList doneList;

    public Board(final TaskList todoList, final TaskList inProgressList, final TaskList doneList) {
        this.todoList = todoList;
        this.inProgressList = inProgressList;
        this.doneList = doneList;
    }

    public TaskList getTodoList() {
        return todoList;
    }

    public TaskList getInProgressList() {
        return inProgressList;
    }

    public TaskList getDoneList() {
        return doneList;
    }
}
