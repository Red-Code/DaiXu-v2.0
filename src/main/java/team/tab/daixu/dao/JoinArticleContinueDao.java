package team.tab.daixu.dao;

import team.tab.daixu.entity.JoinArticleContinueEntity;

import java.util.List;

/**
 * Created by CLY on 2017/2/23.
 */
public interface JoinArticleContinueDao {
    /**
     * 关联查询出首页需要展示的文章和文章信息
     * @return
     */
    List<JoinArticleContinueEntity> findHomepageHeadArticle();
}
