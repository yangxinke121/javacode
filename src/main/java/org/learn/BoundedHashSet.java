package org.learn;
import java.util.Collections;
import java.util.HashSet;
import java.util.Set;
import java.util.concurrent.Semaphore;

public class BoundedHashSet<T> {

    private final Set<T> set;
    private final Semaphore sem;

    public BoundedHashSet(int bound) {
        this.set = Collections.synchronizedSet(new HashSet<>());
        this.sem = new Semaphore(bound);
    }

    public boolean add(T o) throws InterruptedException {
        sem.acquire();
        boolean wasAdded = false;
        try {
            wasAdded = set.add(o);
            return wasAdded;
        } finally {
            if (!wasAdded) {
                sem.release();
            }
        }
    }

    public boolean remove(Object o) {
        boolean wasRemove = set.remove(o);
        if (wasRemove) {
            sem.release();
        }
        return wasRemove;
    }


    public static void main(String[] args) throws InterruptedException {
        BoundedHashSet<String> hashSet = new BoundedHashSet<>(2);
        hashSet.add("1");
        hashSet.add("2");
        hashSet.add("3");
        //
        // Thread.sleep(1000);
        hashSet.remove("2");
    }
}
