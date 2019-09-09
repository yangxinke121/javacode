package org.javaconcurrency;

import java.util.concurrent.Delayed;
import java.util.concurrent.FutureTask;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicLong;

/**
 * @author: yxk
 * @date: 2019-04-29 11:24
 */
public class TestDelayQueue<V> extends FutureTask<V> implements Delayed {

    private static final AtomicLong sequencer = new AtomicLong(0);

    private final long sequenceNumber;

    private long time;

    private long preiod;

    public TestDelayQueue(Runnable r, V result, long ns, long preiod) {
        super(r, result);
        this.time = ns;
        this.preiod = preiod;
        sequenceNumber = sequencer.getAndIncrement();
    }

    @Override
    public long getDelay(TimeUnit unit) {
        return unit.convert(time - now(), TimeUnit.NANOSECONDS);
    }

    @Override
    public int compareTo(Delayed other) {
        if (this == other) {
            return 0;
        }
        if (other instanceof TestDelayQueue) {
            @SuppressWarnings("unchecked")
            TestDelayQueue<V> x = (TestDelayQueue<V>) other;
            long diff = time - x.time;
            if (diff < 0) {
                return -1;
            } else if (diff > 0) {
                return 1;
            } else if (sequenceNumber < x.sequenceNumber) {
                return -1;
            } else {
                return 1;
            }
        }
        long d = getDelay(TimeUnit.NANOSECONDS) - other.getDelay(TimeUnit.NANOSECONDS);
        return d == 0 ? 0 : d < 0 ? -1 : 1;
    }

    private long now() {
        return System.nanoTime();
    }
}
