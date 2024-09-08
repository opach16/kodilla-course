package com.kodilla.patterns.factory.task;

public class ShoppingTask implements Task {

    private final String taskName;
    private final String whatToBuy;
    private final double quantity;
    private boolean executed;

    public ShoppingTask(final String taskName, final String whatToBuy, final double quantity) {
        this.taskName = taskName;
        this.whatToBuy = whatToBuy;
        this.quantity = quantity;
    }

    @Override
    public void executeTask() {
        System.out.println("Executing task: " + taskName);
        System.out.println("Buying " + quantity + " of " + whatToBuy);
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
