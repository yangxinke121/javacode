package org.learn;

/**
 * @author: yxk
 * @date: 2019-04-18 14:08
 */
public class SingletonPattern {

    private static class SingletonHold {
        private final static SingletonPattern SINGLETON_PATTERN = new SingletonPattern();
    }

    private SingletonPattern() {
    }

    public static SingletonPattern getInstance() {
        return SingletonHold.SINGLETON_PATTERN;
    }
}
