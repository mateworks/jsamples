package com.mateworks.SpringBootSamples.service.impl;

import com.mateworks.SpringBootSamples.service.OrderService;
import org.springframework.stereotype.Service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.actuate.metrics.CounterService;


/**
 * Created by James Cheung on 2017/6/30.
 */
@Service
public class DefaultOrderServiceImpl implements OrderService {
    private final CounterService counterService;

    @Autowired
    public DefaultOrderServiceImpl(CounterService service){
        this.counterService=service;
    }

    @Override
    public int getGoodStock(int goodId) {
        counterService.increment("com.mateworks.SpringBootSamples.service.DefaultOrderServiceImpl.getGoodStock");
        return 0;
    }

    @Override
    public boolean lockGoodStock(int goodId, int num) {
        counterService.increment("com.mateworks.SpringBootSamples.service.DefaultOrderServiceImpl.lockGoodStock");
        return false;
    }

    @Override
    public boolean createOrder(int goodId, int num, int uid) {
        counterService.increment("com.mateworks.SpringBootSamples.service.DefaultOrderServiceImpl.createOrder");
        return false;
    }
}
