package team.tab.daixu.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CookieValue;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
import team.tab.daixu.entity.*;
import team.tab.daixu.service.*;
import team.tab.daixu.util.CustomConstent;

import java.util.List;

/**
 * Created by CLY on 2017/1/5.
 *
 * 变量名说明：
 * 所有传入的参数都以“get_”开头。
 * 需要赋值给前端页面的值都以“show_”开头。
 * 多个持久化类以列表形式储存，以“_list_”命名。
 * 单一持久化类，以“_one_”命名。
 */
@Controller//该注解用来识别控制器
@RequestMapping("show")//该注解用来控制url书写时，控制器的选择
public class ShowController {
    private AdvService advServiceImpl;
    private ArticleDraftService articleDraftServiceImpl;
    private ArticleLabelService articleLabelServiceImpl;
    private ArticleService articleServiceImpl;
    private CollectionService collectionServiceImpl;
    private ContinueService continueServiceImpl;
    private NewsService newsServiceImpl;
    private ReplyService replyServiceImpl;
    private StorylineCommentService storylineCommentServiceImpl;
    private StorylineContinueRelateService storylineContinueRelateServiceImpl;
    private StorylineContinueService storylineContinueServiceImpl;
    private StorylineLabelService storylineLabelServiceImpl;
    private StorylineService storylineServiceImpl;
    private UserService userServiceImpl;

    private ModelAndView mv = new ModelAndView();
    /**
     * @return 首页
     */
    @RequestMapping(value="/homepage",method= RequestMethod.GET)
    public ModelAndView homepage() {
        final int article_commend_show_num = 6;//推荐文章展示数量
        final int storyline_commend_show_num = 6;//推荐故事线展示数量
        final int article_new_show_num = 6;//最新文章展示数量
        final int storyline_new_show_num = 6;//最新故事线展示数量

        List<AdvEntity> show_list_advs = advServiceImpl.findAll();
        List<UserEntity> show_list_recommend_author = userServiceImpl.findRecommendAuthor();
        List<JoinArticleContinueEntity> show_list_head_article = joinArticleContinueServiceImpl.findHomepageHeadArticle();
        List<JoinArticleContinueUserEntity> show_list_recommend_article = joinArticleContinueUserServiceImpl.findArticleRecommendList(article_commend_show_num);
        List<StorylineEntity> show_list_recommend_storyline = storylineServiceImpl.findMoreRecommend(storyline_commend_show_num);
        List<JoinArticleContinueUserEntity> show_list_new_article = joinArticleContinueUserServiceImpl.findArticleNewList(article_new_show_num);
        List<StorylineEntity> show_list_new_storyline = storylineServiceImpl.findMoreByWhere(1,CustomConstent.ORDER_DESC,1,storyline_new_show_num);

        mv.setViewName("homepage");//homepage就是视图的名称（homepage.ftl）
        mv.addObject("list_advs",show_list_advs);//轮播图信息
        mv.addObject("list_recommend_author",show_list_recommend_author);//推荐作者列表
        mv.addObject("list_head_article",show_list_head_article);//“可视”文章详细信息
        mv.addObject("list_recommend_article",show_list_recommend_article);//推荐文章首部列表
        mv.addObject("list_recommend_storyline",show_list_recommend_storyline);//推荐故事线首部列表
        mv.addObject("list_new_article",show_list_new_article);//最新文章首部列表
        mv.addObject("list_new_storyline",show_list_new_storyline);//最新故事线首部列表
        return mv;
    }

    /**
     * @param get_now_page 当前页数，1表示第一页
     * @param get_order 1表示最新，2表示最热
     * @param get_rule 1表示包括等级1及以上，2表示等级2以上·····
     * @param get_tag 按标签查询的“标签”
     * @return 常见接龙分类页
     */
    @RequestMapping(value = "article",method = RequestMethod.GET)
    public ModelAndView article(
            @RequestParam(value = "now_page",required = false) Integer get_now_page,
            @RequestParam(value = "order",required = false) Character get_order,
            @RequestParam(value = "rule",required = false) Integer get_rule,
            @RequestParam(value = "tag",required = false) String get_tag
    ){
        final int show_num = 12;//每页展示数
        final String order;//排序方法
        final Integer now_page;//当前页数
        final Integer rule;//按等级查询的条件

        switch (get_order){
            case '1':
                order = CustomConstent.ORDER_DESC;
                break;
            case '2':
                order = CustomConstent.ORDER_HOT;
                break;
            default:
                order = CustomConstent.ORDER_DESC;
                break;
        }

        if (get_now_page==null){
            now_page = 1;
        }else {
            now_page = get_now_page;
        }

        if (get_rule==null){
            rule = 1;
        }else {
            rule = get_rule;
        }
        List<JoinArticleContinueUserEntity> show_list_article;
        if (get_tag==null){
            show_list_article = joinArticleContinueUserServiceImpl.findMoreByWhere(now_page,order,rule,show_num);
        }else {
            show_list_article = joinArticleContinueUserServiceImpl.findMoreByWhere(now_page,order,rule,show_num,get_tag);
        }

        int sum_page = joinArticleContinueUserServiceImpl.findPageSum(show_num);

        mv.setViewName("article");
        mv.addObject("order",order);//当前的排序规则
        mv.addObject("rule",rule);//当前权限选择
        mv.addObject("list_article",show_list_article);//展示的文章列表
        mv.addObject("paging_now_page",now_page);//当前页数
        mv.addObject("paging_total_page",sum_page);//目前总页数
        mv.setViewName("storyline");
        return mv;
    }

    /**
     * @param get_now_page 当前页数，1表示第一页
     * @param get_order 1表示最新，2表示最热
     * @param get_rule 1表示全部。2表示二万字以下。3表示二万字到十万字。4表示十万字以上
     * @param get_tag 按标签查询的“标签”
     * @return 故事线分类页
     */
    @RequestMapping(value = "storyline",method = RequestMethod.GET)
    public ModelAndView storyline(
            @RequestParam(value = "now_page",required = false) Integer get_now_page,
            @RequestParam(value = "order",required = false) Character get_order,
            @RequestParam(value = "rule",required = false) Integer get_rule,
            @RequestParam(value = "tag",required = false) String get_tag
    ){
        final int show_num = 12;
        final String order;
        final Integer now_page;
        final Integer rule;

        switch (get_order){
            case '1':
                order = CustomConstent.ORDER_DESC;
                break;
            case '2':
                order = CustomConstent.ORDER_HOT;
                break;
            default:
                order = CustomConstent.ORDER_DESC;
                break;
        }

        if (get_now_page==null){
            now_page = 1;
        }else {
            now_page = get_now_page;
        }

        if (get_rule==null){
            rule = 1;
        }else {
            rule = get_rule;
        }

        List<StorylineEntity> show_list_storyline;
        if (get_tag==null){
            show_list_storyline=storylineServiceImpl.findMoreByWhere(now_page,order,rule,show_num);
        }else {
            show_list_storyline=storylineServiceImpl.findMoreByWhere(now_page,order,rule,show_num,get_tag);
        }

        int sum_page = storylineServiceImpl.findPageSum(show_num);

        mv.setViewName("storyline");
        mv.addObject("order",order);//当前的排序规则
        mv.addObject("rule",rule);//当前权限选择
        mv.addObject("list_article",show_list_storyline);//展示的故事线列表
        mv.addObject("paging_now_page",now_page);//当前页数
        mv.addObject("paging_total_page",sum_page);//目前总页数
        mv.setViewName("storyline");
        return mv;
    }

    /**
     * @return 常见接龙的发布页
     */
    @RequestMapping(value = "article_publish",method = RequestMethod.GET)
    public ModelAndView article_publish(){
        mv.setViewName("article_publish");
        return mv;
    }

    /**
     * @return 故事线的发布页
     */
    @RequestMapping(value = "storyline_publish",method = RequestMethod.GET)
    public ModelAndView storyline_publish(){
        mv.setViewName("storyline_publish");
        return mv;
    }

    /**
     * 故事线续写支线发布页
     * @param get_storyline_id 被续写的故事线id
     * @return 故事线续写支线发布页
     */
    @RequestMapping(value = "storyline_continue_publish",method = RequestMethod.GET)
    public ModelAndView storyline_continue_publish(
            @RequestParam(value = "storyline_id")int get_storyline_id
    ){
        List<StorylineContinueEntity> show_storylineContinueEntity = storylineContinueServiceImpl.findNoEndByStorylineId(get_storyline_id);

        mv.setViewName("storyline_continue_publish");
        mv.addObject("list_storyline_continue",show_storylineContinueEntity);
        return mv;
    }

    /**
     * 展示具体某篇文章
     * @param get_article_id （必传）文章id
     * @param get_now_page 当前页数
     * @return 文章详情页
     */
    @RequestMapping(value = "article",method = RequestMethod.GET)
    public ModelAndView article(
            @RequestParam(value = "article_id") Integer get_article_id,
            @RequestParam(value = "now_page",required = false) Integer get_now_page,
            @CookieValue("user_id") Integer get_user_id
    ){
        final int show_num = 20;//每页展示的层数
        final Integer now_page;//当前页数

        if (get_now_page==null){
            now_page = 1;
        }else {
            now_page = get_now_page;
        }

        ArticleEntity show_one_article = articleServiceImpl.findOneById(get_article_id);
        UserEntity show_one_author = userServiceImpl.findOneById(show_one_article.getArticleAuthor());
        String show_article_status = articleServiceImpl.findNowStatus(get_article_id,get_user_id);
        List<JoinContinueUserEntity> show_list_continue = joinContinueUserServiceImpl.findMoreByWhere(get_article_id,now_page,show_num);
        int sum_page = joinContinueUserServiceImpl.findPageSum(now_page,get_article_id);

        mv.setViewName("article");
        mv.addObject("one_article",show_one_article);//该故事的创建信息
        mv.addObject("status_article",show_article_status);//该文章的抢接状态
        mv.addObject("one_author",show_one_author);//该故事发起作者的信息
        mv.addObject("list_continue",show_list_continue);//接龙详情
        mv.addObject("paging_now_page",now_page);//当前页数
        mv.addObject("paging_total_page",sum_page);//目前总页数

        return mv;
    }

    /**
     * 故事线详情页展示
     * @param get_storyline_id 故事线id
     * @return
     */
    @RequestMapping(value = "storyline",method = RequestMethod.GET)
    public ModelAndView storyline(
            @RequestParam(value = "storyline_id")Integer get_storyline_id
    ){
        final int now_page = 1;
        final int show_num = 4;
        final String time_order = CustomConstent.ORDER_DESC;//从最新的评论开始显示

        StorylineEntity show_one_storyline = storylineServiceImpl.findOneById(get_storyline_id);
        UserEntity show_one_author = userServiceImpl.findOneById(show_one_storyline.getAuthorId());
        List<JoinStorylineCommentUserEntity> show_list_comment = joinStorylineCommentUserServiceImpl.findMoreByWhere(get_storyline_id, now_page, show_num, time_order);

        mv.setViewName("storyline");
        mv.addObject("one_storyline",show_one_storyline);//该故事线的主要信息
        mv.addObject("one_author",show_one_author);//该故事线创建作者的信息
        mv.addObject("list_comment",show_list_comment);//评论列表详情

        return mv;
    }

    /**
     * 我的主页，常见接龙
     * @param get_user_id 用户id
     * @param get_now_page 当前页数
     * @param get_relate_type 1表示是发布的，2表示是参与的
     * @return
     */
    @RequestMapping(value = "my_homepage_article",method = RequestMethod.GET)
    public ModelAndView my_homepage_article(
            @CookieValue("user_id")Integer get_user_id,
            @RequestParam(value = "now_page",required = false)Integer get_now_page,
            @RequestParam(value = "relate_type",required = false)Integer get_relate_type
    ){
        final int now_page;//当前页数
        final int show_num = 9;//每页展示数
        final String time_order = CustomConstent.ORDER_DESC;//查询的排序方法
        final int relate_type;//1表示是发布的，2表示是参与的

        if (get_now_page==null){
            now_page = 1;
        }else {
            now_page = get_now_page;
        }

        if (get_relate_type==null){
            relate_type = 1;
        }else {
            relate_type = get_relate_type;
        }

        UserEntity show_user_info = userServiceImpl.findOneById(get_user_id);
        List<UserEntity> show_list_follow = userServiceImpl.findFollowListById(get_user_id);
        List<JoinArticleContinueUserEntity> show_list_my_article = joinArticleContinueUserServiceImpl.findMoreByUser(get_user_id, now_page, time_order, show_num, relate_type);
        int sum_page = joinArticleContinueUserServiceImpl.findPageSumByUser(get_user_id,show_num,relate_type);

        mv.setViewName("my_homepage_article");
        mv.addObject("one_user_info",show_user_info);//用户信息
        mv.addObject("list_follow",show_list_follow);//该用户关注的用户
        mv.addObject("list_my_article",show_list_my_article);//相关文章列表
        mv.addObject("paging_now_page",now_page);//当前页数
        mv.addObject("paging_total_page",sum_page);//目前总页数

        return mv;
    }

    /**
     * 我的主页，故事线
     * @param get_user_id 用户id
     * @param get_now_page 当前页数
     * @param get_relate_type 1表示是发布的，2表示是参与的
     * @return
     */
    @RequestMapping(value = "my_homepage_storyline",method = RequestMethod.GET)
    public ModelAndView my_homepage_storyline(
            @CookieValue("user_id")Integer get_user_id,
            @RequestParam(value = "now_page",required = false)Integer get_now_page,
            @RequestParam(value = "relate_type",required = false)Integer get_relate_type
    ){
        final int now_page;//当前页数
        final int show_num = 9;//每页展示数
        final String time_order = CustomConstent.ORDER_DESC;//查询的排序方法
        final int relate_type;//1表示是发布的，2表示是参与的

        if (get_now_page==null){
            now_page = 1;
        }else {
            now_page = get_now_page;
        }

        if (get_relate_type==null){
            relate_type = 1;
        }else {
            relate_type = get_relate_type;
        }

        UserEntity show_user_info = userServiceImpl.findOneById(get_user_id);
        List<UserEntity> show_list_follow = userServiceImpl.findFollowListById(get_user_id);
        List<StorylineEntity> show_list_my_storyline = storylineServiceImpl.findMoreByUser(get_user_id, now_page, time_order, show_num, relate_type);
        int sum_page = storylineServiceImpl.findPageSumByUser(get_user_id,show_num,relate_type);

        mv.setViewName("my_homepage_article");
        mv.addObject("one_user_info",show_user_info);//用户信息
        mv.addObject("list",show_list_follow);//该用户关注的用户
        mv.addObject("list_my_storyline",show_list_my_storyline);//相关故事线列表
        mv.addObject("paging_now_page",now_page);//当前页数
        mv.addObject("paging_total_page",sum_page);//目前总页数

        return mv;
    }
}