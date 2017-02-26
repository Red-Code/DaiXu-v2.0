package team.tab.daixu.service;

import team.tab.daixu.entity.JoinArticleContinueEntity;

import java.util.List;

/**
 * Created by CLY on 2017/2/20.
 *
 * article表和continue表的关联查询
 */
public interface JoinArticleContinueService {

    /**
     * 关联查询出首页需要展示的文章和文章信息
     * @return
     */
    List<JoinArticleContinueEntity> findHomepageHeadArticle();
}