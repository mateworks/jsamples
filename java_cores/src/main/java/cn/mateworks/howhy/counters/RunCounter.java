package cn.mateworks.howhy.counters;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by James Cheung on 2017/7/20.
 */
public class RunCounter {

    /**
     * 测试计数器实现方式的入口方法
     * @param args
     */
    public static void main(String[] args) throws InterruptedException {

        final int count = 100000;
        long start = System.currentTimeMillis();
        List<Thread> threads = new ArrayList<Thread>();
        for (int i=0;i<100; i++  ) {
            Thread thr = new Thread(new Runnable() {
                public void run() {
                    Counter counter = CounterFactroy.getInstance().getCounter(0);
                    for (int i = 0; i < count; i++) {
                        counter.increase();
                    }
                }
            });
            thr.start();
            threads.add(thr);
        }
        for (Thread t :  threads) {
            t.join();
        }
        System.out.print(System.currentTimeMillis()-start);
        System.out.print(" ");
        System.out.println(CounterFactroy.getInstance().getCounter(0).getCurrentValue());

    }

}
