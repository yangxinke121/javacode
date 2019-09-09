package org.javaconcurrency;

import java.util.concurrent.atomic.AtomicReference;

/**
 * @author: yxk
 * @date: 2019-04-29 16:04
 */
public class AtomicReferenceTest {

    public static AtomicReference<User> atomicReference = new AtomicReference<>();

    public static void main(String[] args) {
        User user = new User("xinke", 24);
        atomicReference.set(user);
        atomicReference.compareAndSet(user, new User("yudian", 22));
        System.out.println(atomicReference.get().getName());
        System.out.println(atomicReference.get().getOld());

        System.out.println(user.getName());
    }

    static class User{
        private String name;
        private int old;

        public User(String name, int old) {
            this.name = name;
            this.old = old;
        }

        public String getName() {
            return name;
        }

        public int getOld() {
            return old;
        }
    }
}
