package cn.mateworks.howhy.counters;

/**
 * 计数器实现对象
 * Created by James Cheung on 2017/7/20.
 */
public interface Counter {
    /**
     * 计时器加一
     * @return
     */
    long increase();

    /**
     * 获取当前值
     * @return
     */
    long getCurrentValue();

}
