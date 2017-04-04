package team.tab.daixu.service;

import team.tab.daixu.cons.OrderConstent;
import team.tab.daixu.entity.StorylineCommentEntity;

import java.util.List;

/**
 * Created by CLY on 2017/1/3.
 */
public interface StorylineCommentService {
    /**
     * 查询某故事线的评论详情
     * @param storyline_id 故事线id
     * @param now_page 当前页数
     * @param show_num 显示条数
     * @param time_order 时间排序规则
     * @return 含有评论者信息的评论列表
     */
    List<StorylineCommentEntity> findMoreByWhere(int storyline_id,Integer now_page,int show_num,OrderConstent time_order);
}
