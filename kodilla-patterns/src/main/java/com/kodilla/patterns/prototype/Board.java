package com.kodilla.patterns.prototype;

import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

public class Board extends Prototype<Board> {

    private String name;
    private Set<TasksList> lists = new HashSet<>();

    public Board(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Set<TasksList> getLists() {
        return lists;
    }

    @Override
    public String toString() {
        String s = "Board [" + name + "]\n";
        for (TasksList list : lists) {
            s = s + list.toString() + "\n";
        }
        return s;
    }

    public Board shallowCopy() throws CloneNotSupportedException {
        return super.clone();
    }

    public Board deepCopy() throws CloneNotSupportedException {
        Board cloneBoard = (Board) super.clone();
        cloneBoard.lists = new HashSet<>();
        for (TasksList theList : lists) {
            TasksList clonedList = new TasksList(theList.getName());
            for (Task task : theList.getTasks()) {
                clonedList.getTasks().add(task);
            }
            cloneBoard.getLists().add(clonedList);
        }
        return cloneBoard;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Board board = (Board) o;
        return Objects.equals(name, board.name) && lists.equals(board.lists);
    }

    @Override
    public int hashCode() {
        int result = Objects.hashCode(name);
        result = 31 * result + lists.hashCode();
        return result;
    }
}
