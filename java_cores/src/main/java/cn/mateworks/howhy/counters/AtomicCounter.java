package cn.mateworks.howhy.counters;

import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicLong;

/**
 * Created by James Cheung on 2017/7/20.
 */
public class AtomicCounter implements Counter{

    static AtomicLong counter = new AtomicLong();

    public long increase() {
        return counter.addAndGet(1);
    }

    public long getCurrentValue() {
        return counter.intValue();
    }
}
