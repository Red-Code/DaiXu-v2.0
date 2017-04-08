package team.tab.daixu.service;

import team.tab.daixu.entity.StorylineLabelEntity;

import java.util.List;

/**
 * Created by CLY on 2017/1/3.
 */
public interface StorylineLabelService {
    /**
     * 添加某故事线的标签
     * @param storyline_id 故事线id
     * @param mix_storyline_label 故事线标签（不同标签之间用逗号隔开）
     * @return 是否成功
     */
    Boolean save(long storyline_id,String mix_storyline_label);
}
