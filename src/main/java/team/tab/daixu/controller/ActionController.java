package team.tab.daixu.controller;

import org.apache.commons.io.FileUtils;
import org.json.JSONArray;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import team.tab.daixu.entity.*;
import team.tab.daixu.service.*;

import javax.annotation.Resource;
import java.io.File;
import java.util.ArrayList;

/**
 * Created by CLY on 2017/1/5.
 */
@Controller//该注解用来识别控制器
@RequestMapping("action")//该注解用来控制url书写时，控制器的选择
public class ActionController {
    @Resource(name = "AdvService")
    private AdvService advServiceImpl;
    private ArticleDraftService articleDraftServiceImpl;
    private ArticleLabelService articleLabelServiceImpl;
    private ArticleService articleServiceImpl;
    private CollectionService collectionServiceImpl;
    private ContinueService continueServiceImpl;
    private NewsService newsServiceImpl;
    private NoticeService noticeServiceImpl;
    private ReplyService replyServiceImpl;
    private StorylineCommentService storylineCommentServiceImpl;
    private StorylineContinueRelateService storylineContinueRelateServiceImpl;
    private StorylineContinueService storylineContinueServiceImpl;
    private StorylineLabelService storylineLabelServiceImpl;
    private StorylineService storylineServiceImpl;
    private UserService userServiceImpl;
    private JoinArticleContinueService joinArticleContinueServiceImpl;
    private JoinArticleContinueUserService joinArticleContinueUserServiceImpl;
    private JoinContinueUserService joinContinueUserServiceImpl;
    private JoinStorylineCommentUserService joinStorylineCommentUserServiceImpl;

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
        userEntity.setUserName(get_user_name);
        userEntity.setUserPassword(get_password);
        userEntity.setUserEmail(get_email);

        Boolean register_result = userServiceImpl.save(userEntity);

        return String.valueOf(register_result);
    }

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
            @RequestParam(value = "user_password")String get_user_password
    ){
        Boolean result_login = userServiceImpl.actLogin(get_user_email, get_user_password);

        return String.valueOf(result_login);

    }

    /**
     * 退出登录
     * @param get_user_id 用户id
     * @return 结果
     */
    @RequestMapping(value = "/end_login",method = RequestMethod.GET)
    @ResponseBody
    public String end_login(
            @CookieValue("user_id")int get_user_id
    ){
        Boolean result_end_login = userServiceImpl.actEndLogin(get_user_id);

        return String.valueOf(result_end_login);
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
        articleEntity.setArticleName(get_article_name);
        articleEntity.setArticleRule(get_article_rule);
        articleEntity.setArticleContent(get_article_content);
        articleEntity.setArticleJurisdiction(get_article_jurisdiction);
        articleEntity.setArticleAuthor(get_author_id);

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
            Boolean result_save_label = articleLabelServiceImpl.actSave(result_article_entity.getArticleId(),get_article_label);

            return String.valueOf(result_save_label);
        }else {
            return String.valueOf(false);
        }
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
        continueEntity.setContinueHead(get_article_id);
        continueEntity.setContinueAuthor(get_user_id);
        continueEntity.setContinueContent(get_continue_content);

        Boolean result_save_continue = continueServiceImpl.save(continueEntity);

        return String.valueOf(result_save_continue);
    }

    /**
     * 创建故事线首页
     * @param get_storyline_name 故事线名
     * @param get_storyline_label 故事线所属标签（多个标签之间用逗号隔开）
     * @param get_storyline_background 故事线背景交代
     * @param get_storyline_content 故事线第一层正文
     * @param get_storyline_img 故事线封面图
     * @param get_json_array_continue_item 第一层正文后的路线选项（是json格式，一维数组，每一个子选项就是一个支线按钮）
     * @param get_user_id 作者id
     * @return 成功则会返回该故事线id，失败则返回“false”
     */
    @RequestMapping(value = "/publish_storyline_main",method = RequestMethod.GET)
    @ResponseBody
    public String publish_storyline_main(
            @RequestParam(value = "storyline_name")String get_storyline_name,
            @RequestParam(value = "storyline_label")String get_storyline_label,
            @RequestParam(value = "storyline_background")String get_storyline_background,
            @RequestParam(value = "storyline_content")String get_storyline_content,
            @RequestParam(value = "storyline_img")MultipartFile get_storyline_img,
            @RequestParam(value = "json_array_continue_item")String get_json_array_continue_item,
            @CookieValue("user_id")int get_user_id
    ){
        StorylineEntity storylineEntity = new StorylineEntity();
        storylineEntity.setStorylineName(get_storyline_name);
        storylineEntity.setBackground(get_storyline_background);
        storylineEntity.setAuthorId(get_user_id);

        StorylineEntity result_storyline_entity = storylineServiceImpl.save(storylineEntity,get_storyline_img);


        if (result_storyline_entity==null){
            return String.valueOf(false);
        }else {//如果故事线首页存储成功则添加标签
            //添加标签
            Boolean result_save_label = storylineLabelServiceImpl.save(result_storyline_entity.getId(),get_storyline_label);

            /**
             * 关于添加第一层正文和第一组选项的说明：
             * 往数据库里存的时候都是“一个分支选项及该选项的后续发展正文”这样一对存为一条数据。
             * 但第一层正文属于开始层，所以没有分支选项指向它。所以存它的时候只存它，不存分支选项。
             * 该正文会产生出多个分支选项，先将这些分支选项单独都存起来（后面写分支正文后再将分支正文和这些分支选项存一起）。
             *
             * 所以顺序为：先创建分支选项A并存入数据库。之后若写了A选项的后续正文，再将A的后续正文存到“有A选项的记录”的continue_content字段中。
             */
            StorylineContinueEntity storylineContinueEntity = new StorylineContinueEntity();
            storylineContinueEntity.setContinueContent(get_storyline_content);
            storylineContinueEntity.setStorylineId(result_storyline_entity.getId());
            storylineContinueEntity.setWhetherBegin("1");//1表示是起始路线
            Boolean result_save_content = storylineContinueServiceImpl.save(storylineContinueEntity);
            if (!result_save_content){
                return String.valueOf(false);
            }

            //如果为空，则表示没有分支选项，直接完结，不为空则迭代解析json，json格式为["A选项内容","B选项内容","C选项内容"]
            if (get_json_array_continue_item==null){
                StorylineEntity storylineEntity1 = new StorylineEntity();
                storylineEntity1.setWhetherEnd("1");//将该故事线设置为完结
                Boolean result_updata_storyline = storylineServiceImpl.update(storylineEntity1);
                if (!result_updata_storyline){
                    return String.valueOf(false);
                }
            }else {
                try {
                    JSONArray jsonArray = new JSONArray(get_json_array_continue_item);
                    StorylineContinueEntity storylineContinueEntity_item = new StorylineContinueEntity();//用来装新的支线选项
                    storylineContinueEntity_item.setStorylineId(result_storyline_entity.getId());//添加所属故事线id
                    for (int i=0;i<jsonArray.length();i++){
                        String item = jsonArray.getString(i);
                        storylineContinueEntity_item.setItem(item);
                        Boolean result_save_item = storylineContinueServiceImpl.save(storylineContinueEntity_item);
                        if (!result_save_item){
                            return String.valueOf(false);
                        }
                    }
                }catch (Exception e){
                    e.printStackTrace();
                }
            }
        }
        return String.valueOf(result_storyline_entity.getId());
    }

    /**
     * 创建某条故事线的支线内容
     * @param get_storyline_id 故事线id
     * @param get_continue_id 需要被续写的支线选项id
     * @param get_continue_content 支线内容
     * @param get_json_array_continue_item 该支线正文所对应的支线选项（是json格式，一维数组，每一个子选项就是一个支线按钮）。如果没有为null则表示该支线完结
     * @return 是否成功
     */
    @RequestMapping(value = "/publish_storyline_continue",method = RequestMethod.GET)
    @ResponseBody
    public String publish_storyline_continue(
            @RequestParam(value = "storyline_id")int get_storyline_id,
            @RequestParam(value = "continue_id")int get_continue_id,
            @RequestParam(value = "continue_content")String get_continue_content,
            @RequestParam(value = "json_array_continue_item")String get_json_array_continue_item
    ){
        //将老支线选项的支线故事“更新”到数据库
        StorylineContinueEntity storylineContinueEntity_continue = new StorylineContinueEntity();
        storylineContinueEntity_continue.setContinueContent(get_continue_content);

        if (get_json_array_continue_item==null){
            //如果没有新的支线选项，则该支线完结
            storylineContinueEntity_continue.setWhetherEnd("1");
            Boolean result_updata_storyline_continue = storylineContinueServiceImpl.update(get_continue_id,storylineContinueEntity_continue);
            if (!result_updata_storyline_continue){
                return String.valueOf(false);
            }
        }else {
            //将新的支线选项添加到数据库中，解析json，json格式为["A选项内容","B选项内容","C选项内容"]
            try {
                JSONArray jsonArray = new JSONArray(get_json_array_continue_item);
                StorylineContinueEntity storylineContinueEntity_item_new = new StorylineContinueEntity();//用来装新的支线选项
                storylineContinueEntity_item_new.setStorylineId(get_storyline_id);//添加所属故事线id
                for (int i=0;i<jsonArray.length();i++){
                    String item = jsonArray.getString(i);
                    storylineContinueEntity_item_new.setItem(item);
                    Boolean result_save_item = storylineContinueServiceImpl.save(storylineContinueEntity_item_new);
                    if (!result_save_item){
                        return String.valueOf(false);
                    }
                }
            }catch (Exception e){
                e.printStackTrace();
            }
        }
        return String.valueOf(true);
    }
}
