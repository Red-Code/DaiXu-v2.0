package team.tab.daixu.util.Jedis;

import redis.clients.jedis.ShardedJedis;

/**
 * Created by CLY on 2017/4/1.
 *
 * 使用统一的类来管理Jedis实例的生成和回收
 */
//public interface JedisDataSource {
//    /**
//     * 获得jedis实例
//     * @return jedis实例
//     */
//    ShardedJedis getRedisClient();
//
//    /**
//     * 回收jedis
//     * @param shardedJedis jedis实例
//     */
//    void returnResource(ShardedJedis shardedJedis);
//
//    void returnResource(ShardedJedis shardedJedis, boolean broken);
//}
