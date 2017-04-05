package team.tab.daixu.cached.impl;

import org.springframework.beans.factory.annotation.Autowired;
import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisPool;
import team.tab.daixu.cached.BaseCachedDao;

/**
 * Created by CLY on 2017/4/4.
 */
public abstract class BaseCachedDaoImpl implements BaseCachedDao{
    @Autowired
    protected JedisPool jedisPool;//注入JedisPool

    //获取jedis实例，如果没有获取到，则关闭jedis并返回null
    protected Jedis getRedisClient() {
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
    public long del(String key) {
        long result = 0;
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
    public long expire(String key, int seconds) {
        long result = 0;
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
    public long expireAt(String key, long unixTime) {
        long result = 0;
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
    public boolean exists(String key) {
        boolean result = false;
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
