package team.tab.daixu.service;

import team.tab.daixu.entity.JoinArticleContinueUserEntity;

import java.util.List;

/**
 * Created by CLY on 2017/2/20.
 *
 * Article表和Continue表和User表关联查询
 */
public interface JoinArticleContinueUserService {

    /**
     * 查询出首页的最新文章
     * @param show_num 查询数
     * @return
     */
    List<JoinArticleContinueUserEntity> findArticleNewList(int show_num);

    /**
     * 查询出首页的推荐文章
     * @param show_num 查询数
     * @return
     */
    List<JoinArticleContinueUserEntity> findArticleRecommendList(int show_num);

    /**
     * 根据参数条件查询出文章列表
     * @param now_page 当前页数，1表示第一页
     * @param order 排序规则
     * @param rule 1表示包括等级1及以上，2表示等级2以上·····
     * @param show_num 每页展示文章数
     * @return 文章列表
     */
    List<JoinArticleContinueUserEntity> findMoreByWhere(Integer now_page, String order, Integer rule,int show_num);

    /**
     * 根据参数条件查询出文章列表
     * @param now_page 当前页数，1表示第一页
     * @param order 排序规则
     * @param rule 1表示包括等级1及以上，2表示等级2以上·····
     * @param show_num 每页展示文章数
     * @param tag 按标签查询的“标签”
     * @return 文章列表
     */
    List<JoinArticleContinueUserEntity> findMoreByWhere(Integer now_page, String order, Integer rule,int show_num,String tag);

    /**
     * 根据所有的文章，查询出总分页数
     * @param show_num 每页展示文章数
     * @return 总分页数
     */
    int findPageSum(int show_num);

    /**
     * 查询与该用户有关的文章
     * @param user_id 用户id
     * @param now_page 当前页数
     * @param order 排序规则
     * @param show_num 展示条数
     * @param relate_type 1表示是发布的，2表示是参与的
     * @return
     */
    List<JoinArticleContinueUserEntity> findMoreByUser(Integer user_id,Integer now_page, String order,int show_num,int relate_type);

    /**
     * 根据用户id查询文章列表总数
     * @param user_id 用户id
     * @param show_num 展示数量
     * @param relate_type 1表示是发布的，2表示是参与的
     * @return 总页数
     */
    int findPageSumByUser(Integer user_id,int show_num,int relate_type);

}
