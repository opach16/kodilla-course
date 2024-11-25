package com.kodilla.patterns2.observer.homework;

public class Mentor implements HwObserver {

    private final String name;
    private int updateCount;

    public Mentor(final String name) {
        this.name = name;
    }

    @Override
    public void update(UserTasks userTasks) {
        String numberOfTasks = userTasks.getTasks().size() == 1 ? "task" : "tasks";
        System.out.println("Mentor: " + name + " - " + userTasks.getName() + ": " + userTasks.getTasks().size() + " " + numberOfTasks);
        updateCount++;
    }

    public String getName() {
        return name;
    }

    public int getUpdateCount() {
        return updateCount;
    }
}
