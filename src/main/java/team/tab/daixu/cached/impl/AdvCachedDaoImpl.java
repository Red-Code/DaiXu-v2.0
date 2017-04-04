package team.tab.daixu.cached.impl;

import org.springframework.stereotype.Repository;
import team.tab.daixu.cached.AdvCachedDao;
import team.tab.daixu.cons.CachedKeyName;

/**
 * Created by CLY on 2017/4/4.
 */
@Repository
public class AdvCachedDaoImpl extends BaseCachedDaoImpl implements AdvCachedDao{
    @Override
    public String get_key_name() {
        final String adv_key_name = CachedKeyName.ADV_LIST;

        return adv_key_name;
    }
}
