package team.tab.daixu.util.Jedis.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import redis.clients.jedis.ShardedJedis;
import redis.clients.jedis.ShardedJedisPool;

/**
 * Created by CLY on 2017/4/1.
 */
//@Repository
//public class JedisDataSourceImpl implements JedisDataSource {
//    @Autowired
//    private ShardedJedisPool shardedJedisPool;
//
//    @Override
//    public ShardedJedis getRedisClient() {
//        ShardedJedis shardJedis = null;
//        try {
//            shardJedis = shardedJedisPool.getResource();
//            return shardJedis;
//        } catch (Exception e) {
//            if (null != shardJedis)
//                shardJedis.close();
//        }
//        return null;
//    }
//
//    @Override
//    public void returnResource(ShardedJedis shardedJedis) {
//        shardedJedis.close();
//    }
//
//    @Override
//    public void returnResource(ShardedJedis shardedJedis, boolean broken) {
//        shardedJedis.close();
//    }
//
//}