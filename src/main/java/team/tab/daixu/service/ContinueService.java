package team.tab.daixu.service;

import team.tab.daixu.entity.ContinueEntity;

import java.util.List;

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

    /**
     * 根据参数查询指定文章的所有接龙楼层信息
     * @param article_id 文章id
     * @param now_layer 当前楼层数
     * @param show_num 展示多少楼
     * @return 各楼层信息列表
     */
    List<ContinueEntity> findMoreByWhere(Integer article_id, Integer now_layer, int show_num);

    /**
     * 根据文章id，查询出总分页数
     * @param show_num 每页展示条数
     * @param article_id 文章id
     * @return 总分页数
     */
    int findPageSum(int show_num,int article_id);
}
