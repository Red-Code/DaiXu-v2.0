package team.tab.daixu.service.impl;

import org.springframework.web.multipart.MultipartFile;
import team.tab.daixu.entity.StorylineEntity;
import team.tab.daixu.service.StorylineService;

import java.util.List;

/**
 * Created by CLY on 2017/1/5.
 */
public class StorylineServiceImpl implements StorylineService {
    @Override
    public StorylineEntity save(StorylineEntity storylineEntity, MultipartFile storyline_img) {
        return null;
    }

    @Override
    public Boolean update(StorylineEntity storylineEntity) {
        return null;
    }

    @Override
    public List<StorylineEntity> findMoreByWhere(Integer now_page, String order, Integer rule, int show_num) {
        return null;
    }

    @Override
    public List<StorylineEntity> findMoreByWhere(Integer now_page, String order, Integer rule, int show_num, String tag) {
        return null;
    }

    @Override
    public int findPageSum(int show_num) {
        return 0;
    }

    @Override
    public StorylineEntity findOneById(Integer storyline_id) {
        return null;
    }

    @Override
    public List<StorylineEntity> findMoreByUser(Integer user_id, int now_page, String time_order, int show_num, int relate_type) {
        return null;
    }

    @Override
    public int findPageSumByUser(Integer user_id, int show_num, int relate_type) {
        return 0;
    }

    @Override
    public List<StorylineEntity> findMoreRecommend(int storyline_commend_show_num) {
        return null;
    }
}
