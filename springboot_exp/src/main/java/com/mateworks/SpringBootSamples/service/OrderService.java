package com.mateworks.SpringBootSamples.service;

/**
 * Created by James Cheung on 2017/6/30.
 */
public interface OrderService {
    /**
     *
     * @param goodId
     * @return
     */
    int getGoodStock(int goodId);

    /**
     *
     * @param goodId
     * @param num
     * @return
     */
    boolean lockGoodStock(int goodId,int num);

    /**
     * 创建订单
     * @param goodId
     * @param num
     * @param uid
     * @return
     */
    boolean createOrder(int goodId,int num,int uid);
}
