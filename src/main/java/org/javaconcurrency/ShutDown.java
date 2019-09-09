package org.javaconcurrency;

import java.util.concurrent.TimeUnit;

public class ShutDown {

    public static void main(String[] args) throws InterruptedException {
        Runner one = new Runner();
        Thread thread = new Thread(one, "CountThread");
        thread.start();

        TimeUnit.SECONDS.sleep(1);
        thread.interrupt();

        Runner two = new Runner();
        Thread thread1 = new Thread(two, "CountThread");
        thread1.start();

        TimeUnit.SECONDS.sleep(1);
        two.cancel();
    }

    private static class Runner implements Runnable{

        private long i;
        private static volatile boolean on = true;
        @Override
        public void run() {
            while (on && !Thread.currentThread().isInterrupted()) {
                i++;
            }
            System.out.println("Count i = " + i);
        }

        public void cancel() {
            on = false;
        }
    }
}
