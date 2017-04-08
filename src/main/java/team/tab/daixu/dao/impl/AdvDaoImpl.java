package team.tab.daixu.dao.impl;

import org.springframework.stereotype.Repository;
import team.tab.daixu.dao.AdvDao;
import team.tab.daixu.entity.AdvEntity;

import java.util.List;

/**
 * Created by CLY on 2017/1/5.
 */
@Repository
public class AdvDaoImpl extends BaseDaoImpl<AdvEntity> implements AdvDao {
    @Override
    public List<AdvEntity> loadAll() {
        return null;
    }
}
