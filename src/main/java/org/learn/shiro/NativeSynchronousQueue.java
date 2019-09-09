package org.learn.shiro;

/**
 * @author: yxk
 * @date: 2019-03-28 17:21
 */
public class NativeSynchronousQueue<E> {

    private boolean putting = false;
    private E element;

    public synchronized E take() throws InterruptedException {
        while (element == null) {
            wait();
        }
        E e = element;
        element = null;
        notifyAll();
        return e;
    }

    public synchronized void put(E e) throws InterruptedException {
        if (e == null) {
            return;
        }
        while (putting) {
            wait();
        }
        element = e;
        putting = true;
        notifyAll();
        while (element != null) {
            wait();
        }
        putting = false;
        notifyAll();
    }
}
