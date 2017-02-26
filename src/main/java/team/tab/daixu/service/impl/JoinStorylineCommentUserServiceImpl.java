package team.tab.daixu.service.impl;

import team.tab.daixu.dao.JoinStorylineCommentUserDao;
import team.tab.daixu.entity.JoinStorylineCommentUserEntity;
import team.tab.daixu.service.JoinStorylineCommentUserService;

import java.util.List;

/**
 * Created by CLY on 2017/2/24.
 */
public class JoinStorylineCommentUserServiceImpl implements JoinStorylineCommentUserService {
    private JoinStorylineCommentUserDao joinStorylineCommentUserDaoImpl;

    @Override
    public List<JoinStorylineCommentUserEntity> findMoreByWhere(int storyline_id, Integer now_page, int show_num, String time_order) {
        int begin_limit = now_page*show_num-show_num;
        return joinStorylineCommentUserDaoImpl.findMoreByWhere(storyline_id, begin_limit, show_num, time_order);
    }
}
