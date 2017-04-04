package team.tab.daixu.cached;

import team.tab.daixu.entity.AdvEntity;

import java.util.List;

/**
 * Created by CLY on 2017/1/3.
 */
public interface AdvCachedDao extends BaseCachedDao{
    /**
     * 获得adv列表的value的键值名
     * @return
     */
    String get_key_name();
}
