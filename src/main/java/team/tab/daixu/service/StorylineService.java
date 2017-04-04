package team.tab.daixu.service;

import org.springframework.web.multipart.MultipartFile;
import team.tab.daixu.cons.OrderConstent;
import team.tab.daixu.entity.StorylineEntity;

import java.util.List;

/**
 * Created by CLY on 2017/1/3.
 */
public interface StorylineService {
    /**
     * 存储故事线
     * @param storylineEntity 故事线持久化对象
     * @param storyline_img 故事线封面图
     * @return 存储后的持久化对象(如果没有存储成功会返回null)
     */
    StorylineEntity save(StorylineEntity storylineEntity, MultipartFile storyline_img) throws Exception;

    /**
     * 改
     * @param storylineEntity 故事线持久化对象
     * @return 是否成功
     */
    Boolean update(StorylineEntity storylineEntity);

    /**
     * 根据条件查询出故事线列表（无标签条件）
     * @param now_page 当前页数，1表示第一页
     * @param order 排序顺序
     * @param rule 1表示全部。2表示二万字以下。3表示二万字到十万字。4表示十万字以上
     * @param show_num 展示条数
     * @return 故事线列表
     */
    List<StorylineEntity> findMoreByWhere(Integer now_page, OrderConstent order, Integer rule, int show_num);

    /**
     * 根据条件查询出故事线列表（有标签条件）
     * @param now_page 当前页数，1表示第一页
     * @param order 排序顺序
     * @param rule 1表示全部。2表示二万字以下。3表示二万字到十万字。4表示十万字以上
     * @param show_num 展示页数
     * @param tag 按标签查询的“标签”
     * @return 故事线列表
     */
    List<StorylineEntity> findMoreByWhere(Integer now_page, OrderConstent order, Integer rule,int show_num, String tag);

    /**
     * 根据所有的故事线数，查询出总分页数
     * @param show_num 每页展示文章数
     * @return 总分页数
     */
    int findPageSum(int show_num);

    /**
     * 根据故事线id查询具体某故事线详情
     * @param storyline_id 故事线id
     * @return 某一个故事线详情
     */
    StorylineEntity findOneById(Integer storyline_id);

    /**
     * 根据用户id查询改用户参与的故事线列表
     * @param user_id 用户id
     * @param now_page 当前页数
     * @param time_order 排序规则
     * @param show_num 展示数量
     * @param relate_type 1表示是发布的，2表示是参与的
     * @return
     */
    List<StorylineEntity> findMoreByUser(Integer user_id, int now_page, OrderConstent time_order, int show_num, int relate_type);

    /**
     * 根据用户id查询故事线列表总数
     * @param user_id 用户id
     * @param show_num 展示数量
     * @param relate_type 1表示是发布的，2表示是参与的
     * @return 总页数
     */
    int findPageSumByUser(Integer user_id,int show_num,int relate_type);

    /**
     * 查找推荐的故事线文章
     * @param storyline_commend_show_num 显示条数
     * @return 故事线文章列表8
     */
    List<StorylineEntity> findMoreRecommend(int storyline_commend_show_num);
}
