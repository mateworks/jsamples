package cn.mateworks.howhy.counters;

/**
 * Created by James Cheung on 2017/7/20.
 */
public class LockCounter implements Counter {
    static long counter = 0;

    public static synchronized long selfIncrease() {
        return ++counter;
    }

    public static synchronized long getValue() {
        return counter;
    }

    public long increase() {
        return selfIncrease();
    }

    public long getCurrentValue() {
        return getValue();
    }
}
