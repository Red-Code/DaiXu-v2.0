package team.tab.daixu.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;
import team.tab.daixu.entity.ArticleEntity;
import team.tab.daixu.entity.ContinueEntity;
import team.tab.daixu.entity.UserEntity;
import team.tab.daixu.service.*;
import team.tab.daixu.util.CustomConstent;

import javax.annotation.Resource;
import java.util.List;

/**
 * Created by CLY on 2017/3/25.
 *
 * 常见接龙模块控制器
 */
@Controller
@RequestMapping("article")
public class ArticleController {
    @Resource(name = "advServiceImpl")
    private AdvService advServiceImpl;
    @Resource(name = "articleDraftServiceImpl")
    private ArticleDraftService articleDraftServiceImpl;
    @Resource(name = "articleLabelServiceImpl")
    private ArticleLabelService articleLabelServiceImpl;
    @Resource(name = "articleServiceImpl")
    private ArticleService articleServiceImpl;
    @Resource(name = "collectionServiceImpl")
    private CollectionService collectionServiceImpl;
    @Resource(name = "continueServiceImpl")
    private ContinueService continueServiceImpl;
    @Resource(name = "newsServiceImpl")
    private NewsService newsServiceImpl;
    @Resource(name = "replyServiceImpl")
    private ReplyService replyServiceImpl;
    @Resource(name = "storylineCommentServiceImpl")
    private StorylineCommentService storylineCommentServiceImpl;
    @Resource(name = "storylineContinueRelateServiceImpl")
    private StorylineContinueRelateService storylineContinueRelateServiceImpl;
    @Resource(name = "storylineContinueServiceImpl")
    private StorylineContinueService storylineContinueServiceImpl;
    @Resource(name = "storylineLabelServiceImpl")
    private StorylineLabelService storylineLabelServiceImpl;
    @Resource(name = "storylineServiceImpl")
    private StorylineService storylineServiceImpl;
    @Resource(name = "userServiceImpl")
    private UserService userServiceImpl;

    private ModelAndView mv = new ModelAndView();

    /**
     * @param get_now_page 当前页数，1表示第一页
     * @param get_order 1表示最新，2表示最热
     * @param get_rule 1表示包括等级1及以上，2表示等级2以上·····
     * @param get_tag 按标签查询的“标签”
     * @return 常见接龙分类页
     */
    @RequestMapping(value = "article_classify",method = RequestMethod.GET)
    public ModelAndView article_classify(
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
        List<ArticleEntity> show_list_article;
        if (get_tag==null){
            show_list_article = articleServiceImpl.findMoreByWhere(now_page,order,rule,show_num);
        }else {
            show_list_article = articleServiceImpl.findMoreByWhere(now_page,order,rule,show_num,get_tag);
        }

        int sum_page = articleServiceImpl.findPageSum(show_num);

        mv.setViewName("article_classify");
        mv.addObject("order",order);//当前的排序规则
        mv.addObject("rule",rule);//当前权限选择
        mv.addObject("list_article",show_list_article);//展示的文章列表
        mv.addObject("paging_now_page",now_page);//当前页数
        mv.addObject("paging_total_page",sum_page);//目前总页数
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
        UserEntity show_one_author = userServiceImpl.findOneById(show_one_article.getAuthor());
        String show_article_status = articleServiceImpl.findNowStatus(get_article_id,get_user_id);
        List<ContinueEntity> show_list_continue = continueServiceImpl.findMoreByWhere(get_article_id,now_page,show_num);
        int sum_page = continueServiceImpl.findPageSum(now_page,get_article_id);

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
     * 创建新的接龙文章
     * @param get_article_name 文章名
     * @param get_article_label 文章标签（每个标签之间用逗号隔开）
     * @param get_article_rule 文章规则
     * @param get_article_img 文章首页图片的文件
     * @param get_article_content 文章一楼的内容
     * @param get_article_jurisdiction 文章接龙权限（这是最低等级数，只能由这个等级以上的人接）
     * @param get_author_id 作者id
     * @return
     */
    @RequestMapping(value = "/publish_article",method = RequestMethod.GET)
    @ResponseBody
    public String publish_article(
            @RequestParam(value = "article_name")String get_article_name,
            @RequestParam(value = "article_label")String get_article_label,
            @RequestParam(value = "article_rule")String get_article_rule,
            @RequestParam(value="article_img")MultipartFile get_article_img,
            @RequestParam(value = "article_content")String get_article_content,
            @RequestParam(value = "article_jurisdiction")Integer get_article_jurisdiction,
            @CookieValue("user_id")int get_author_id
    ){
        ArticleEntity articleEntity = new ArticleEntity();
        articleEntity.setName(get_article_name);
        articleEntity.setRule(get_article_rule);
        articleEntity.setContent(get_article_content);
        articleEntity.setJurisdiction(get_article_jurisdiction);
        articleEntity.setAuthor(get_author_id);

        boolean flag = true;
        ArticleEntity result_article_entity = null;
        try {
            result_article_entity = articleServiceImpl.save(articleEntity,get_article_img);
            if (result_article_entity==null){
                flag = false;
            }
        } catch (Exception e) {
            flag = false;
            e.printStackTrace();
        }

        if (flag){
            Boolean result_save_label = articleLabelServiceImpl.actSave(result_article_entity.getId(),get_article_label);

            return String.valueOf(result_save_label);
        }else {
            return String.valueOf(false);
        }
    }

    /**
     * 发布续写内容
     * @param get_article_id 被续写文章id
     * @param get_user_id 发布者id
     * @param get_continue_content 续写内容
     * @return 是否成功
     */
    @RequestMapping(value = "/publish_continue",method = RequestMethod.GET)
    @ResponseBody
    public String publish_continue(
            @RequestParam(value = "article_id")int get_article_id,
            @CookieValue("user_id")int get_user_id,
            @RequestParam(value = "content") String get_continue_content
    ){
        ContinueEntity continueEntity = new ContinueEntity();
        continueEntity.setHead(get_article_id);
        continueEntity.setAuthor(get_user_id);
        continueEntity.setContent(get_continue_content);

        Boolean result_save_continue = continueServiceImpl.save(continueEntity);

        return String.valueOf(result_save_continue);
    }

}
