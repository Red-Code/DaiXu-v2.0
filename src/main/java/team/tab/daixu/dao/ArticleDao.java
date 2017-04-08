package team.tab.daixu.dao;

import team.tab.daixu.cons.ArticleRuleRank;
import team.tab.daixu.cons.OrderConstent;
import team.tab.daixu.cons.UserJoinType;
import team.tab.daixu.entity.ArticleEntity;
import team.tab.daixu.util.page.PageUtil;

import java.util.List;

/**
 * Created by CLY on 2017/1/3.
 */
public interface ArticleDao extends BaseDao<ArticleEntity> {
    /**
     * 关联查询出首页需要展示的文章和文章信息
     * @param show_num 查询数
     * @return
     */
    List<ArticleEntity> findHomepageHeadArticle(int show_num);

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
     * @param now_page 当前页数
     * @param order 排序规则
     * @param rule_rank 接龙等级限制规则
     * @param show_num 每页展示文章数
     * @return 含有结果文章列表的分页对象
     */
    PageUtil findMoreByWhere(int now_page, OrderConstent order, ArticleRuleRank rule_rank, int show_num);

    /**
     * 根据参数条件查询出文章列表（拥有标签）
     * @param now_page 当前页数
     * @param order 排序规则
     * @param rule_rank 接龙等级限制规则
     * @param show_num 每页展示文章数
     * @param tag 按标签查询的“标签”
     * @return 含有结果文章列表的分页对象
     */
    PageUtil findMoreByWhere(int now_page, OrderConstent order, ArticleRuleRank rule_rank, int show_num,String tag);

    /**
     * 查询与该用户有关的文章
     * @param user_id 用户id
     * @param now_page 当前页数
     * @param order 排序规则
     * @param show_num 展示条数
     * @param relate_type 用户的参与状态
     * @return 含有结果文章列表的分页对象
     */
    PageUtil findMoreByUser(long user_id,int now_page, OrderConstent order,int show_num,UserJoinType relate_type);
}