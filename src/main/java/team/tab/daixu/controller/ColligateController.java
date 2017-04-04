package team.tab.daixu.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;
import team.tab.daixu.cached.AdvCachedDao;
import team.tab.daixu.cons.OrderConstent;
import team.tab.daixu.entity.AdvEntity;
import team.tab.daixu.entity.ArticleEntity;
import team.tab.daixu.entity.StorylineEntity;
import team.tab.daixu.entity.UserEntity;
import team.tab.daixu.service.*;
import team.tab.daixu.util.CustomConstent;

import javax.annotation.Resource;
import java.util.List;

/**
 * Created by CLY on 2017/3/26.
 *
 * 变量名说明：
 * 所有传入的参数都以“get_”开头。
 * 需要赋值给前端页面的值都以“show_”开头。
 * 多个持久化类以列表形式储存，以“_list_”命名。
 * 单一持久化类，以“_one_”命名。
 *
 * 综合模块控制器
 */
@Controller
@RequestMapping("colligate")
public class ColligateController {
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

    @Resource(name = "advCachedDaoImpl")
    private AdvCachedDao advCachedDaoImpl;

    @RequestMapping(value = "/demo_set",method = RequestMethod.GET)
    @ResponseBody
    public String demo_set(){
        String key_name = advCachedDaoImpl.get_key_name();
        //存入键值对
        advCachedDaoImpl.set(key_name,"hello jedis adv_list");

        return "set_success";
    }

    @RequestMapping(value = "/demo_get",method = RequestMethod.GET)
    @ResponseBody
    public String demo_get(){
        String key_name=advCachedDaoImpl.get_key_name();

        return advCachedDaoImpl.get(key_name);
    }

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
        List<ArticleEntity> show_list_head_article = articleServiceImpl.findHomepageHeadArticle();
        List<ArticleEntity> show_list_recommend_article = articleServiceImpl.findArticleRecommendList(article_commend_show_num);
        List<StorylineEntity> show_list_recommend_storyline = storylineServiceImpl.findMoreRecommend(storyline_commend_show_num);
        List<ArticleEntity> show_list_new_article = articleServiceImpl.findArticleNewList(article_new_show_num);
        List<StorylineEntity> show_list_new_storyline = storylineServiceImpl.findMoreByWhere(1, OrderConstent.ORDER_NEW,1,storyline_new_show_num);

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

}
