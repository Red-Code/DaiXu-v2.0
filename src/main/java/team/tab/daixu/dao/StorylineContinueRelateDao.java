package team.tab.daixu.dao;

import team.tab.daixu.entity.StorylineContinueRelateEntity;

import java.util.List;

/**
 * Created by CLY on 2017/1/3.
 */
public interface StorylineContinueRelateDao {
    void save(StorylineContinueRelateEntity storylineContinueRelateEntity);
    void delete(int id);
    void update(StorylineContinueRelateEntity storylineContinueRelateEntity);
    List<StorylineContinueRelateEntity> findByFrontId(int front_id);//通过某层id，查找出该层所拥有的路线选项id
}
