package team.tab.daixu.service.impl;

import team.tab.daixu.dao.JoinArticleContinueDao;
import team.tab.daixu.entity.JoinArticleContinueEntity;
import team.tab.daixu.service.JoinArticleContinueService;

import java.util.List;

/**
 * Created by CLY on 2017/2/20.
 */
public class JoinArticleContinueServiceImpl implements JoinArticleContinueService{
    private JoinArticleContinueDao joinArticleContinueDaoImpl;
    @Override
    public List<JoinArticleContinueEntity> findHomepageHeadArticle() {
        return joinArticleContinueDaoImpl.findHomepageHeadArticle();
    }
}
