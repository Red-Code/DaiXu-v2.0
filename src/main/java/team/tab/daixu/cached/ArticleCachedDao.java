package team.tab.daixu.cached;

import team.tab.daixu.entity.ArticleEntity;

import java.util.List;

/**
 * Created by CLY on 2017/1/3.
 */
public interface ArticleCachedDao extends BaseCachedDao{
    /**
     * 根据文章id，获得所对应的缓存键值名
     * @param article_id 文章id
     * @return key
     */
    String getOneKey(int article_id);

    /**
     * 关联查询出首页需要展示的文章和文章信息-缓存key
     * @return key
     */
    String getHomepageHeadArticleKey();

    /**
     * 查询出首页的最新文章-缓存key
     * @return key
     */
    String getArticleNewListKey();

    /**
     * 查询出首页的推荐文章-缓存key
     * @return key
     */
    String getArticleRecommendListKey();

    /**
     * 查询与该用户有关的文章-缓存key
     * @param user_id 用户id
     * @return
     */
    String getMoreByUserKey(int user_id);
}