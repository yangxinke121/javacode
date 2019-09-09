package org.javaconcurrency;

import java.util.Deque;
import java.util.LinkedList;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * @author: yxk
 * @date: 2019-04-29 13:58
 */
public class TestDeque {


    private Node first;

    Integer integer1;

    Integer integer2;

    public void test() {
        integer1 = integer2;
        integer2 = 3;
        System.out.println(integer1);
        final Node f = first;
        Node node = new Node(1);
        first = node;
        if (f == null) {
            System.out.println("f is null");
        } else {
            System.out.println("not null");
        }
    }

    public static void main(String[] args) {

        Deque<Integer> deque = new LinkedList<>();
        deque.addFirst(1);
        deque.addFirst(2);
        deque.addLast(3);


        for (Integer integer : deque) {
            System.out.println(integer);
        }

        TestDeque testDeque = new TestDeque();
        testDeque.test();

        AtomicInteger atomicInteger = new AtomicInteger(1);
        System.out.println(atomicInteger.incrementAndGet());

        System.out.println(atomicInteger.getAndIncrement());
        System.out.println(atomicInteger.get());
    }
}

class Node{
    int data;
    Node next;

    Node(int data) {
        this.data = data;
    }
}
