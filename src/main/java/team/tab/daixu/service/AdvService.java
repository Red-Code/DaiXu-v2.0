package team.tab.daixu.service;

import team.tab.daixu.entity.AdvEntity;

import java.util.List;

/**
 * Created by CLY on 2017/1/3.
 */
public interface AdvService {
    /**
     * 查询所有轮播图
     * @return 轮播图信息列表
     */
    List<AdvEntity> findAll();
}
