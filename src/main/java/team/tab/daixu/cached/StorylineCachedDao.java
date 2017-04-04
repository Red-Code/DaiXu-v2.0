package team.tab.daixu.cached;

import team.tab.daixu.entity.StorylineEntity;

import java.util.List;

/**
 * Created by CLY on 2017/1/3.
 */
public interface StorylineCachedDao extends BaseCachedDao{
    /**
     * 存储故事线
     * @param storylineEntity 故事线持久化对象
     * @return 存储后的持久化对象(如果没有存储成功会返回null)
     */
    StorylineEntity save(StorylineEntity storylineEntity);

    /**
     * 改
     * @param storylineEntity 故事线持久化对象
     * @return 是否成功
     */
    Boolean update(StorylineEntity storylineEntity);

    /**
     * 根据条件查询出故事线列表。按更新时间从新到旧排序
     * @param limit_begin 起始查询条数
     * @param rule 1表示全部。2表示二万字以下。3表示二万字到十万字。4表示十万字以上
     * @param show_num 查询条数
     * @return 故事线列表
     */
    List<StorylineEntity> findMoreByOrderNews(int limit_begin, Integer rule, int show_num);

    /**
     * 根据条件查询出故事线列表。按更新时间从新到旧排序
     * @param limit_begin 起始查询条数
     * @param rule 1表示全部。2表示二万字以下。3表示二万字到十万字。4表示十万字以上
     * @param show_num 查询条数
     * @param tag 按标签查询的“标签”
     * @return 故事线列表
     */
    List<StorylineEntity> findMoreByOrderNews(int limit_begin, Integer rule, int show_num, String tag);

    /**
     * 根据用户id查询该用户发布的故事线列表
     * @param user_id 用户id
     * @param limit_begin 起始查询条数
     * @param show_num 查询数量
     * @return
     */
    List<StorylineEntity> findMoreByOrderNews(Integer user_id, int limit_begin, int show_num);

    /**
     * 根据条件查询出故事线列表。按观看次数由大到小排序
     * @param limit_begin 起始查询条数
     * @param rule 1表示全部。2表示二万字以下。3表示二万字到十万字。4表示十万字以上
     * @param show_num 查询条数
     * @return 故事线列表
     */
    List<StorylineEntity> findMoreByOrderHot(int limit_begin, Integer rule, int show_num);

    /**
     * 根据条件查询出故事线列表。按观看次数由大到小排序
     * @param limit_begin 起始查询条数
     * @param rule 1表示全部。2表示二万字以下。3表示二万字到十万字。4表示十万字以上
     * @param show_num 查询条数
     * @param tag 按标签查询的“标签”
     * @return 故事线列表
     */
    List<StorylineEntity> findMoreByOrderHot(int limit_begin, Integer rule, int show_num, String tag);

    /**
     * 根据条件查询出故事线列表。按观看次数由大到小排序
     * @param storyline_commend_show_num 查找条数
     * @return 故事线文章列表
     */
    List<StorylineEntity> findMoreByOrderHot(int storyline_commend_show_num);

    /**
     * 通过count查询总条数
     * @return 总数
     */
    int findSumByCount();

    /**
     * 根据用户id查询该用户发布的故事线列表总数
     * @param user_id 用户id
     * @return 总数
     */
    int findSumByCount(Integer user_id);

    /**
     * 根据故事线id查询具体某故事线详情
     * @param storyline_id 故事线id
     * @return 某一个故事线详情
     */
    StorylineEntity findOneById(Integer storyline_id);
}
