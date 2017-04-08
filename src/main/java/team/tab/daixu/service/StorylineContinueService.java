package team.tab.daixu.service;

import team.tab.daixu.entity.StorylineContinueEntity;

import java.util.List;

/**
 * Created by CLY on 2017/1/3.
 */
public interface StorylineContinueService {
    /**
     * 增
     * @param storylineContinueEntity 持久化类
     * @return 是否成功
     */
    Boolean save(StorylineContinueEntity storylineContinueEntity);

    /**
     * 修改某条记录
     * @param StorylineContinueId 被修改的故事线支线id
     * @param storylineContinueEntity 修改的持久化类
     * @return 是否成功
     */
    Boolean update(long StorylineContinueId,StorylineContinueEntity storylineContinueEntity);

    /**
     * 查询某一篇故事线所拥有的未完结支线
     * @param storyline_id 故事线id
     * @return 持久化类集合
     */
    List<StorylineContinueEntity> findNoEndByStorylineId(int storyline_id);
}
