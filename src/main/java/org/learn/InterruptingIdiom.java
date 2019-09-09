package org.learn;

import java.util.concurrent.TimeUnit;

class NeedCleanUp {
    private final int id;

    public NeedCleanUp(int id) {
        this.id = id;
        System.out.println("NeedsCleanUp " + id);
    }

    public void cleanUp() {
        System.out.println("Cleaning up " + id);
    }
}

class Blocked3 implements Runnable {

    private volatile double d;

    int i = 2;
    @Override
    public void run() {
        try {
            while (i > 0) {
                // point1
                NeedCleanUp n1 = new NeedCleanUp(1);
                try {
                    System.out.println("Sleep");
                    TimeUnit.SECONDS.sleep(1);
                    // point2
                    NeedCleanUp n2 = new NeedCleanUp(2);
                    try {
                        System.out.println("Calculating");
                        for (int i = 0; i < 2500000; i++) {
                            d = d / (Math.PI + Math.E) / d;
                        }
                        System.out.println("Finished time-consuming");
                    } finally {
                        n2.cleanUp();
                    }
                } finally {
                    n1.cleanUp();
                }
                i--;
            }
            // System.out.println("Exiting via while() test");
        } catch (InterruptedException e) {
            System.out.println("Exiting via ex");
        }
    }
}

public class InterruptingIdiom {

    public static void main(String[] args) throws InterruptedException {
        // if (args.length != 1) {
        //     System.out.println("usage: java interrupting delay");
        //     System.exit(1);
        // }
        Thread t = new Thread(new Blocked3());
        t.start();
        // TimeUnit.MILLISECONDS.sleep(new Integer(args[0]));
        // t.interrupt();
    }
}
