package org.learn.observerpattern;

/**
 * @author: yxk
 * @date: 2019-04-08 14:06
 */
public class BinaryObserver extends Observer {

    public BinaryObserver(Subject subject) {
        this.subject = subject;
        this.subject.add(this);
    }

    @Override
    public void update() {
        System.out.println("BinaryObserver update " + Integer.toBinaryString(subject.getState()));
    }
}
