package team.tab.daixu.dao.impl;

import team.tab.daixu.dao.StorylineDao;
import team.tab.daixu.entity.StorylineEntity;

import java.util.List;

/**
 * Created by CLY on 2017/1/5.
 */
public class StorylineDaoImpl implements StorylineDao {
    @Override
    public StorylineEntity save(StorylineEntity storylineEntity) {
        return null;
    }

    @Override
    public Boolean update(StorylineEntity storylineEntity) {
        return null;
    }

    @Override
    public List<StorylineEntity> findMoreByOrderNews(int limit_begin, Integer rule, int show_num) {
        return null;
    }

    @Override
    public List<StorylineEntity> findMoreByOrderNews(int limit_begin, Integer rule, int show_num, String tag) {
        return null;
    }

    @Override
    public List<StorylineEntity> findMoreByOrderNews(Integer user_id, int limit_begin, int show_num) {
        return null;
    }

    @Override
    public List<StorylineEntity> findMoreByOrderHot(int limit_begin, Integer rule, int show_num) {
        return null;
    }

    @Override
    public List<StorylineEntity> findMoreByOrderHot(int limit_begin, Integer rule, int show_num, String tag) {
        return null;
    }

    @Override
    public List<StorylineEntity> findMoreByOrderHot(int storyline_commend_show_num) {
        return null;
    }

    @Override
    public int findSumByCount() {
        return 0;
    }

    @Override
    public int findSumByCount(Integer user_id) {
        return 0;
    }

    @Override
    public StorylineEntity findOneById(Integer storyline_id) {
        return null;
    }
}
