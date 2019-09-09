package org.java8;

public class CircularQueue {

    private int[] items;

    private int len;

    private int head;

    private int tail;

    public CircularQueue(int len) {
        items = new int[len];
        this.len = len;
    }

    public boolean enQueue(int item) {
        if ((tail + 1) % len == head) {
            return false;
        }
        items[tail] = item;
        tail = (tail + 1) % len;
        return true;
    }

    public Integer deQueue() {
        if (head == tail) {
            return null;
        }
        int temp = items[head];
        head = (head + 1) % len;
        return temp;
    }
}
