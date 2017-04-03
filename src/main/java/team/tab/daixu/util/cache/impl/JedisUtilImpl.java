package team.tab.daixu.util.cache.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisPool;
import team.tab.daixu.util.cache.JedisUtil;

/**
 * Created by CLY on 2017/4/1.
 */
@Component
class JedisUtilImpl implements JedisUtil{
    @Autowired
    private JedisPool jedisPool;//注入JedisPool

    //获取jedis实例，如果没有获取到，则关闭jedis并返回null
    private Jedis getRedisClient() {
        Jedis jedis = null;
        try {
            jedis = jedisPool.getResource();
            return jedis;
        } catch (Exception e) {
            if (null != jedis)
                jedis.close();
        }
        return null;
    }

    @Override
    public String set(String key, String value) {
        String result = null;
        Jedis jedis = getRedisClient();

        if (jedis == null) {
            return result;
        }
        try {
            result = jedis.set(key, value);
        } catch (Exception e) {
        } finally {
            jedis.close();
        }
        return result;
    }

    public String get(String key) {
        String result = null;
        Jedis jedis = getRedisClient();

        if (jedis == null) {
            return result;
        }
        try {
            result = jedis.get(key);

        } catch (Exception e) {

        } finally {
            jedis.close();
        }
        return result;
    }

    @Override
    public Long del(String key) {
        Long result = null;
        Jedis jedis = getRedisClient();

        if (jedis == null) {
            return result;
        }
        try {
            result = jedis.del(key);

        } catch (Exception e) {

        } finally {
            jedis.close();
        }
        return result;
    }

    @Override
    public Long expire(String key, int seconds) {
        Long result = null;
        Jedis jedis = getRedisClient();

        if (jedis == null) {
            return result;
        }
        try {
            result = jedis.expire(key, seconds);

        } catch (Exception e) {
        } finally {
            jedis.close();
        }
        return result;
    }

    @Override
    public Long expireAt(String key, long unixTime) {
        Long result = null;
        Jedis jedis = getRedisClient();
        if (jedis == null) {
            return result;
        }
        try {
            result = jedis.expireAt(key, unixTime);

        } catch (Exception e) {

        } finally {
            jedis.close();
        }
        return result;
    }

    @Override
    public Boolean exists(String key) {
        Boolean result = false;
        Jedis jedis = getRedisClient();

        if (jedis == null) {
            return result;
        }
        try {
            result = jedis.exists(key);
        } catch (Exception e) {
        } finally {
            jedis.close();
        }
        return result;
    }
}