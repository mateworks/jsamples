package com.mateworks.java_tools.redis;

import redis.clients.jedis.HostAndPort;
import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisCluster;
import redis.clients.jedis.JedisPoolConfig;

import java.io.IOException;
import java.util.HashSet;
import java.util.Set;

/**
 * 基于JAVA操作Redis的简单客户端实现
 * Created by James Cheung on 2017/8/7.
 */
public class SimpleClient {

    public static void main( String[] args ) throws IOException {
        JedisPoolConfig config = new JedisPoolConfig();
        config.setMaxTotal(20);
        config.setMaxIdle(2);

        HostAndPort hp0 = new HostAndPort("192.168.2.199", 7000);
        HostAndPort hp1 = new HostAndPort("192.168.2.199", 7001);
        HostAndPort hp2 = new HostAndPort("192.168.2.199", 7100);
        HostAndPort hp3 = new HostAndPort("192.168.2.199", 7101);
        HostAndPort hp4 = new HostAndPort("192.168.2.201", 7000);
        HostAndPort hp5 = new HostAndPort("192.168.2.201", 7001);
        HostAndPort hp6 = new HostAndPort("192.168.2.201", 7101);
        HostAndPort hp7 = new HostAndPort("192.168.2.201", 7100);

        Set<HostAndPort> hps = new HashSet<HostAndPort>();
        hps.add(hp0);
        hps.add(hp1);
        hps.add(hp2);
        hps.add(hp3);
        hps.add(hp4);
        hps.add(hp5);
        hps.add(hp6);
        hps.add(hp7);
        // 超时，最大的转发数，最大链接数，最小链接数都会影响到集群
        JedisCluster jedisCluster = new JedisCluster(hps, 5000, 10, config);

        long start = System.currentTimeMillis();
        for (int i = 0; i < 100000; i++) {
            jedisCluster.set("sn" + i, "n" + i);
        }
        long end = System.currentTimeMillis();

        System.out.println("Simple  @ Sharding Set : " + (end - start) / 10000);

        for (int i = 0; i < 10; i++) {
            System.out.println(jedisCluster.get("sn" + i*i));
        }

        jedisCluster.close();

    }

}

