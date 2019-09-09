package org.javaconcurrency;

import java.util.concurrent.Exchanger;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * @author: yxk
 * @date: 2019-04-29 17:09
 */
public class ExchangerTest {

    private static final Exchanger<String> ex = new Exchanger<>();
    private static ExecutorService executor = Executors.newFixedThreadPool(2);

    public static void main(String[] args) {
        executor.execute(() -> {
            String A = "bank a";
            try {
                String B = ex.exchange(A);
                System.out.println("b eq " + B);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        });

        executor.execute(() -> {
            String B = "bank b";
            try {
                String A = ex.exchange(B);
                System.out.println("A and b is eq "+ A.equals(B) +
                        " A is " + A + ", b is " + B);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        });



    }
}
