package org.javaconcurrency;


import sun.misc.Unsafe;

import java.lang.reflect.Field;

/**
 * @author: yxk
 * @date: 2019-04-28 11:38
 */
public class TestUnsafe {


    private volatile Node head;
    private volatile Node tail;

    public TestUnsafe() {
        head = tail = new Node(null);
    }

    public boolean offer(Integer e) {

        System.out.println(head);
        final Node node = new Node(e);

        for (Node t = tail, p = t;;) {
            Node q = p.next;
            if (q == null) {
                // p is last node
                if (p.casNext(null, node)) {
                    // Successful CAS is the linearization point
                    // for e to become an element of this queue,
                    // and for newNode to become "live".
                    System.out.println(head);
                }
                // Lost CAS race to another thread; re-read next
            }
        }
    }

    public static void main(String[] args) {

        TestUnsafe testUnsafe = new TestUnsafe();

        testUnsafe.offer(1);


    }

    private static class Node{
        volatile Integer item;
        volatile Node next;

        /**
         * Constructs a new node.  Uses relaxed write because item can
         * only be seen after publication via casNext.
         */
        Node(Integer item) {
            UNSAFE.putObject(this, itemOffset, item);
        }

        boolean casNext(Node cmp, Node val) {
            return UNSAFE.compareAndSwapObject(this, nextOffset, cmp, val);
        }

        // Unsafe mechanics

        private static final Unsafe UNSAFE;
        private static final long itemOffset;
        private static final long nextOffset;

        static {
            try {
                UNSAFE = getUnsafe();
                Class<?> k = Node.class;
                itemOffset = UNSAFE.objectFieldOffset
                        (k.getDeclaredField("item"));
                nextOffset = UNSAFE.objectFieldOffset
                        (k.getDeclaredField("next"));
            } catch (Exception e) {
                throw new Error(e);
            }
        }

        /**
         * 获取Unsafe的方法
         * 获取了以后就可以愉快的使用CAS啦
         * @return
         */
        public static Unsafe getUnsafe() {
            try {
                Field f = Unsafe.class.getDeclaredField("theUnsafe");
                f.setAccessible(true);
                return (Unsafe)f.get(null);
            } catch (Exception e) {
                return null;
            }
        }
    }
}
