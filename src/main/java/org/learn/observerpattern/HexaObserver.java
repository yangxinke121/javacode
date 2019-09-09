package org.learn.observerpattern;

/**
 * @author: yxk
 * @date: 2019-04-08 14:10
 */
public class HexaObserver extends Observer {

    public HexaObserver(Subject subject) {
        this.subject = subject;
        this.subject.add(this);
    }

    @Override
    public void update() {
        System.out.println("HexaObserver update "+ Integer.toHexString(subject.getState()).toUpperCase());
    }
}
