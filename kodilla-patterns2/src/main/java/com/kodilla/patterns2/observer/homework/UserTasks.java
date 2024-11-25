package com.kodilla.patterns2.observer.homework;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;

public class UserTasks implements HwObservable {

    private final String name;
    private final List<HwObserver> observers;
    private final Deque<String> tasks;

    public UserTasks(final String name) {
        this.name = name;
        observers = new ArrayList<>();
        tasks = new ArrayDeque<>();
    }

    public void addTask(String task) {
        tasks.push(task);
        notifyObservers();
    }

    @Override
    public void registerObserver(HwObserver observer) {
        observers.add(observer);
    }

    @Override
    public void notifyObservers() {
        for (HwObserver observer : observers) {
            observer.update(this);
        }
    }

    @Override
    public void removeObserver(HwObserver observer) {
        observers.remove(observer);
    }

    public String getName() {
        return name;
    }

    public Deque<String> getTasks() {
        return tasks;
    }
}
