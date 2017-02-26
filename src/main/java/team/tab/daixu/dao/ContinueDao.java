package team.tab.daixu.dao;

import team.tab.daixu.entity.ContinueEntity;

import java.util.List;

/**
 * Created by CLY on 2017/1/3.
 */
public interface ContinueDao {
    /**
     * 将持久化类存到数据库中
     * @param continueEntity 持久化类
     * @return 是否成功
     */
    Boolean save(ContinueEntity continueEntity);
}
