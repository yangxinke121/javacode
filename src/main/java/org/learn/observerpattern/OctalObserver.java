package org.learn.observerpattern;

/**
 * @author: yxk
 * @date: 2019-04-08 14:09
 */
public class OctalObserver extends Observer {

    public OctalObserver(Subject subject) {
        this.subject = subject;
        this.subject.add(this);
    }

    @Override
    public void update() {
        System.out.println("OctalObserver update "+ Integer.toOctalString(subject.getState()));
    }
}
