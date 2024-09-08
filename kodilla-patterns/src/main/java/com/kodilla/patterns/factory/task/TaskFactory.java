package com.kodilla.patterns.factory.task;

public class TaskFactory {

    public Task createTask(String taskName) {
        return switch (taskName) {
            case "DrivingTask" -> new DrivingTask("DrivingTask", "McDonald's", "Uber");
            case "PaintingTask" -> new PaintingTask("PaintingTask", "red", "bike");
            case "ShoppingTask" -> new ShoppingTask("ShoppingTask", "milk", 3);
            default -> null;
        };
    }
}
