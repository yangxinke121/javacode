package org.javaconcurrency;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @author: yxk
 * @date: 2019-04-26 17:45
 */
public class TestMutex {

    private static final ReentrantLock lock = new ReentrantLock();

    public static void main(String[] args) {
        lock.unlock();

    }
}
