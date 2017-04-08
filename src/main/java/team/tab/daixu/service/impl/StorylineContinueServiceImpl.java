package team.tab.daixu.service.impl;

import org.springframework.stereotype.Service;
import team.tab.daixu.dao.StorylineContinueDao;
import team.tab.daixu.entity.StorylineContinueEntity;
import team.tab.daixu.service.StorylineContinueService;

import java.util.List;

/**
 * Created by CLY on 2017/1/5.
 */
@Service
public class StorylineContinueServiceImpl implements StorylineContinueService {
    private StorylineContinueDao storylineContinueDaoImpl;

    @Override
    public Boolean save(StorylineContinueEntity storylineContinueEntity) {
        return storylineContinueDaoImpl.save(storylineContinueEntity);
    }

    @Override
    public Boolean update(long StorylineContinueId, StorylineContinueEntity storylineContinueEntity) {
        return null;
    }

    @Override
    public List<StorylineContinueEntity> findNoEndByStorylineId(int storyline_id) {
        return null;
    }
}
