package org.learn;

import java.util.*;
import java.util.concurrent.CopyOnWriteArrayList;

public class HiddenIterator {

    // private final Set<Integer> set = Sets.newHashSet();
    //
    //
    // public synchronized void add(Integer i) {
    //     set.add(i);
    //
    // }
    //
    // public synchronized void remove(Integer i) {
    //     set.remove(i);
    // }
    //
    // public void addTenThings() {
    //     Random random = new Random(47);
    //     for (int i = 0; i < 10; i++) {
    //         add(random.nextInt(10));
    //     }
    //     System.out.println("debug :add ten" + set);
    // }
    //
    // public static void main(String[] args) {
    //     CopyOnWriteArrayList copyOnWriteArrayList = new CopyOnWriteArrayList();
    //
    //     HiddenIterator h = new HiddenIterator();
    //     new Thread(() -> {
    //         for(int i = 0; i < 5; i++) {
    //             h.remove(i);
    //         }
    //     }).start();
    //     h.addTenThings();
    // }

    static CopyOnWriteArrayList<Integer> list = new CopyOnWriteArrayList<>();
    public static void main(String[] args)  {
        list.add(1);
        list.add(2);
        list.add(3);
        list.add(4);
        list.add(5);
        Thread thread1 = new Thread(() -> {
            for (Integer integer : list) {
                System.out.println(integer);
                try {
                    Thread.sleep(100);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        });
        Thread thread2 = new Thread(){
            public void run() {
                Iterator<Integer> iterator = list.iterator();
                while(iterator.hasNext()){
                    Integer integer = iterator.next();
                    if(integer==2)
                        list.remove(integer);

                    System.out.println(list);
                }
            };
        };
        thread1.start();
        thread2.start();
    }
}
