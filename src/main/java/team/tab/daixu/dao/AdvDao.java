package team.tab.daixu.dao;

import team.tab.daixu.entity.AdvEntity;

import java.util.List;

/**
 * Created by CLY on 2017/1/3.
 */
public interface AdvDao {
    /**
     * 查找全部轮播图信息
     * @return 全部轮播图列表
     */
    List<AdvEntity> findAll();
    void delete(int id);//根据id删除轮播图
    void save(AdvEntity advEntity);//添加轮播图
}
