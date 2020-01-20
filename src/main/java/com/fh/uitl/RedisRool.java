package com.fh.uitl;

import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisPool;
import redis.clients.jedis.JedisPoolConfig;

public class RedisRool {
    private static JedisPool jedisPool;

    private RedisRool(){

    }
    //静态代码块只能执行一次

    static {
        //设置连接池信息
        JedisPoolConfig poolConfig=new JedisPoolConfig();
        //最大连接数
        poolConfig.setMaxTotal(100);
        //最大空闲连接数
        poolConfig.setMaxIdle(10);
        //最小连接数
        poolConfig.setMinIdle(5);
        jedisPool =new JedisPool("192.168.127.134",6379);
    }

    public static Jedis getJedis(){
        //从连接池李取出来一个
        Jedis jedis=jedisPool.getResource();
        return jedis;
    }

    public static void returnjedis(Jedis jedis){
            if(jedis!=null){
                jedis.close();
            }
    }
}
