package org.learn;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.FutureTask;

/**
 * @author yxk
 *
 */
public class Preloader {

    private final FutureTask<ProductInfo> futureTask =
            new FutureTask<>(ProductInfo::new);

    private final Thread thread = new Thread(futureTask);

    public void start() {
        thread.start();
    }

    public ProductInfo get() throws InterruptedException {
        try {
            return futureTask.get();
        } catch (ExecutionException e) {
            Throwable cause = e.getCause();
            if (cause instanceof OSExecuteException) {
                throw (OSExecuteException) cause;
            } else {
                return null;
            }
        }
    }

}


class ProductInfo {
}