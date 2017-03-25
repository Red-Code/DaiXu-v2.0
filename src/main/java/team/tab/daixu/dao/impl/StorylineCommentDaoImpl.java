package team.tab.daixu.dao.impl;

import team.tab.daixu.dao.StorylineCommentDao;
import team.tab.daixu.entity.StorylineCommentEntity;

import java.util.List;

/**
 * Created by CLY on 2017/1/5.
 */
public class StorylineCommentDaoImpl implements StorylineCommentDao {
    @Override
    public void save(StorylineCommentEntity storylineCommentEntity) {

    }

    @Override
    public void delete(int id) {

    }

    @Override
    public void update(StorylineCommentEntity storylineCommentEntity) {

    }

    @Override
    public List<StorylineCommentEntity> findByStorylineId(int storyline_id) {
        return null;
    }

    @Override
    public List<StorylineCommentEntity> findMoreByWhere(int storyline_id, Integer limit_begin, int show_num, String time_order) {
        return null;
    }
}
