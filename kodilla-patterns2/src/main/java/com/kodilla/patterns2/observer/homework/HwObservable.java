package com.kodilla.patterns2.observer.homework;

public interface HwObservable {

    void registerObserver(HwObserver observer);
    void notifyObservers();
    void removeObserver(HwObserver observer);
}
