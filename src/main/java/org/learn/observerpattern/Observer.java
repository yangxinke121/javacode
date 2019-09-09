package org.learn.observerpattern;

/**
 * @author: yxk
 * @date: 2019-04-08 14:00
 */
public abstract class Observer {

    Subject subject;

    public abstract void update();
}
