package com.kodilla.patterns.factory.task;

public class PaintingTask implements Task {

    private final String taskName;
    private final String color;
    private final String whatToPaint;
    private boolean executed = false;

    public PaintingTask(final String taskName, final String color, final String whatToPaint) {
        this.taskName = taskName;
        this.color = color;
        this.whatToPaint = whatToPaint;
    }

    @Override
    public void executeTask() {
        System.out.println("Executing task: " + taskName);
        System.out.println("Painting " + whatToPaint + " using " + color + " color");
        executed = true;
    }

    @Override
    public String getTaskName() {
        return taskName;
    }

    @Override
    public boolean isTaskExecuted() {
        return executed;
    }
}
