package team.tab.daixu.dao.impl;

import org.springframework.stereotype.Repository;
import team.tab.daixu.dao.StorylineContinueDao;
import team.tab.daixu.entity.StorylineContinueEntity;

import java.util.List;

/**
 * Created by CLY on 2017/1/5.
 */
@Repository
public class StorylineContinueDaoImpl implements StorylineContinueDao {
    @Override
    public Boolean save(StorylineContinueEntity storylineContinueEntity) {
        return null;
    }

    @Override
    public Boolean update(int StorylineContinueId, StorylineContinueEntity storylineContinueEntity) {
        return null;
    }

    @Override
    public List<StorylineContinueEntity> findNoEndByStorylineId(int storyline_id) {
        return null;
    }
}
