package com.example.observer;

import java.util.ArrayList;
import java.util.List;

public abstract class Observable {
    private List<Observer> observers = new ArrayList<>();

    public void addObserver(Observer o) {
        if (!observers.contains(o)) observers.add(o);
    }

    public void removeObserver(Observer o) {
        observers.remove(o);
    }

    public void notifyObservers() {
        for (Observer o : observers) {
            o.update(this);
        }
    }
}
