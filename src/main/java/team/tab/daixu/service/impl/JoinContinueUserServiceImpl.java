package team.tab.daixu.service.impl;

import team.tab.daixu.dao.JoinContinueUserDao;
import team.tab.daixu.entity.JoinContinueUserEntity;
import team.tab.daixu.service.JoinContinueUserService;

import java.util.List;

/**
 * Created by CLY on 2017/2/24.
 */
public class JoinContinueUserServiceImpl implements JoinContinueUserService {
    private JoinContinueUserDao joinContinueUserDaoImpl;

    @Override
    public List<JoinContinueUserEntity> findMoreByWhere(Integer article_id, Integer now_layer, int show_num) {
        int limit_begin = now_layer*show_num-show_num;
        return joinContinueUserDaoImpl.findMoreByWhere(article_id,limit_begin,show_num);
    }

    @Override
    public int findPageSum(int show_num, int article_id) {
        return joinContinueUserDaoImpl.findPageSum(show_num, article_id);
    }
}
