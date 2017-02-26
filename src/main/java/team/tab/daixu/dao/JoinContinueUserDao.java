package team.tab.daixu.dao;

import team.tab.daixu.entity.JoinContinueUserEntity;

import java.util.List;

/**
 * Created by CLY on 2017/2/23.
 */
public interface JoinContinueUserDao {
    /**
     * 根据参数查询指定文章的所有接龙楼层信息
     * @param article_id 文章id
     * @param begin_lilmit 查询起始条数
     * @param show_num 展示多少楼
     * @return 各楼层信息列表
     */
    List<JoinContinueUserEntity> findMoreByWhere(Integer article_id, Integer begin_lilmit, int show_num);

    /**
     * 根据文章id，查询出总分页数
     * @param show_num 每页展示条数
     * @param article_id 文章id
     * @return 总分页数
     */
    int findPageSum(int show_num,int article_id);
}
