package team.tab.daixu.dao;

import team.tab.daixu.cons.OrderConstent;
import team.tab.daixu.cons.StorylineNumRule;
import team.tab.daixu.cons.UserJoinType;
import team.tab.daixu.entity.StorylineEntity;
import team.tab.daixu.util.page.PageUtil;

import java.util.List;

/**
 * Created by CLY on 2017/1/3.
 */
public interface StorylineDao extends BaseDao<StorylineEntity>{
    /**
     * 根据条件查询出故事线列表（无标签条件）
     * @param now_page 当前页数，1表示第一页
     * @param order 排序顺序
     * @param num_rule 1表示全部。2表示二万字以下。3表示二万字到十万字。4表示十万字以上
     * @param show_num 展示条数
     * @return 故事线列表
     */
    PageUtil findMoreByOrderRule(int now_page, OrderConstent order, StorylineNumRule num_rule, int show_num);

    /**
     * 根据条件查询出故事线列表（有标签条件）
     * @param now_page 当前页数，1表示第一页
     * @param order 排序顺序
     * @param num_rule 1表示全部。2表示二万字以下。3表示二万字到十万字。4表示十万字以上
     * @param show_num 展示页数
     * @param tag 按标签查询的“标签”
     * @return 故事线列表
     */
    PageUtil findMoreByOrderRuleTag(int now_page, OrderConstent order, StorylineNumRule num_rule, int show_num,String tag);

    /**
     * 根据用户id查询改用户参与的故事线列表
     * @param user_id 用户id
     * @param now_page 当前页数
     * @param time_order 排序规则
     * @param show_num 展示数量
     * @param relate_type 1表示是发布的，2表示是参与的
     * @return
     */
    PageUtil findMoreByUser(long user_id, int now_page, OrderConstent time_order, int show_num, UserJoinType relate_type);

    /**
     * 查找推荐的故事线文章
     * @param storyline_commend_show_num 显示条数
     * @return 故事线文章列表
     */
    List<StorylineEntity> findMoreRecommend(int storyline_commend_show_num);
}
