package org.learn.observerpattern;

/**
 * @author: yxk
 * @date: 2019-04-08 14:12
 */
public class ObserverPatternDemo {

    public static void main(String[] args) {
        Subject subject = new Subject();
        new BinaryObserver(subject);
        new OctalObserver(subject);
        new HexaObserver(subject);

        subject.setState(23);

        subject.setState(15);

    }
}
