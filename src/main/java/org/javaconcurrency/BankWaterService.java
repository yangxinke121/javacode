package org.javaconcurrency;

import java.util.Map;
import java.util.concurrent.*;

/**
 * @author: yxk
 * @date: 2019-04-29 16:44
 */
public class BankWaterService implements Runnable {

    private CyclicBarrier c = new CyclicBarrier(4, this);

    private static Executor executor = Executors.newFixedThreadPool(4);

    private ConcurrentHashMap<String, Integer> sheet = new ConcurrentHashMap<>();

    private void count() {
        for (int i = 0; i < 4; i++) {
            executor.execute(() -> {
                sheet.put(Thread.currentThread().getName(), 1);
                try {
                    c.await();
                } catch (InterruptedException | BrokenBarrierException e) {
                    e.printStackTrace();
                }
            });
        }
    }

    @Override
    public void run() {
        int result = 0;

        for (Map.Entry<String, Integer> sh : sheet.entrySet()) {
            result += sh.getValue();
        }
        sheet.put("result", result);
        System.out.println(result);
    }

    public static void main(String[] args) {
        BankWaterService bankWaterService = new BankWaterService();
        bankWaterService.count();
    }
}
