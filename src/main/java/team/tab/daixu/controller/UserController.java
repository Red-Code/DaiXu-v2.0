package team.tab.daixu.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import team.tab.daixu.entity.ArticleEntity;
import team.tab.daixu.entity.StorylineEntity;
import team.tab.daixu.entity.UserEntity;
import team.tab.daixu.service.*;
import team.tab.daixu.util.CustomConstent;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.List;

/**
 * Created by CLY on 2017/3/26.
 *
 * 用户模块控制器
 */
@Controller
@RequestMapping("user")
public class UserController {
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
     * 登录
     * @param get_user_email 用户邮箱
     * @param get_user_password 用户密码
     * @return 是否登录成功
     */
    @RequestMapping(value = "/login",method = RequestMethod.GET)
    @ResponseBody
    public String login(
            @RequestParam(value = "user_email")String get_user_email,
            @RequestParam(value = "user_password")String get_user_password,
            HttpServletRequest request,
            HttpServletResponse response
    ){
        Boolean result_login = userServiceImpl.actLogin(get_user_email, get_user_password,request,response);

        return String.valueOf(result_login);

    }

    /**


     */
    /**
     * 退出登录
     * @param request 请求对象
     * @param response 返回对象
     * @return 结果
     */
    @RequestMapping(value = "/end_login",method = RequestMethod.GET)
    @ResponseBody
    public String end_login(
            HttpServletRequest request,
            HttpServletResponse response
    ){
        Boolean result_end_login = userServiceImpl.actEndLogin(request,response);

        return String.valueOf(result_end_login);
    }

    /**
     * 注册用户
     * @param get_user_name 用户名
     * @param get_password 用户密码
     * @param get_email 用户邮箱
     * @return 字符串类型，true表示成功，false表示失败
     */
    @RequestMapping(value="/register",method= RequestMethod.GET)
    @ResponseBody//将内容或对象作为 HTTP 响应正文返回，并调用适合HttpMessageConverter的Adapter转换对象，写入输出流。
    public String register(
            @RequestParam(value = "user_name")String get_user_name,
            @RequestParam(value = "user_password")String get_password,
            @RequestParam(value = "user_email")String get_email
    ) {
        UserEntity userEntity = new UserEntity();
        userEntity.setName(get_user_name);
        userEntity.setPassword(get_password);
        userEntity.setEmail(get_email);

        Boolean register_result = userServiceImpl.save(userEntity);

        return String.valueOf(register_result);
    }

    /**
     * 检查某用户是否能抢接某文章
     * @param get_article_id 文章id
     * @param get_user_id 用户id
     * @return “1”表示能抢接该文章。“2”表示该文章正在被别人续写不能抢接。“3”表示该用户目前被禁言不能抢接
     */
    @RequestMapping(value = "/check_continue",method = RequestMethod.GET)
    @ResponseBody
    public String check_continue(
            @RequestParam(value = "article_id")int get_article_id,
            @CookieValue("user_id")int get_user_id
    ){
        String result_check = articleServiceImpl.checkContinue(get_user_id,get_article_id);

        return result_check;
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
        List<ArticleEntity> show_list_my_article = articleServiceImpl.findMoreByUser(get_user_id, now_page, time_order, show_num, relate_type);
        int sum_page = articleServiceImpl.findPageSumByUser(get_user_id,show_num,relate_type);

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
