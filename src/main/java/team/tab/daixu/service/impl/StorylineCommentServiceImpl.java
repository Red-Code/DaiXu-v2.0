package team.tab.daixu.service.impl;

import org.springframework.stereotype.Service;
import team.tab.daixu.cons.OrderConstent;
import team.tab.daixu.entity.StorylineCommentEntity;
import team.tab.daixu.service.StorylineCommentService;

import java.util.List;

/**
 * Created by CLY on 2017/1/5.
 */
@Service
public class StorylineCommentServiceImpl implements StorylineCommentService {
    @Override
    public List<StorylineCommentEntity> findMoreByWhere(int storyline_id, Integer now_page, int show_num, OrderConstent time_order) {
        return null;
    }
}
