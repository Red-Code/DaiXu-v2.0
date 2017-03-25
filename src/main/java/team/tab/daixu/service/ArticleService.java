package team.tab.daixu.service;

import org.springframework.web.multipart.MultipartFile;
import team.tab.daixu.entity.ArticleEntity;

import java.util.List;

/**
 * Created by CLY on 2017/1/3.
 */
public interface ArticleService {
    /**
     * 创建新文章
     * @param articleEntity 文章实例化对象
     * @param article_img 文章图片文件
     * @return 如果成功返回该文章的持久化对象，失败则返回null
     * @throws Exception 存储图片时的异常
     */
    ArticleEntity save(ArticleEntity articleEntity, MultipartFile article_img) throws Exception;

    /**
     * 根据id查询具体文章的首部信息
     * @param article_id 文章id
     * @return 单个文章持久化类对象
     */
    ArticleEntity findOneById(Integer article_id);

    /**
     * 根据文章id和目前的访问用户id查询出该文章目前的接龙状况
     * @param article_id 文章id
     * @param user_id 目前的访问用户id
     * @return null表示该文章目前没有被接龙。“1”表示自己正在接龙该文章。“2”表示该文章目前正在被别人接龙。
     */
    String findNowStatus(Integer article_id,Integer user_id);

    /**
     * 根据用户id查看其是否能抢接续写该文章
     * @param user_id 用户id
     * @param article_id 文章id
     * @return “1”表示能抢接该文章。“2”表示该文章正在被别人续写不能抢接。“3”表示该用户目前被禁言不能抢接
     */
    String checkContinue(int user_id,int article_id);

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
     * @param now_page 当前页数，1表示第一页
     * @param order 排序规则
     * @param rule 1表示包括等级1及以上，2表示等级2以上·····
     * @param show_num 每页展示文章数
     * @return 文章列表
     */
    List<ArticleEntity> findMoreByWhere(Integer now_page, String order, Integer rule,int show_num);

    /**
     * 根据参数条件查询出文章列表
     * @param now_page 当前页数，1表示第一页
     * @param order 排序规则
     * @param rule 1表示包括等级1及以上，2表示等级2以上·····
     * @param show_num 每页展示文章数
     * @param tag 按标签查询的“标签”
     * @return 文章列表
     */
    List<ArticleEntity> findMoreByWhere(Integer now_page, String order, Integer rule,int show_num,String tag);

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
    List<ArticleEntity> findMoreByUser(Integer user_id,Integer now_page, String order,int show_num,int relate_type);

    /**
     * 根据用户id查询文章列表总数
     * @param user_id 用户id
     * @param show_num 展示数量
     * @param relate_type 1表示是发布的，2表示是参与的
     * @return 总页数
     */
    int findPageSumByUser(Integer user_id,int show_num,int relate_type);

}