package team.tab.daixu.service;

import team.tab.daixu.entity.ContinueEntity;

/**
 * Created by CLY on 2017/1/3.
 */
public interface ContinueService {
    /**
     * 增
     * @param continueEntity 持久化类
     * @return 是否成功
     */
    Boolean save(ContinueEntity continueEntity);
}
