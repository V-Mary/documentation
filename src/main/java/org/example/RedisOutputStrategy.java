package org.example;
import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisPooled;


public class RedisOutputStrategy implements DataOutputStrategy {
    private final String redisHost;
    private final int redisPort;

    public RedisOutputStrategy(String redisHost, int redisPort) {
        this.redisHost = redisHost;
        this.redisPort = redisPort;
    }

    @Override
    public void outputData(String data) {
        try {
            Jedis jedis = new Jedis("localhost", 5002);
            jedis.set("lab4", data);
            System.out.println("Дані було успішно записано у Redis.");
        } catch (Exception e){
            System.out.println(e);
        }
    }
}