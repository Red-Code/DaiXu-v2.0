package team.tab.daixu.cached;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;
import redis.clients.jedis.ShardedJedis;

import javax.annotation.Resource;

/**
 * Created by CLY on 2017/4/1.
 */
@Service
public class TestCached {
//    @Resource(name = "jedisDataSourceImpl")
//    private JedisDataSource jedisDataSource;
//
//
//    public void disconnect() {
//        ShardedJedis shardedJedis = jedisDataSource.getRedisClient();
//        shardedJedis.disconnect();
//    }
//
//    /**
//     * 设置单个值
//     *
//     * @param key
//     * @param value
//     * @return
//     */
//    public String set(String key, String value) {
//        String result = null;
//
//        ShardedJedis shardedJedis = jedisDataSource.getRedisClient();
//        if (shardedJedis == null) {
//            return result;
//        }
//        boolean broken = false;
//        try {
//            result = shardedJedis.set(key, value);
//        } catch (Exception e) {
//            broken = true;
//        } finally {
//            jedisDataSource.returnResource(shardedJedis, broken);
//        }
//        return result;
//    }
//
//    /**
//     * 获取单个值
//     *
//     * @param key
//     * @return
//     */
//    public String get(String key) {
//        String result = null;
//        ShardedJedis shardedJedis = jedisDataSource.getRedisClient();
//        if (shardedJedis == null) {
//            return result;
//        }
//
//        boolean broken = false;
//        try {
//            result = shardedJedis.get(key);
//
//        } catch (Exception e) {
//            broken = true;
//        } finally {
//            jedisDataSource.returnResource(shardedJedis, broken);
//        }
//        return result;
//    }
//
//    public Boolean exists(String key) {
//        Boolean result = false;
//        ShardedJedis shardedJedis = redisDataSource.getRedisClient();
//        if (shardedJedis == null) {
//            return result;
//        }
//        boolean broken = false;
//        try {
//            result = shardedJedis.exists(key);
//        } catch (Exception e) {
//            log.error(e.getMessage(), e);
//            broken = true;
//        } finally {
//            redisDataSource.returnResource(shardedJedis, broken);
//        }
//        return result;
//    }
//
//    public String type(String key) {
//        String result = null;
//        ShardedJedis shardedJedis = redisDataSource.getRedisClient();
//        if (shardedJedis == null) {
//            return result;
//        }
//        boolean broken = false;
//        try {
//            result = shardedJedis.type(key);
//
//        } catch (Exception e) {
//            log.error(e.getMessage(), e);
//            broken = true;
//        } finally {
//            redisDataSource.returnResource(shardedJedis, broken);
//        }
//        return result;
//    }
//
//    /**
//     * 在某段时间后失效
//     *
//     * @param key
//     * @param seconds
//     * @return
//     */
//    public Long expire(String key, int seconds) {
//        Long result = null;
//        ShardedJedis shardedJedis = redisDataSource.getRedisClient();
//        if (shardedJedis == null) {
//            return result;
//        }
//        boolean broken = false;
//        try {
//            result = shardedJedis.expire(key, seconds);
//
//        } catch (Exception e) {
//            log.error(e.getMessage(), e);
//            broken = true;
//        } finally {
//            redisDataSource.returnResource(shardedJedis, broken);
//        }
//        return result;
//    }
//
//    /**
//     * 在某个时间点失效
//     *
//     * @param key
//     * @param unixTime
//     * @return
//     */
//    public Long expireAt(String key, long unixTime) {
//        Long result = null;
//        ShardedJedis shardedJedis = redisDataSource.getRedisClient();
//        if (shardedJedis == null) {
//            return result;
//        }
//        boolean broken = false;
//        try {
//            result = shardedJedis.expireAt(key, unixTime);
//
//        } catch (Exception e) {
//            log.error(e.getMessage(), e);
//            broken = true;
//        } finally {
//            redisDataSource.returnResource(shardedJedis, broken);
//        }
//        return result;
//    }
//
//    public Long ttl(String key) {
//        Long result = null;
//        ShardedJedis shardedJedis = redisDataSource.getRedisClient();
//        if (shardedJedis == null) {
//            return result;
//        }
//        boolean broken = false;
//        try {
//            result = shardedJedis.ttl(key);
//
//        } catch (Exception e) {
//            log.error(e.getMessage(), e);
//            broken = true;
//        } finally {
//            redisDataSource.returnResource(shardedJedis, broken);
//        }
//        return result;
//    }
//
//    public boolean setbit(String key, long offset, boolean value) {
//
//        ShardedJedis shardedJedis = redisDataSource.getRedisClient();
//        boolean result = false;
//        if (shardedJedis == null) {
//            return result;
//        }
//        boolean broken = false;
//        try {
//            result = shardedJedis.setbit(key, offset, value);
//        } catch (Exception e) {
//            log.error(e.getMessage(), e);
//            broken = true;
//        } finally {
//            redisDataSource.returnResource(shardedJedis, broken);
//        }
//        return result;
//    }
//
//    public boolean getbit(String key, long offset) {
//        ShardedJedis shardedJedis = redisDataSource.getRedisClient();
//        boolean result = false;
//        if (shardedJedis == null) {
//            return result;
//        }
//        boolean broken = false;
//
//        try {
//            result = shardedJedis.getbit(key, offset);
//        } catch (Exception e) {
//            log.error(e.getMessage(), e);
//            broken = true;
//        } finally {
//            redisDataSource.returnResource(shardedJedis, broken);
//        }
//        return result;
//    }
//
//    public long setRange(String key, long offset, String value) {
//        ShardedJedis shardedJedis = redisDataSource.getRedisClient();
//        long result = 0;
//        if (shardedJedis == null) {
//            return result;
//        }
//        boolean broken = false;
//        try {
//            result = shardedJedis.setrange(key, offset, value);
//        } catch (Exception e) {
//            log.error(e.getMessage(), e);
//            broken = true;
//        } finally {
//            redisDataSource.returnResource(shardedJedis, broken);
//        }
//        return result;
//    }
//
//    public String getRange(String key, long startOffset, long endOffset) {
//        ShardedJedis shardedJedis = redisDataSource.getRedisClient();
//        String result = null;
//        if (shardedJedis == null) {
//            return result;
//        }
//        boolean broken = false;
//        try {
//            result = shardedJedis.getrange(key, startOffset, endOffset);
//
//        } catch (Exception e) {
//            log.error(e.getMessage(), e);
//            broken = true;
//        } finally {
//            redisDataSource.returnResource(shardedJedis, broken);
//        }
//        return result;
//    }
}
