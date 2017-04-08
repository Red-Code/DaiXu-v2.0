package team.tab.daixu.dao.impl;

import org.springframework.stereotype.Repository;
import team.tab.daixu.cons.OrderConstent;
import team.tab.daixu.cons.StorylineNumRule;
import team.tab.daixu.cons.UserJoinType;
import team.tab.daixu.dao.StorylineDao;
import team.tab.daixu.entity.ArticleEntity;
import team.tab.daixu.entity.StorylineEntity;
import team.tab.daixu.util.page.PageUtil;

import java.util.List;

/**
 * Created by CLY on 2017/1/5.
 */
@Repository
public class StorylineDaoImpl extends BaseDaoImpl<StorylineEntity> implements StorylineDao {

    @Override
    public PageUtil findMoreByOrderRule(int now_page, OrderConstent order, StorylineNumRule num_rule, int show_num) {
        return null;
    }

    @Override
    public PageUtil findMoreByOrderRuleTag(int now_page, OrderConstent order, StorylineNumRule num_rule, int show_num, String tag) {
        return null;
    }

    @Override
    public PageUtil findMoreByUser(long user_id, int now_page, OrderConstent time_order, int show_num, UserJoinType relate_type) {
        return null;
    }

    @Override
    public List<StorylineEntity> findMoreRecommend(int storyline_commend_show_num) {
        return null;
    }
}
