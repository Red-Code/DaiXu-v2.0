package team.tab.daixu.dao;

import team.tab.daixu.entity.ArticleEntity;

import java.util.List;

/**
 * Created by CLY on 2017/1/3.
 */
public interface ArticleDao extends BaseDao<ArticleEntity> {
    /**
     * 将文章持久化对象存入数据库
     * @param articleEntity 持久化对象
     * @return 存储成功的持久化类对象,失败返回null
     */
    ArticleEntity act_save(ArticleEntity articleEntity);

    /**
     * 根据id查询具体文章的首部信息
     * @param article_id 文章id
     * @return 单个文章持久化类对象
     */
    ArticleEntity getOneById(Integer article_id);

    /**
     * 关联查询出首页需要展示的文章和文章信息
     * @return
     */
    List<ArticleEntity> findHomepageHeadArticle();

    /**
     * 查询出首页的最新文章
     * @param show_num 查询数
     * @return
     */
    List<ArticleEntity> findArticleNewList(int show_num);

    /**
     * 查询出首页的推荐文章
     * @param show_num 查询数
     * @return
     */
    List<ArticleEntity> findArticleRecommendList(int show_num);

    /**
     * 根据参数条件查询出文章列表
     * @param begin_limit 查询起始数（比如为10，则从第10条记录开始查询）
     * @param order 排序规则
     * @param rule 1表示包括等级1及以上，2表示等级2以上·····
     * @param show_num 每页展示文章数
     * @return 文章列表
     */
    List<ArticleEntity> findMoreByWhere(Integer begin_limit, String order, Integer rule,int show_num);

    /**
     * 根据参数条件查询出文章列表
     * @param begin_limit 查询起始数（比如为10，则从第10条记录开始查询）
     * @param order 排序规则
     * @param rule 1表示包括等级1及以上，2表示等级2以上·····
     * @param show_num 每页展示文章数
     * @param tag 按标签查询的“标签”
     * @return 文章列表
     */
    List<ArticleEntity> findMoreByWhere(Integer begin_limit, String order, Integer rule,int show_num,String tag);

    /**
     * 根据所有的文章，查询出总分页数
     * @param show_num 每页展示文章数
     * @return 总分页数
     */
    int findPageSum(int show_num);

    /**
     * 查询与该用户有关的文章
     * @param user_id 用户id
     * @param begin_limit 查询起始数（比如为10，则从第10条记录开始查询）
     * @param order 排序规则
     * @param show_num 展示条数
     * @param relate_type 1表示是发布的，2表示是参与的
     * @return
     */
    List<ArticleEntity> findMoreByUser(Integer user_id,Integer begin_limit, String order,int show_num,int relate_type);

    /**
     * 根据用户id查询文章列表总数
     * @param user_id 用户id
     * @param show_num 展示数量
     * @param relate_type 1表示是发布的，2表示是参与的
     * @return 总页数
     */
    int findPageSumByUser(Integer user_id,int show_num,int relate_type);

}