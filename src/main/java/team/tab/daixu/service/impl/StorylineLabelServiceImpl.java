package team.tab.daixu.service.impl;

import team.tab.daixu.dao.StorylineLabelDao;
import team.tab.daixu.service.StorylineLabelService;

/**
 * Created by CLY on 2017/1/5.
 */
public class StorylineLabelServiceImpl implements StorylineLabelService {
    private StorylineLabelDao storylineLabelDaoImpl;
    @Override
    public Boolean save(int storyline_id, String mix_storyline_label) {
        String[] array_label = mix_storyline_label.split(",");
        Boolean result_save = storylineLabelDaoImpl.save(storyline_id,array_label);
        return result_save;
    }
}
