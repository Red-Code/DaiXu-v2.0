package team.tab.daixu.dao;

import team.tab.daixu.entity.AdvEntity;

import java.util.List;

/**
 * Created by CLY on 2017/1/3.
 */
public interface AdvDao extends BaseDao<AdvEntity> {
    List<AdvEntity> loadAll();
}
