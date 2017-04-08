package team.tab.daixu.controller;

import org.json.JSONArray;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;
import team.tab.daixu.cons.OrderConstent;
import team.tab.daixu.cons.StorylineNumRule;
import team.tab.daixu.entity.StorylineCommentEntity;
import team.tab.daixu.entity.StorylineContinueEntity;
import team.tab.daixu.entity.StorylineEntity;
import team.tab.daixu.entity.UserEntity;
import team.tab.daixu.service.*;
import team.tab.daixu.util.page.PageUtil;

import javax.annotation.Resource;
import java.util.List;

/**
 * Created by CLY on 2017/3/25.
 *
 * 故事线模块控制器
 */
@Controller
@RequestMapping("storyline")
public class StorylineController {
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
     * @param get_rule 1表示全部。2表示二万字以下。3表示二万字到十万字。4表示十万字以上
     * @param get_tag 按标签查询的“标签”
     * @return 故事线分类页
     */
    @RequestMapping(value = "storyline_classify",method = RequestMethod.GET)
    public ModelAndView storyline_classify(
            @RequestParam(value = "now_page",required = false) Integer get_now_page,
            @RequestParam(value = "order",required = false) Character get_order,
            @RequestParam(value = "rule",required = false) Integer get_rule,
            @RequestParam(value = "tag",required = false) String get_tag
    ){
        final int show_num = 12;
        final OrderConstent order;
        final Integer now_page;
        StorylineNumRule storylineNumRule = null;

        switch (get_order){
            case '1':
                order = OrderConstent.ORDER_NEW;
                break;
            case '2':
                order = OrderConstent.ORDER_HOT;
                break;
            default:
                order = OrderConstent.ORDER_NEW;
                break;
        }

        if (get_now_page==null){
            now_page = 1;
        }else {
            now_page = get_now_page;
        }

        if (get_rule==1){
            storylineNumRule = StorylineNumRule.NUM_ALL;
        }else if (get_rule==2){
            storylineNumRule = StorylineNumRule.NUM_LESS;
        }else if (get_rule==3){
            storylineNumRule = StorylineNumRule.NUM_SECONDARY;
        }else if (get_rule==4){
            storylineNumRule = StorylineNumRule.NUM_MORE;
        }else {

        }

        PageUtil show_list_storyline;
        if (get_tag==null){
            show_list_storyline=storylineServiceImpl.findMoreByOrderRule(now_page,order,storylineNumRule,show_num);
        }else {
            show_list_storyline=storylineServiceImpl.findMoreByOrderRuleTag(now_page,order,storylineNumRule,show_num,get_tag);
        }

        mv.setViewName("storyline_classify");
        mv.addObject("order",order);//当前的排序规则
        mv.addObject("rule",get_rule);//当前权限选择
        mv.addObject("list_article",show_list_storyline);//展示的故事线列表
        mv.addObject("paging_now_page",now_page);//当前页数
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
        OrderConstent time_order = OrderConstent.ORDER_NEW;//从最新的评论开始显示

        StorylineEntity show_one_storyline = storylineServiceImpl.findOneById(get_storyline_id);
        UserEntity show_one_author = userServiceImpl.findOneById(show_one_storyline.getAuthorId());
        List<StorylineCommentEntity> show_list_comment = storylineCommentServiceImpl.findMoreByWhere(get_storyline_id, now_page, show_num, time_order);

        mv.setViewName("storyline");
        mv.addObject("one_storyline",show_one_storyline);//该故事线的主要信息
        mv.addObject("one_author",show_one_author);//该故事线创建作者的信息
        mv.addObject("list_comment",show_list_comment);//评论列表详情

        return mv;
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
    ) throws Exception {
        StorylineEntity storylineEntity = new StorylineEntity();
        storylineEntity.setName(get_storyline_name);
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
