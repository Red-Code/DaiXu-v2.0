package team.tab.daixu.service.impl;

import team.tab.daixu.dao.JoinArticleContinueUserDao;
import team.tab.daixu.entity.JoinArticleContinueUserEntity;
import team.tab.daixu.service.JoinArticleContinueUserService;

import java.util.List;

/**
 * Created by CLY on 2017/2/20.
 */
public class JoinArticleContinueUserServiceImpl implements JoinArticleContinueUserService {
    private JoinArticleContinueUserDao joinArticleContinueUserDaoImpl;

    @Override
    public List<JoinArticleContinueUserEntity> findArticleNewList(int show_num) {
        return joinArticleContinueUserDaoImpl.findArticleNewList(show_num);
    }

    @Override
    public List<JoinArticleContinueUserEntity> findArticleRecommendList(int show_num) {
        return joinArticleContinueUserDaoImpl.findArticleRecommendList(show_num);
    }

    @Override
    public List<JoinArticleContinueUserEntity> findMoreByWhere(Integer now_page, String order, Integer rule, int show_num) {
        int begin_limit = now_page*show_num-show_num;
        return joinArticleContinueUserDaoImpl.findMoreByWhere(begin_limit,order,rule,show_num);
    }

    @Override
    public List<JoinArticleContinueUserEntity> findMoreByWhere(Integer now_page, String order, Integer rule, int show_num, String tag) {
        int begin_limit = now_page*show_num-show_num;
        return joinArticleContinueUserDaoImpl.findMoreByWhere(begin_limit,order,rule,show_num,tag);
    }

    @Override
    public int findPageSum(int show_num) {
        return joinArticleContinueUserDaoImpl.findPageSum(show_num);
    }

    @Override
    public List<JoinArticleContinueUserEntity> findMoreByUser(Integer user_id, Integer now_page, String order, int show_num, int relate_type) {
        int begin_limit = now_page*show_num-show_num;
        return joinArticleContinueUserDaoImpl.findMoreByUser(user_id,begin_limit,order,show_num,relate_type);
    }

    @Override
    public int findPageSumByUser(Integer user_id, int show_num, int relate_type) {
        return joinArticleContinueUserDaoImpl.findPageSumByUser(user_id,show_num,relate_type);
    }
}
