package cn.mateworks.howhy.counters;

/**
 * Created by James Cheung on 2017/7/20.
 */
public class CounterFactroy {
    private static CounterFactroy ourInstance = new CounterFactroy();

    public static CounterFactroy getInstance() {
        return ourInstance;
    }

    private CounterFactroy() {
    }

    public Counter getCounter(int t){
        switch (t){
            case 0:
                return new LockCounter();
            case 1:
                return new AtomicCounter();
            default:
                return new UnsynchronizedCounter();
        }
    }
}
