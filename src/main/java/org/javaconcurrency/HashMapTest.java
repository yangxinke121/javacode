package org.javaconcurrency;

import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

/**
 * @author: yxk
 * @date: 2019-04-27 15:51
 */
public class HashMapTest {

    private final Map<String, String> map = new HashMap<>(2);


    public void test() {
        Thread t1 = new Thread(() ->{
            for (int i = 0; i < 1000011; i++) {
                map.put(UUID.randomUUID().toString(), "");
            }
        });

        Thread t2 = new Thread(() ->{
            for (int i = 0; i < 100001; i++) {
                map.put(UUID.randomUUID().toString(), "");
            }
        });

        Thread t3 = new Thread(() ->{
            for (int i = 0; i < 102000; i++) {
                map.put(UUID.randomUUID().toString(), "");
            }
        });

        t1.start();
        t2.start();
        t3.start();
    }

    public static void main(String[] args) {

        Person person = new Person();
        person.setName("xike");

        Person p = person;

        Person p1 = person;

        System.out.println(p.getName());
        System.out.println(p1.getName());

        p.setName("yudian");
        System.out.println(p1.getName());
    }
}


class Person{

    private String name;

    public String getName() {
        return name;
    }


    public void setName(String name) {
        this.name = name;
    }
}