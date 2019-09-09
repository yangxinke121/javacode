package org.javaconcurrency;

public class TestReTry {

    public static void main(String[] args) {

        int a = 1;
        retry:
        for (;;) {
            System.out.println(1);
            for (;;) {
                if (a == 1) {
                    break retry;
                }
                // else CAS failed due to workerCount change; retry inner loop
            }
        }
    }
}
