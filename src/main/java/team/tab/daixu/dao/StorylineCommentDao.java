package team.tab.daixu.dao;

import team.tab.daixu.entity.StorylineCommentEntity;

import java.util.List;

/**
 * Created by CLY on 2017/1/3.
 */
public interface StorylineCommentDao {
    void save(StorylineCommentEntity storylineCommentEntity);
    void delete(int id);
    void update(StorylineCommentEntity storylineCommentEntity);
    List<StorylineCommentEntity> findByStorylineId(int storyline_id);//根据故事线id，查找出该故事线的评论列表
}
