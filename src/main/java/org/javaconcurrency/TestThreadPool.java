package org.javaconcurrency;

import java.util.concurrent.*;

/**
 * @author: yxk
 * @date: 2019-04-29 18:25
 */
public class TestThreadPool {

    // private static ExecutorService es = new ThreadPoolExecutor(50, 100, 0L, TimeUnit.MILLISECONDS,
    //         new SynchronousQueue<>());

    private static ExecutorService es = new ThreadPoolExecutor(10, 100,
            60L, TimeUnit.SECONDS,
            new ArrayBlockingQueue<>(100));

    public static void main(String[] args) throws Exception {
        // for (int i = 0; i < 1000; i++) {
        //     es.execute(() -> {
        //         System.out.print(1);
        //         try {
        //             Thread.sleep(1000);
        //         } catch (InterruptedException e) {
        //             e.printStackTrace();
        //         }
        //     });
        // }
        //
        // ThreadPoolExecutor tpe = ((ThreadPoolExecutor) es);
        //
        // while (true) {
        //     System.out.println();
        //
        //     int queueSize = tpe.getQueue().size();
        //     System.out.println("当前排队线程数：" + queueSize);
        //
        //     int activeCount = tpe.getActiveCount();
        //     System.out.println("当前活动线程数：" + activeCount);
        //
        //     long completedTaskCount = tpe.getCompletedTaskCount();
        //     System.out.println("执行完成线程数：" + completedTaskCount);
        //
        //     long taskCount = tpe.getTaskCount();
        //     System.out.println("总线程数：" + taskCount);
        //
        //     int largestPoolSize = tpe.getLargestPoolSize();
        //     System.out.println("最大线程数：" + largestPoolSize);
        //
        //     int poolSize = tpe.getPoolSize();
        //     System.out.println("线程池线程数量 " + poolSize);
        //
        //     Thread.sleep(3000);
        // }

            ExecutorService cachedThreadPool = Executors.newCachedThreadPool();
            for (int i = 0; i < 10; i++) {
                final int index = i;
                try {
                    Thread.sleep(index * 100);
                } catch (Exception e) {
                    e.printStackTrace();
                }

                cachedThreadPool.execute(new Runnable() {

                    @Override
                    public void run() {
                        System.out.println(index+"当前线程"+Thread.currentThread().getName());
                    }
                });
            }
            cachedThreadPool.shutdown();

        ConcurrentHashMap<String, String> con = new ConcurrentHashMap<>();
        String s = con.putIfAbsent("1", "2");
        String s1 = con.putIfAbsent("1", "2");
        System.out.println(s);
    }
}
