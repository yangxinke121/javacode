package org.learn.observerpattern;

import java.util.ArrayList;
import java.util.List;

/**
 * @author: yxk
 * @date: 2019-04-08 14:01
 */
public class Subject {

    private List<Observer> list = new ArrayList<>();

    private int state;

    int getState() {
        return state;
    }

    public void setState(int state) {
        this.state = state;
        notifyAllObservers();
    }

    public void add(Observer observer) {
        list.add(observer);
    }

    private void notifyAllObservers() {
        for (Observer observer : list) {
            observer.update();
        }
    }
}
