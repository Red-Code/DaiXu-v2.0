package team.tab.daixu.service;

import team.tab.daixu.entity.JoinStorylineCommentUserEntity;

import java.util.List;

/**
 * Created by CLY on 2017/2/21.
 *
 * StorylineComment表，User表，关联查询
 */
public interface JoinStorylineCommentUserService {

    /**
     * 查询某故事线的评论详情
     * @param storyline_id 故事线id
     * @param now_page 当前页数
     * @param show_num 显示条数
     * @param time_order 时间排序规则
     * @return 含有评论者信息的评论列表
     */
    List<JoinStorylineCommentUserEntity> findMoreByWhere(int storyline_id,Integer now_page,int show_num,String time_order);
}
