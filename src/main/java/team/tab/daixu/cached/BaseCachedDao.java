package team.tab.daixu.cached;

/**
 * Created by CLY on 2017/4/4.
 *
 * 所有缓存层接口的父接口
 */
public interface BaseCachedDao {
    /**
     * 设置一个不限时的key-value
     * @param key 键值名
     * @param value 键值对
     * @return 状态码
     */
    String set(String key, String value);

    /**
     * 根据key获取一个value
     * @param key 键值
     * @return value
     */
    String get(String key);

    /**
     * 根据key，删除一个键值对
     * @param key 键值
     * @return 如果没有被删除，则返回0，如果都n个key被删除则返回n
     */
    long del(String key);

    /**
     * 在某段时间后失效
     * @param key 键值名
     * @param seconds 秒数
     * @return 1表示时间设置成功，0表示没有设置成功（可能是key不存在）
     */
    long expire(String key, int seconds);

    /**
     * 在某个时间点失效
     * @param key
     * @param unixTime
     * @return 1表示时间设置成功，0表示没有设置成功（可能是key不存在）
     */
    long expireAt(String key, long unixTime);

    /**
     * 该键值是否存在
     * @param key 键值
     * @return true表示存在，false表示不存在
     */
    boolean exists(String key);
}
