package cn.mateworks.howhy.counters;

import java.util.concurrent.atomic.AtomicLong;

/**
 * Created by James Cheung on 2017/7/20.
 */
public class UnsynchronizedCounter implements Counter {
    static long counter = 0;

    public long increase() {
        return ++counter;
    }

    public long getCurrentValue() {
        return counter;
    }
}
