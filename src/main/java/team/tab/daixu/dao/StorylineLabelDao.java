package team.tab.daixu.dao;

import team.tab.daixu.entity.StorylineLabelEntity;

import java.util.List;

/**
 * Created by CLY on 2017/1/3.
 */
public interface StorylineLabelDao {
    /**
     * 添加某故事线的标签
     * @param storyline_id 故事线id
     * @param array_storyline_label 一维数组，含有多个标签
     * @return 是否成功
     */
    Boolean save(int storyline_id,String[] array_storyline_label);
}
